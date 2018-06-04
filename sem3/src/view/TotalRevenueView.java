/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.RevenueObserver;

/**
 *
 * @author User Sara Debebe
 * This class does not call the controller or any other class, but instead
 * be updated using the Observer pattern
 */
       
public class TotalRevenueView implements RevenueObserver{
    
    private int revenue = 0;
    
    @Override
    public void updateRevenue(int newTotal){
     revenue += newTotal;
     printCurrentState();
     }

    private void printCurrentState() {
    System.out.println("current revenue is" + revenue + "kr.");
}
}

