
package model;

import integration.ItemDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class SaleTest {
    
    public SaleTest() {
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
     * Test of addItem method, 
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        ItemDTO registeredItem = new ItemDTO(10, "te", 0.12, "TE");
        Sale instance = new Sale();
        String expResult = "10, te, 10";
        String result = instance.addItem(registeredItem);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of adding an item twice, 
     */
    @Test
    public void testAddItemTwice() {
        System.out.println("addItemTwice");
        ItemDTO registeredItem = new ItemDTO(10, "te", 0.12, "TE");
        Sale instance = new Sale();
        String expResult = "10, te, 20";
        instance.addItem(registeredItem);
        String result = instance.addItem(registeredItem);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of adding two different items.
     */
    @Test
    public void testAddItemDifferent() {
        System.out.println("addItemDifferent");
        ItemDTO registeredItem1 = new ItemDTO(10, "te", 0.12, "TE");
        ItemDTO registeredItem2 = new ItemDTO(15, "kanelbulle", 0.12, "KB");
        Sale instance = new Sale();
        String expResult = "15, kanelbulle, 25";
        instance.addItem(registeredItem1);
        String result = instance.addItem(registeredItem2);
        assertEquals(expResult, result); 
    }
    
    /**
     * test of adding items
     */
    @Test
    public void testAddItems() {
        System.out.println("addItems");
        ItemDTO registeredItem = new ItemDTO(10, "te", 0.12, "TE");
        Sale instance = new Sale();
        String expResult = "10, te, 30";
        String result = instance.addItems(registeredItem, 3);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddItemsTwice() {
        System.out.println("addItemsTwice");
        ItemDTO registeredItem = new ItemDTO(10, "te", 0.12, "TE");
        Sale instance = new Sale();
        String expResult = "10, te, 40";
        instance.addItems(registeredItem, 2);
        String result = instance.addItems(registeredItem, 2);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddItemAndItems() {
        System.out.println("addItemAndItems");
        ItemDTO registeredItem = new ItemDTO(10, "te", 0.12, "TE");
        Sale instance = new Sale();
        String expResult = "10, te, 30";
        instance.addItem(registeredItem);
        String result = instance.addItems(registeredItem, 2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddItemsAndItem() {
        System.out.println("addItemsandItem");
        ItemDTO registeredItem = new ItemDTO(10, "te", 0.12, "TE");
        Sale instance = new Sale();
        String expResult = "10, te, 30";
        instance.addItems(registeredItem, 2);
        String result = instance.addItem(registeredItem);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddDifferentItems() {
        System.out.println("addDifferentItems");
        ItemDTO registeredItem1 = new ItemDTO(10, "te", 0.12, "TE");
        ItemDTO registeredItem2 = new ItemDTO(15, "kanelbulle", 0.12, "KB");
        Sale instance = new Sale();
        String expResult = "15, kanelbulle, 35";
        instance.addItems(registeredItem1, 2);
        String result = instance.addItem(registeredItem2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test for calculateTaxes method, from <code> Sale</code>
     */
    @Test
    public void testCalculateTaxes() {
        System.out.println("calculateTaxes");
        ItemDTO registeredItem = new ItemDTO(10, "te", 0.12, "TE");
        Sale instance = new Sale();
        instance.addItem(registeredItem);
        double expResult = 1.2;
        double result = instance.calculateTaxes();
        assertEquals(expResult, result, 0);
    }
    
    /**
     * Test for calculateTaxesMultiple method, with multiple items.
     */
    @Test
    public void testCalculateTaxesMultiple() {
        System.out.println("calculateTaxesMultiple");
        ItemDTO registeredItem1 = new ItemDTO(10, "te", 0.12, "TE");
        ItemDTO registeredItem2 = new ItemDTO(15, "kanelbulle", 0.12, "KB");
        Sale instance = new Sale();
        instance.addItem(registeredItem1);
        instance.addItem(registeredItem2);
        double expResult = 3.0;
        double result = instance.calculateTaxes();
        assertEquals(expResult, result, 0);
    }
    
    
    /**
     * Test for calculateTaxes method,  when there is no item
     */
    @Test
    public void testCalculateTaxesNone() {
        System.out.println("calculateTaxesNone");
        Sale instance = new Sale();
        double expResult = 0;
        double result = instance.calculateTaxes();
        assertEquals(expResult, result, 0);
    }
}
