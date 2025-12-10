package project2;
//project mohammed with javaFx.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

class Program {

    String studentId;
    String firstName;
    String lastName;
    String courseId;
    String courseMark;
    double gpa;

    File student = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Project2\\Student.txt");
    File course = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Project2\\StudentCourse.txt");

    void AddStudent() throws IOException  //Menu 1
    { 

        try {
            Scanner input = new Scanner(System.in);
            FileWriter fw = new FileWriter(student, true);
            PrintWriter ou = new PrintWriter(fw);
            Scanner s = new Scanner(student);
            FileReader f = new FileReader(student);
            BufferedReader b = new BufferedReader(f);
            ArrayList<String> array = new ArrayList<>();

            String ch;
            while (b.readLine() != null) {
                ch = s.next();
                array.add(ch);
                s.nextLine();
            }

            System.out.println("Enter ID new student");
            studentId = input.next();
            if (array.isEmpty()) {
                            System.out.println("Enter First name new student");
                firstName = input.next();
                            System.out.println("Enter last name student");

                lastName = input.next();
                ou.println(studentId + "\t" + firstName + " " + lastName);
                ou.close();
            } else if (!array.contains(studentId)) {
                System.out.println("Enter First name new student");
                firstName = input.next();
                System.out.println("Enter last name student");
                lastName = input.next();
                ou.println(studentId + "\t" + firstName + " " + lastName);
                ou.close();
            } else {
                System.out.println("Student Already Available");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void addCourse() throws IOException //Menu 2
    {

        try {
            Scanner input = new Scanner(System.in);
            FileWriter fw = new FileWriter(course, true);
            PrintWriter ou = new PrintWriter(fw);

            Scanner s = new Scanner(student);
            FileReader f = new FileReader(student);
            BufferedReader b = new BufferedReader(f);
            ArrayList<String> array = new ArrayList<>();

            String ch;
            while (b.readLine() != null) {
                ch = s.next();
                array.add(ch);
                s.nextLine();
            }

            System.out.println("Enter ID student");
            studentId = input.next();
            if (array.contains(studentId)) {
                System.out.println("Enter the new course");
                courseId = input.next();
                ou.println(studentId + "\t" + courseId);
                ou.close();
            } else {
                System.out.println("Student Not Available");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void addMark() throws IOException //Menu 3
    {

        try {
            Scanner input = new Scanner(System.in);

            Scanner s = new Scanner(student);
            FileReader f = new FileReader(student);
            BufferedReader b = new BufferedReader(f);
            ArrayList<String> array = new ArrayList<>();

            Scanner c = new Scanner(course);
            FileReader f1 = new FileReader(course);
            BufferedReader b1 = new BufferedReader(f1);
            ArrayList<String> array1 = new ArrayList<>();

            String ch;
            while (b.readLine() != null) {
                ch = s.next();
                array.add(ch);
                s.nextLine();
            }

            String ch1;
            while (c.hasNext()) {
                ch1 = b1.readLine();
                array1.add(ch1);
                c.nextLine();
            }

            int i = 0;
            boolean tf = false;
            String pa = "C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Project2\\StudentCourse.txt";

            System.out.println("Enter ID student");
            studentId = input.next();
            if (array.contains(studentId)) {
                System.out.println("Enter Course ID");
                courseId = input.next();
                while (i < array1.size()) {
                    if (array1.get(i).contains(studentId) && array1.get(i).contains(courseId)) {
                        System.out.println("Enter mark");
                        courseMark = input.next();
                        String ns = array1.get(i) + "  " + courseMark;
                        methodMark(pa, array1.get(i), ns);
                        tf = true;
                        break;
                    }
                    i++;
                }
                if (tf == false) {
                    System.out.println("Course Not Available");
                }
            } else {
                System.out.println("Student Not Available");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void methodMark(String filePath, String oldString, String newString) 
    {

        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(oldString, newString);
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    void gpa() throws IOException  //Menu 4
    {

        try {
            Scanner input = new Scanner(System.in);

            Scanner s = new Scanner(student);
            FileReader f = new FileReader(student);
            BufferedReader b = new BufferedReader(f);
            ArrayList<String> array = new ArrayList<>();

            Scanner c = new Scanner(course);
            FileReader f1 = new FileReader(course);
            BufferedReader b1 = new BufferedReader(f1);
            ArrayList<String> array1 = new ArrayList<>();

            Scanner s1 = new Scanner(student);
            FileReader f2 = new FileReader(student);
            BufferedReader b2 = new BufferedReader(f2);
            ArrayList<String> array2 = new ArrayList<>();

            Scanner c1 = new Scanner(course);
            FileReader f3 = new FileReader(course);
            BufferedReader b3 = new BufferedReader(f3);
            ArrayList<String> array3 = new ArrayList<>();

            Scanner c2 = new Scanner(course);
            FileReader f4 = new FileReader(course);
            BufferedReader br4 = new BufferedReader(f4);
            ArrayList<String> array4 = new ArrayList<>();

            String ch;
            while (s.hasNext()) {
                ch = b.readLine();
                array.add(ch);
                s.nextLine();
            }

            String ch1;
            while (c.hasNext()) {
                ch1 = b1.readLine();
                array1.add(ch1);
                c.nextLine();
            }

            String ch2;
            while (s1.hasNext()) {
                ch2 = s1.next();
                array2.add(ch2);
                s1.nextLine();
            }
            String ch3;
            while (c1.hasNext()) {
                ch3 = c1.next();
                array3.add(ch3);
                c1.nextLine();
            }

            String ch4;
            while (c2.hasNext()) {
                c2.next();
                c2.next();
                ch4 = c2.next();
                array4.add(ch4);
            }

            int i = 0;
            int j = 0;
            int mark;
            int sum = 0;
            int count = 0;

            System.out.println("Enter ID student");
            studentId = input.next();
            while (i < array.size()) {
                if (!array2.contains(studentId)) {
                    System.out.println("Student Not Available");
                    break;
                }
                if (array2.contains(studentId) && array.get(i).contains(studentId)) {
                    System.out.println(array.get(i));
                    break;
                }
                i++;
            }
            if (array2.contains(studentId)) {
                while (j < array1.size()) {
                    if (array2.contains(studentId) && !array3.contains(studentId)) {
                        break;
                    }
                    if (array3.contains(studentId) && array1.get(j).contains(studentId)) {
                        mark = Integer.parseInt(array4.get(j));
                        sum = sum + mark;
                        count++;
                    }
                    j++;
                }
                if (array3.contains(studentId) && array.get(i).contains(studentId)) {
                    gpa = (double) sum / count;
                    System.out.println("Gpa = " + gpa);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void printCourses() throws IOException  //Menu 5
    {

        try {
            Scanner input = new Scanner(System.in);

            Scanner s = new Scanner(student);
            FileReader f = new FileReader(student);
            BufferedReader b = new BufferedReader(f);
            ArrayList<String> array = new ArrayList<>();

            Scanner c = new Scanner(course);
            FileReader f1 = new FileReader(course);
            BufferedReader b1 = new BufferedReader(f1);
            ArrayList<String> array1 = new ArrayList<>();

            Scanner s1 = new Scanner(student);
            FileReader f2 = new FileReader(student);
            BufferedReader b2 = new BufferedReader(f2);
            ArrayList<String> array2 = new ArrayList<>();

            Scanner c1 = new Scanner(course);
            FileReader f3 = new FileReader(course);
            BufferedReader b3 = new BufferedReader(f3);
            ArrayList<String> array3 = new ArrayList<>();

            String ch;
            while (s.hasNext()) {
                ch = b.readLine();
                array.add(ch);
                s.nextLine();
            }

            String ch1;
            while (c.hasNext()) {
                ch1 = c.next();
                ch1 = c.next();
                array1.add(ch1);
                c.nextLine();
            }

            String ch2;
            while (s1.hasNext()) {
                ch2 = s1.next();
                array2.add(ch2);
                s1.nextLine();
            }

            String ch3;
            while (c1.hasNext()) {
                ch3 = b3.readLine();
                array3.add(ch3);
                c1.nextLine();
            }

            int i = 0;
            int j = 0;

              System.out.println("Enter ID student");
            studentId = input.next();
            if (!array2.contains(studentId)) {
                System.out.println("Student Not Available");
            }
            if (array2.contains(studentId)) {
                while (i < array1.size()) {
                    if (array2.contains(studentId) && array.get(i).contains(studentId)) {
                        System.out.println(array.get(i));
                        break;
                    }
                    i++;
                }
                while (j < array1.size()) {
                    if (array2.contains(studentId) && array3.get(j).contains(studentId)) {
                        System.out.println(array1.get(j));
                    }
                    j++;
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void printStudents() throws IOException  //Menu 6
    {

        try {
            Scanner input = new Scanner(System.in);

            Scanner c = new Scanner(course);
            FileReader f = new FileReader(course);
            BufferedReader b = new BufferedReader(f);
            ArrayList<String> array = new ArrayList<>();

            Scanner c1 = new Scanner(course);
            FileReader f1 = new FileReader(course);
            BufferedReader b1 = new BufferedReader(f1);
            ArrayList<String> array1 = new ArrayList<>();

            Scanner c2 = new Scanner(course);
            FileReader f2 = new FileReader(course);
            BufferedReader b2 = new BufferedReader(f2);
            ArrayList<String> array2 = new ArrayList<>();

            String ch;
            while (c.hasNext()) {
                ch = c.next();
                ch = c.next();
                array.add(ch);
                c.nextLine();
            }

            String ch1;
            while (c1.hasNext()) {
                ch1 = c1.next();
                array1.add(ch1);
                c1.nextLine();
            }

            String ch2;
            while (c2.hasNext()) {
                ch2 = b2.readLine();
                array2.add(ch2);
                c2.nextLine();
            }

            int i = 0;
            
            System.out.println("Enter course ID");

            courseId = input.next();
            if (!array.contains(courseId)) {
                System.out.println("Course Not Available");
            }
            if (array.contains(courseId)) {
                System.out.println("Course id = " + courseId);
            }
            while (i < array2.size()) {
                if (array.contains(courseId) && array2.get(i).contains(courseId)) {
                    System.out.println(array1.get(i));
                }
                i++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

public class Project2 extends Application
{
    public void start(Stage myStage)
    {
        Button bt1 = new Button("Add a new student");
        Button bt2 = new Button("Add course for a student");
        Button bt3 = new Button("Puts course marks for student");
        Button bt4 = new Button("Calculate average mark of a student and show");
        Button bt5 = new Button("Print the course list of a student");
        Button bt6 = new Button("Print the student list of a course");
        
        HBox pane = new HBox();
        pane.setSpacing(20);
        pane.getChildren().addAll(bt1, bt2, bt3, bt4, bt5, bt6);
        
        Scene scene = new Scene(pane, 1450, 100);
        myStage.setScene(scene);
        myStage.show();
       
        
        Program a = new Program();
        
        bt1.setOnAction(e -> 
        {

            try {
                a.AddStudent();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        });
        
         bt2.setOnAction(e -> 
        {

            try {
                a.addCourse();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        });
        
          bt3.setOnAction(e -> 
        {

            try {
                a.addMark();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        });
        
           bt4.setOnAction(e -> 
        {

            try {
                a.gpa();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        });
           
            bt5.setOnAction(e -> 
        {

            try {
                a.printCourses();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        });
            
             bt6.setOnAction(e -> 
        {

            try {
               a.printStudents();
            } catch (IOException ex) {
                System.out.println(ex);
            }

        });
    }    
    public static void main(String[] args) 
    {
        Application.launch();
    }
    
}
