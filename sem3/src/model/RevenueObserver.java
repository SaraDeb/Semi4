/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User Sara Debebe
 * A listener interface for receiving notifications about the sale.
 */


public interface RevenueObserver {
    /**
     * 
     * @param newTotal  new running total
     */
             void updateRevenue (int newTotal);
    
}





