
package integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ItemRegistryTest {
    
    public ItemRegistryTest() {
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
     * Test for findItem method, for the tee
     */
    @Test
    public void testFindTE() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "TE";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = instance.getItem(0);
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
    }
    
    
    /**
     *Test for findItem method, for the cinnamon roll 
     */
    @Test
    public void testFindKB() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "KB";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = instance.getItem(1);
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
    }
    
    /**
     * Test for findItem method, for the pepsi
     */
    
    @Test
    public void testFindPS() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "PS";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = instance.getItem(2);
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
    }
    
    /**
     * Test for findItem method, when the id is wrong,(for other item)
     */
    @Test
    public void testFindWrongID() throws ItemNotFoundException {
        System.out.println("findItem");
        String itemID = "WrongID";
        ItemRegistry instance = new ItemRegistry();
        ItemDTO expResult = null;
        ItemDTO result = instance.findItem(itemID);
        assertEquals(expResult, result);
    }
}
