/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *
 * @author User Sara
 * exception will be thrown if the item in not found .
 */

public class ItemNotFoundException extends Exception{
   private String ID; 
    
   ItemNotFoundException (String itemID) {
           super("The ID"+ itemID + "is not found");
            ID = itemID;
}
    
    public String getID (){
    return ID;
    }
}
