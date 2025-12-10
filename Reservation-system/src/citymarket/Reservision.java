/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citymarket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Reservision {
    private Place p;
    private int days;
    private double price;
    
    public Reservision(){
        
    }
    
    public Reservision(Place p,int days){
        this.days=days;
        this.p=p;
    }
    
    public double calculatePrice(){
        return days*p.price;
    }
    
    public void print(int id,String type,double price) throws FileNotFoundException, PlaceAlreadyReservedException{
        File file=new File("reserved/"+id + ".txt");
        if(file.exists()){
            throw new PlaceAlreadyReservedException();
        }
        else{
            PrintWriter out = new PrintWriter("reserved/"+id + ".txt");
            out.println(id+"\n"+type+"\n"+price);
            out.close();
        }
    }
    
    public void cancel(int id) throws ReservisionNotFoundException{
        File file=new File("reserved/"+id + ".txt");
        if(file.exists()){
            file.delete();
        }
        else{
            throw new ReservisionNotFoundException();
        }
    }
    
}
