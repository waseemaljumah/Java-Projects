/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citymarket;


public interface PlacesInterface {
    
    //add new place
    public void add(int id,String type,String image,double price) throws Exception;
    //update the price
    public void updatePrice(int id,double price)throws Exception;
    //delete a place
    public void delete(int id)throws Exception;
    //view place
    public void view(int id)throws Exception;
}
