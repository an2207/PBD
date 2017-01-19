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
        testujZapytania(pm);
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
}
