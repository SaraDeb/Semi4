/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;
//för en databas som inte fungerar
/**
 *
 * @author User SAra
 *  exception will be thrown if there is a failure in the data base.
 */
public class ItemRegistryException extends RuntimeException {
    
    public ItemRegistryException (String ID){
        super("database failure, can not access ID:" +ID);
    }
            
    }
