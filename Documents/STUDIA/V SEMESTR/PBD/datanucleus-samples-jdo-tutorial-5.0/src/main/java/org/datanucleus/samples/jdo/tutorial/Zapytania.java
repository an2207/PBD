package org.datanucleus.samples.jdo.tutorial;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

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
	 	oplataList.removeIf(o -> o.getDzienWplaty().after(dataOd) && o.getDzienWplaty().before(dataDo));
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
		oplataList.removeIf(o -> o.getDzienWplaty().after(dataOd) && o.getDzienWplaty().before(dataDo));
		double sum = 0;
		for (Oplata o:oplataList) {
			sum += o.getCennik().getCena();
		}
		return sum;
	}

	//ZAPYTANIE
	//FIXME
	public int queryLiczbaMiejsc(String nazwaRodzaju) {
		Query q = pm.newQuery(Kwatera.class);
		List<Kwatera> kwateraList = (List<Kwatera>) q.execute();
		kwateraList(k -> k.getRodzaj().getNazwa()
		double sum = 0;
		for (Oplata o:kwateraList) {
			sum += o.getCennik().getCena();
		}
		return sum;
	}
}