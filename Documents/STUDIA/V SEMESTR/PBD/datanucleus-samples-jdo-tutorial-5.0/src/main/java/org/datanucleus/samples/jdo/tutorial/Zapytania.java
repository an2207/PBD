package org.datanucleus.samples.jdo.tutorial;

import org.datanucleus.util.MultiMap;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Zapytania{
	PersistenceManager pm;
	Zapytania(PersistenceManager pm) {
		this.pm = pm;
	}

    //ZAPYTANIE
    //ilosc kobiet pochowanych na cmentarzu
	 public int ileKobiet(){     
		 int licznikKobiet=0;
		 Query q = pm.newQuery(Zmarly.class);
         List<Zmarly> results = (List<Zmarly>) q.execute();
         if(!results.isEmpty()){
              ListIterator litr=results.listIterator();
		      while(litr.hasNext()){ 
		         Zmarly z=(Zmarly)litr.next();
		         if(z.isWoman()==true) licznikKobiet++;
              				
		      }
         }  
          return licznikKobiet;
	 }  
	 
	 //ZAPYTANIE
	 //ilosc  pochowanych mezczyzn na cmentarzu
	 public int ileMezczyzn(){     
		 int licznikMezczyzn=0;
		 Query q = pm.newQuery(Zmarly.class);
         List<Zmarly> results = (List<Zmarly>) q.execute();
         if(!results.isEmpty()){
              ListIterator litr=results.listIterator();
		      while(litr.hasNext()){ 
		         Zmarly z=(Zmarly)litr.next();
		         if(z.isWoman()!=true) licznikMezczyzn++;
              				
		      }
         }  
          return licznikMezczyzn;
	 }  
	
	 //ZAPYTANIE
	 //Pogrzeby z podanego przedzialu
	 // Date odDnia - data, od której mamy szukac
	 // Date doDnia - data, do której mamy szukac
	 public List<Pogrzeb> dajPogrzeby(Date odDnia, Date doDnia){
	     // tworzymy liste pusta - pogrzebow  
		 // z tego bedzie wynik naszej metody
		 Query q = pm.newQuery("select from Zmarly " +
                      "where dzienPogrzebu >= dzienParam1 AND dzienPogrzebu <= dzienParam2" +
                      "parameters Date dzienParam1 AND Date dzienParam2"+
                      "");
         ArrayList<Pogrzeb> results = (ArrayList<Pogrzeb>) q.execute(odDnia,doDnia);
		 return results;
     }

     //ZAPYTANIE
	public double querySredniaCena(Date dataOd, Date dataDo) {
	 	Query q = pm.newQuery(Oplata.class);
	 	List<Oplata> oplataList = (List<Oplata>) q.execute();
	 	oplataList.removeIf(o -> o.getDzienWplaty().before(dataOd) && o.getDzienWplaty().after(dataDo));
		double sum = 0;
		for (Oplata o:oplataList) {
			sum += o.getCennik().getCena();
		}
		double avg = sum/oplataList.size();
		return avg;
	}

	//ZAPYTANIE
	public double querySumaOplat(Date dataOd, Date dataDo) {
		Query q = pm.newQuery(Oplata.class);
		List<Oplata> oplataList = (List<Oplata>) q.execute();
		oplataList.removeIf(o -> o.getDzienWplaty().before(dataOd) && o.getDzienWplaty().after(dataDo));
		double sum = 0;
		for (Oplata o:oplataList) {
			sum += o.getCennik().getCena();
		}
		return sum;
	}

	//ZAPYTANIE
	public int queryLiczbaMiejsc(String nazwaRodzaju) {
		Query q = pm.newQuery(Kwatera.class);
		List<Kwatera> kwateraList = (List<Kwatera>) q.execute();
		Kwatera kwatera = kwateraList.stream().filter(k -> k.getRodzaj().getNazwa().equals(nazwaRodzaju)).findFirst().get();
		return kwatera.getLiczbaMsc();
	}

	//ZAPYTANIE
	public double querySredniaWieku() {
		Query q = pm.newQuery(Zmarly.class);
		List<Zmarly> zmarlyList = (List<Zmarly>) q.execute();
		double sum = 0;
		Calendar cal = Calendar.getInstance();
		double age;
		for (Zmarly z:zmarlyList) {
			cal.setTime(z.getDataZgonu());
			age = cal.get(Calendar.YEAR);
			cal.setTime(z.getDataUrodzenia());
			age -= cal.get(Calendar.YEAR);
			sum += age;
		}
		double avg = sum/zmarlyList.size();
		return avg;
	}

	//ZAPYTANIE
	public List<Kwatera> queryKwatery(String imieZmarl, String nazwZmarl) {
		Query q = pm.newQuery(Oplata.class);
		List<Oplata> oplataList = (List<Oplata>) q.execute();
		oplataList = oplataList.stream().filter(o -> (o.getZmarly().getImie().equals(imieZmarl)) && (o.getZmarly().getNazwisko().equals(nazwZmarl))).collect(Collectors.toList());
		List<Kwatera> kwateraList = new ArrayList<>();
		oplataList.stream().forEach(o -> kwateraList.add(o.getKwatera()));
		return kwateraList;
	}

	//ZAPYTANIE
	public List<Cennik> queryNajczestszaOferta() {
		Query q = pm.newQuery(Oplata.class);
		List<Oplata> oplataList = (List<Oplata>) q.execute();
		Map<Cennik, Integer> cennikIleRazyMap = new HashMap<>();
		for (Oplata o:oplataList) {
			cennikIleRazyMap.put(o.getCennik(), cennikIleRazyMap.getOrDefault(o.getCennik(), 0)+1);
		}
		int max = Collections.max(cennikIleRazyMap.entrySet(), (e1, e2) -> e1.getValue() - e2.getValue()).getValue();
		List<Cennik> cennikList = cennikIleRazyMap.entrySet().stream().filter(e -> e.getValue().equals(max)).map(e -> e.getKey()).collect(Collectors.toList());
		return cennikList;
	}

	//ZAPYTANIE
	public double querySredniCzasZlecenia() {
		Query q = pm.newQuery(Zlecenie.class);
		List<Zlecenie> zlecenieList = (List<Zlecenie>) q.execute();
		double sum = 0;
		for (Zlecenie z:zlecenieList) {
			Long time = z.getDataZak().getTime() - z.getDataRozp().getTime();
			sum += ChronoUnit.DAYS.between(z.getDataZak().toInstant(), z.getDataRozp().toInstant());
		}
		double avg = sum/zlecenieList.size();
		return avg;
	}

	//ZAPYTANIE
	public int queryIleOsobWKwaterze(int nrSektora, int nrKwatery) {
		Query q = pm.newQuery(Oplata.class);
		List<Oplata> oplataList = (List<Oplata>) q.execute();
		oplataList = oplataList.stream().filter(o -> (o.getKwatera().getNrSektora() == nrSektora) && (o.getKwatera().getNrKwatery() == nrKwatery)).collect(Collectors.toList());
		Map<Kwatera, Integer> kwateraIleOsobMap = new HashMap<>();
		for (Oplata o:oplataList) {
			kwateraIleOsobMap.put(o.getKwatera(), kwateraIleOsobMap.getOrDefault(o.getKwatera(), 0)+1);
		}
		int liczbaOsob = kwateraIleOsobMap.get(oplataList.get(0).getKwatera());
		return liczbaOsob;
	}
}