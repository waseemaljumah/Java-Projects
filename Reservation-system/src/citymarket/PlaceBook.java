/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citymarket;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PlaceBook extends Application implements PlacesInterface{
    private static String path="places/";
    private static String imagePath="images/";
    private ImageView imageV;
    private Scene scene;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        //Buttons
        Button add = new Button("add");
        add.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog input=new TextInputDialog();
                input.setHeaderText("Enter id");
                input.showAndWait();
                int id=Integer.parseInt(input.getEditor().getText());
                //type
                TextInputDialog input1=new TextInputDialog();
                input1.setHeaderText("Enter type");
                input1.showAndWait();
                String type=input1.getEditor().getText();
                //image
                TextInputDialog input3=new TextInputDialog();
                input3.setHeaderText("Enter image name");
                input3.showAndWait();
                String image=input3.getEditor().getText();
                //price
                TextInputDialog input2=new TextInputDialog();
                input2.setHeaderText("Enter price");
                input2.showAndWait();
                double price=Double.parseDouble(input2.getEditor().getText());
                try {
                    add(id,type,image,price);
                } catch (Exception ex) {
                    Alert a=new Alert(Alert.AlertType.ERROR);
                    a.setContentText(ex.getMessage());
                    a.show();
                }
            }
        });
        
        Button updatePrice = new Button("update");
        updatePrice.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog input=new TextInputDialog();
                input.setHeaderText("Enter id");
                input.showAndWait();
                int id=Integer.parseInt(input.getEditor().getText());
                //price
                TextInputDialog input2=new TextInputDialog();
                input2.setHeaderText("Enter price");
                input2.showAndWait();
                double price=Double.parseDouble(input2.getEditor().getText());
                try{
                    updatePrice(id, price);
                }
                catch(Exception ex){
                    Alert a=new Alert(Alert.AlertType.ERROR);
                    a.setContentText(ex.getMessage());
                    a.show();
                }
            }
        });
                
        Button delete = new Button("delete");
        delete.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog input=new TextInputDialog();
                input.setHeaderText("Enter id");
                input.showAndWait();
                int id=Integer.parseInt(input.getEditor().getText());
                try {
                    delete(id);
                } catch (Exception ex) {
                    Alert a=new Alert(Alert.AlertType.ERROR);
                    a.setContentText(ex.getMessage());
                    a.show();
                }
            }
        });
        
        Button view = new Button("view");
        view.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog input=new TextInputDialog();
                input.setHeaderText("Enter id");
                input.showAndWait();
                int id=Integer.parseInt(input.getEditor().getText());
                try {
                    view(id);
                } catch (Exception ex) {
                    Alert a=new Alert(Alert.AlertType.ERROR);
                    a.setContentText(ex.getMessage());
                    a.show();
                }
            }
        });
        
        Button reservision = new Button("reservision");
        reservision.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                //id
                TextInputDialog input=new TextInputDialog();
                input.setHeaderText("Enter id");
                input.showAndWait();
                int id=Integer.parseInt(input.getEditor().getText()); 
                //days number
                TextInputDialog input2=new TextInputDialog();
                input2.setHeaderText("Enter days number");
                input2.showAndWait();
                int days=Integer.parseInt(input2.getEditor().getText());
                try {
                    File file=new File(path+id + ".txt");
                    String data=readFile(file);
                    String [] placeArr=data.split("\n");
                    String type=placeArr[1];                   
                    Place place=new Room();
                    switch(type){
                        case "room":place=new Room();break;
                        case "suite":place=new Suite();break;
                        case "department":place=new Apartment();break;
                    }
                    place.setId(id);
                    place.setPrice(Double.parseDouble(placeArr[3]));
                    Reservision reservision=new Reservision(place,days);
                    double price=reservision.calculatePrice();
                    reservision.print(id, type, price);
                    Alert a=new Alert(Alert.AlertType.CONFIRMATION);
                    a.setContentText("price is: "+price);
                    a.show();
                } catch (Exception ex) {
                    Alert a=new Alert(Alert.AlertType.ERROR);
                    a.setContentText(ex.getMessage());
                    a.show();
                }
            }
        });
        
        
        Button back = new Button("back");
        back.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene);
            }
        });
        
        Button cancel = new Button("cancel");
        cancel.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog input=new TextInputDialog();
                input.setHeaderText("Enter id");
                input.showAndWait();
                int id=Integer.parseInt(input.getEditor().getText());
                try {
                    Reservision r=new Reservision();
                    r.cancel(id);
                } catch (Exception ex) {
                    Alert a=new Alert(Alert.AlertType.ERROR);
                    a.setContentText(ex.getMessage());
                    a.show();
                }
            }
        });
        
        //Reservision screen
        Pane pane2 = new Pane();
        FlowPane f1=new FlowPane();
        f1.setVgap(6);
        f1.setHgap(7);
        f1.setPrefWrapLength(580);
        f1.setLayoutX(10);
        f1.setLayoutY(10);
        //
        ScrollPane s=new ScrollPane();    
        s.setContent(f1);
        s.setPrefHeight(300);
        s.setPrefWidth(580);
        s.setLayoutX(10);
        s.setLayoutY(10);
        s.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        pane2.getChildren().add(s);
        //
        reservision.setLayoutX(200);
        reservision.setLayoutY(350);
        cancel.setLayoutX(300);
        cancel.setLayoutY(350);
        back.setLayoutX(500);
        back.setLayoutY(350);
        pane2.getChildren().add(reservision);
        pane2.getChildren().add(cancel);
        pane2.getChildren().add(back);
        //
        File dir=new File("places");        
        
        Scene scene2 = new Scene(pane2, 600, 400);
        
        Button go = new Button("book");
        go.setOnAction(new EventHandler<ActionEvent>() {           
            @Override
            public void handle(ActionEvent event) {
                f1.getChildren().clear();
                for(File file:dir.listFiles()){
                    try {                        
                        String data=readFile(file);
                        String [] place=data.split("\n");
                        String image=imagePath+place[2];
                        ImageView imagev=new ImageView(image);
                        imagev.setFitHeight(200);
                        imagev.setFitWidth(270);
                        //
                        imagev.setLayoutX(0);
                        imagev.setLayoutY(0);
                        Text text=new Text();
                        text.setText("ID: "+place[0]+"\n"+"Type: "+place[1]+"\n"+"Price per day: "+place[3]);
                        //
                        text.setLayoutX(10);
                        text.setLayoutY(220);
                        Pane pane=new Pane();
                        pane.getChildren().add(imagev);
                        pane.getChildren().add(text);
                        f1.getChildren().add(pane);
                    } catch (IOException ex) {
                        Alert a=new Alert(Alert.AlertType.ERROR);
                        a.setContentText(ex.getMessage());
                        a.show();
                    }
                }
                primaryStage.setScene(scene2);
            }
        });
               
        imageV=new ImageView(imagePath+"1.jpg");
        imageV.setFitHeight(300);
        imageV.setFitWidth(400);
        imageV.setLayoutX(50);
        imageV.setLayoutY(50);
        
        //Buttons width
        add.setPrefWidth(90);
        updatePrice.setPrefWidth(90);
        delete.setPrefWidth(90);
        view.setPrefWidth(90);
        go.setPrefWidth(90);
        //Buttons positions
        //X
        add.setLayoutX(500);
        updatePrice.setLayoutX(500);
        delete.setLayoutX(500);
        view.setLayoutX(500);
        go.setLayoutX(500);
        //Y
        add.setLayoutY(50);
        updatePrice.setLayoutY(100);
        delete.setLayoutY(150);
        view.setLayoutY(200);
        go.setLayoutY(250);
        
        Pane root = new Pane();
        root.getChildren().add(add);
        root.getChildren().add(updatePrice);
        root.getChildren().add(delete);
        root.getChildren().add(view);
        root.getChildren().add(imageV);
        root.getChildren().add(go);
        
        scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("City Market");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void add(int id,String type,String image,double price) throws Exception {
        print(id,type,image,price);
    }

    @Override
    public void updatePrice(int id,double price)throws Exception {
        File file=new File(path+id + ".txt");
        if(file.exists()){
            String data=readFile(file);
            String [] place=data.split("\n");
            file.delete();
            print(id,place[1],place[2],price);
        }
        else{
            throw new PlaceNotFoundException();
        }
    }   

    @Override
    public void delete(int id)throws Exception {
        File file=new File(path+id + ".txt");
        if(file.exists()){
            file.delete();
        }
        else{
            throw new PlaceNotFoundException();
        }
    }

    @Override
    public void view(int id)throws Exception {
        File file=new File(path+id + ".txt");
        if(file.exists()){
            String data=readFile(file);
            String [] place=data.split("\n");
            String image=imagePath+place[2];
            imageV.setImage(new Image(image));
        }
        else{
            throw new PlaceNotFoundException();
        }
    }
    
    static String readFile(File file) throws FileNotFoundException, IOException{   
        InputStream in=new FileInputStream(file);
        int c;
        String result="";
        while((c=in.read())!=-1)
           result+=(char)c;
        in.close();
        return result;
    }

    public static void print(int id,String type,String image,double price) throws FileNotFoundException{
        PrintWriter out = new PrintWriter(path+id + ".txt");
        out.println(id+"\n"+type+"\n"+image+"\n"+price);
        out.close();
    }
}
