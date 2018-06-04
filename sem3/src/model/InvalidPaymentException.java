/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User Sara 
 * Exception will be thrown if there is an invalid payment, not enough money
 */
public class InvalidPaymentException extends Exception {
    private final int payment;
    private final int price;



  public InvalidPaymentException (int payment, int price) {
           super("The money you paid" + payment + "is not enough" + price + "kr");
           this.payment = payment;
           this.price = price;
           }
   

  
    public int getPrice() {
            return price;
	}
    
    public int getPayment() {
            return payment;
	}
           
   
   
            
    
}
