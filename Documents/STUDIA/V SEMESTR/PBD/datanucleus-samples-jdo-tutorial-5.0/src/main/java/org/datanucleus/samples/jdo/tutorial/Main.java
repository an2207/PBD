/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package org.datanucleus.samples.jdo.tutorial;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

/**
 * Controlling application for the DataNucleus Tutorial using JDO.
 * Relies on the user defining a file "datanucleus.properties" to be in the CLASSPATH
 * and to include the JDO properties for the DataNucleus PersistenceManager.
 */
public class Main
{
    public static void main(String args[])
    {
        // Create a PersistenceManagerFactory for this datastore
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Tutorial");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistence of a Product and a Book.
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        Object inventoryId = null;
        try
        {
            tx.begin();
            System.out.println("Persisting Inventory of products");
            Inventory inv = new Inventory("My Inventory");
            Product product = new Product("Sony Discman","A standard discman from Sony",200.00);
            Book book = new Book("Lord of the Rings by Tolkien","The classic story",49.99,"JRR Tolkien", "12345678", "MyBooks Factory");
            inv.getProducts().add(product);
            inv.getProducts().add(book);
            pm.makePersistent(inv);
 
            tx.commit();
            inventoryId = pm.getObjectId(inv);
            System.out.println("Inventory, Product and Book have been persisted");
        }
        catch (Exception e)
        {
            System.out.println("Exception persisting data : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");

        // Basic Extent of all Products
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Retrieving Extent for Products");
            Extent e = pm.getExtent(Product.class, true);
            Iterator iter = e.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                System.out.println(">  " + obj);
            }
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception thrown during retrieval of Extent : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");

        // Perform some query operations
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Executing Query for Products with price below 150.00");
            Query q=pm.newQuery("SELECT FROM " + Product.class.getName() + 
                " WHERE price < 150.00 ORDER BY price ASC");
            List<Product> products = (List<Product>)q.execute();
            Iterator<Product> iter = products.iterator();
            while (iter.hasNext())
            {
                Product p = iter.next();
                System.out.println(">  " + p);

                // Give an example of an update
                if (p instanceof Book)
                {
                    Book b = (Book)p;
                    b.setDescription("This book has been reduced in price!");
                }
            }

            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception performing queries : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");

        // Clean out the database
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();

            System.out.println("Retrieving Inventory using its id");
            Inventory inv = (Inventory)pm.getObjectById(inventoryId);

            System.out.println("Clearing out Inventory");
            inv.getProducts().clear();

            System.out.println("Deleting Inventory");
            pm.deletePersistent(inv);

            System.out.println("Deleting all products from persistence");
            Query q = pm.newQuery(Product.class);
            long numberInstancesDeleted = q.deletePersistentAll();
            System.out.println("Deleted " + numberInstancesDeleted + " products");

            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception cleaning out the database : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }

        
         pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
                try
        {
            tx.begin();
            System.out.println("dodajemy adres");
            Adres adr = new Adres("ta ulica ma ponad szescdziesiat cztery znaki tak sadze a jednak nie tam gdzie dziecielina pala jak swierzop gryka biala");
            
            pm.makePersistent(adr);
 
            tx.commit();
            System.out.println(adr.getAdresId());
            
        }
        catch (Exception e)
        {
            System.out.println("Exception persisting data : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");
        
         pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Osoba fizyczna");
            OsobaFizyczna osoba = new OsobaFizyczna("Marcin","Mateusz","Wisniewski","Imie","01234567892","tojestemail");
           
            
            pm.makePersistent(osoba);
 
            
            System.out.println(osoba.getPesel());
            osoba.setPesel("nachiczewan");
            osoba.setPesel("333");
            osoba.setPesel("18181818");
            System.out.println(osoba.getPesel());
            
            OsobaFizyczna osoba2 = new OsobaFizyczna();
            pm.makePersistent(osoba2);
 
            
            System.out.println(osoba2.getPesel());
            osoba2.setPesel("69");
            System.out.println(osoba2.getPesel());
            tx.commit();
        }
        catch (Exception e)
        {
            System.out.println("Exception persisting data : " + e.getMessage());
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");
        
        
        System.out.println("");
        
        
        System.out.println("");

        pm = pmf.getPersistenceManager();
        //testujZapytania(pm);
        pm.close();
        System.out.println("End of Tutorial");
        pmf.close();
    }

