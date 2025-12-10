/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citymarket;

public class Room extends Place{
    private final double service=100;

    @Override
    public void setPrice(double price) {
        this.price=price+service;
    }
    
}
