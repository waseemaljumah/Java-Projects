/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citymarket;

public abstract class Place {
    
    protected int id;
    protected double price;
    
    //abstract method
    public abstract void setPrice(double price);
    
    public double getPrice(){
        return price;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
    }
   
}