    private static void testujZapytania(PersistenceManager pm) {
        Zapytania zapytania = new Zapytania(pm);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dataUrodzeniaStr = "05-12-1950";
        String dataZgonuStr = "04-12-2015";

        Date dataUrodzenia = null;
        Date dataZgonu = null;
        try {
            dataUrodzenia = sdf.parse(dataUrodzeniaStr);
            dataZgonu = sdf.parse(dataZgonuStr);
        }
        catch (Exception e) {}

        Zmarly zmarly = new Zmarly("", dataUrodzenia, dataZgonu, new ArrayList<>(), null, "Michał", "Damian", "Kowalski", "", "50129205934", "", "");
        pm.makePersistent(zmarly);
        zmarly = new Zmarly("", dataUrodzenia, dataZgonu, new ArrayList<>(), null, "Maria", "", "Nowak", "", "50129673454", "", "");
        pm.makePersistent(zmarly);
        System.out.println("Ile kobiet: " + zapytania.ileKobiet());
        System.out.println("Ile mezczyzn: " + zapytania.ileMezczyzn());

        String dataOdStr = "05-12-1950";
        String dataDoStr = "04-12-2015";
        try {
            Date dataOd = sdf.parse(dataOdStr);
            Date dataDo = sdf.parse(dataDoStr);
        }
        catch (Exception e) {}


    }

    private static void wypelnijBaze(PersistenceManager pm) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        //ADRES
        List list = new ArrayList();
        list.add(new Adres("Litewska", "42", "3", "51-354", "Wrocław", "Polska"));
        list.add(new Adres("Plac Grunwaldzki", "15a", "6", "51-500", "Wrocław", "Polska"));
        for(Object o:list) {
            pm.makePersistent(o);
        }

        //AKT ZGONU
        list = new ArrayList();
        list.add(new AktZgonu("1242523", sdf.parse("15-05-2005"), new Time(1230195710), "Adam", "Barnaba", "Joanna", "Barnaba"));
        list.add(new AktZgonu("51362346", sdf.parse("15-05-2005"), new Time(1524621361), "Krzysztof", "Pomusz", "Grażyna", "Pomusz"));
        for(Object o:list) {
            pm.makePersistent(o);
        }

        //CENNIK
        Cennik cennik;
        cennik = new Cennik(1500., 10);
        pm.makePersistent(cennik);
        cennik = new Cennik(2000., 15);
        pm.makePersistent(cennik);
        cennik = new Cennik(3000., 20);
        pm.makePersistent(cennik);
        cennik = new Cennik(4500., 30);
        pm.makePersistent(cennik);

        //FUNKCJA
        Funkcja funkcja;
        funkcja = new Funkcja("Grabarz");
        pm.makePersistent(funkcja);
        funkcja = new Funkcja("Ogrodnik");
        pm.makePersistent(funkcja);
        funkcja = new Funkcja("Sprzątacz");
        pm.makePersistent(funkcja);

        //KWATERA
        Kwatera kwatera;
        kwatera = new Kwatera(3,15,3,new RodzajKwatery("asda")); //FIXME
        pm.makePersistent(kwatera);
        kwatera = new Kwatera(6,2,2,new RodzajKwatery("asda")); //FIXME
        pm.makePersistent(kwatera);
        kwatera = new Kwatera(18,6,5,new RodzajKwatery("asda")); //FIXME
        pm.makePersistent(kwatera);

        //OPLATA
        Oplata oplata;



        //OSOBA
        Osoba osoba;
        osoba = new Osoba("osoba@osobohost.com", "725993023");
        pm.makePersistent(osoba);
        osoba = new Osoba("andrzej@gmail.com");
        pm.makePersistent(osoba);
        osoba = new Osoba("danuta@grazynnki.pl", "75345235");
        pm.makePersistent(osoba);
        osoba = new Osoba("ogier@podrywacze.pl");
        pm.makePersistent(osoba);

        //OSOBA FIZYCZNA
        OsobaFizyczna osobaFizyczna;
        osobaFizyczna = new OsobaFizyczna("Grzegorz", "", "Kowal", "", "88203482039", "osoba@osobohost.com", "725236437");
        pm.makePersistent(osobaFizyczna);
        osobaFizyczna = new OsobaFizyczna("Andrzej", "", "Makłowicz", "", "76920902935", "andrzej@gmail.com", "725236437");
        pm.makePersistent(osobaFizyczna);
        osobaFizyczna = new OsobaFizyczna("Danuta", "", "Andruta", "", "69051569699", "danuta@grazynki.pl", "696969696");
        pm.makePersistent(osobaFizyczna);

        //OSOBA PRAWNA
    }
}

