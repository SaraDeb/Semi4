/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import integration.ExternalAccountingSystem;
import integration.ExternalInventorySystem;
import integration.ItemNotFoundException;
import integration.RegistryCreator;
import integration.Printer;
import model.InvalidPaymentException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test for startSale method, 
     */
    @Test
    public void testStartSale() {
        System.out.println("startSale");
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller(regCreator);
        instance.startSale();
    }

    /**
     * Test for enterItemID method, 
     */
    @Test
    public void testEnterItemID() throws ItemNotFoundException {
        System.out.println("enterItemID");
        String itemID = "PS";
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller(regCreator);
        instance.startSale();
        String expResult = "20, pepsi, 20";    //expected result
        String result = instance.enterItemID(itemID);
        assertEquals(expResult, result);
    }
    
    /**
     * test for when all items are registered
     */
    @Test
    public void testEnterItemIDs() throws ItemNotFoundException { //all items registered
        System.out.println("enterItemIDs");
        String itemID1 = "TE";
        String itemID2 = "KB";
        String itemID3 = "PS";
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller(regCreator);
        instance.startSale();
        double expResult = 16.2; //moms
        System.out.println(instance.enterItemID(itemID1));
        System.out.println(instance.enterItemIDAndQuantity(itemID2, 3));
        System.out.println(instance.enterItemID(itemID3));
        System.out.println(instance.enterItemID(itemID3));
        System.out.println(instance.enterItemIDAndQuantity(itemID1, 2));
        System.out.println(instance.enterItemIDAndQuantity(itemID3, 1));
        double result = instance.indicateAllItemsRegistered();
        assertEquals(expResult, result, 0);
    }
    
    /**
     * test for when items are registered
     */
    @Test
     public void testEnterItemIDQuantity1() throws ItemNotFoundException {
        System.out.println("enterItemIDQuantity1");
        String itemID = "PS";
        RegistryCreator regCreator = new RegistryCreator();
        Controller instance = new Controller(regCreator);
        instance.startSale();
        double expResult = 7.2; 
        instance.enterItemID(itemID);
        instance.enterItemID(itemID);
        instance.enterItemIDAndQuantity(itemID,1);
        double result = instance.indicateAllItemsRegistered();
        assertEquals(expResult, result, 0.01);
     }

    /**
     * Test for enterPaidCash method, 
     */
    @Test
    public void testEnterPaidCash() throws ItemNotFoundException, InvalidPaymentException {
        System.out.println("enterPaidCash");
        int paidAmount = 80;
        RegistryCreator regCreator = new RegistryCreator();
        Printer printer = new Printer();
        ExternalInventorySystem  inventory = new ExternalInventorySystem();
        ExternalAccountingSystem accounting  = new ExternalAccountingSystem();
        Controller instance = new Controller(regCreator, printer, inventory, accounting);
        instance.startSale();
        System.out.println(instance.enterItemID("TE"));
        System.out.println(instance.enterItemIDAndQuantity("PS", 3));
        System.out.println(instance.indicateAllItemsRegistered());
        int expResult = 10;
        int result = instance.enterPaidCash(paidAmount);
        assertEquals(expResult, result);
    }
}
