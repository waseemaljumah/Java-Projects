package project_programing2;
//my project with javaFx.

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Exception;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//import static test1.Add_Course_Mark.modifyFile;


class InformationVariables // SuperClass
{

    String student_id; //Data fields for menu 1
    String first_name; //Data fields for menu 1
    String last_name; //Data fields for menu 1

    String course_id; //Data fields for menu 2

    String course_mark; //Data fields for menu 3

    double gpa; //Data fields for menu 4

    File fs = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\project_programing2\\Student.txt");
    File fsc = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\project_programing2\\StudentCourse.txt");
    String path = "C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\project_programing2\\StudentCourse.txt";


    static void methodAddMark(String filePath, String oldString, String newString) {
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
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {

                reader.close();

                writer.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}

class ProgramMenu extends InformationVariables // Inheritance(SubClass) // All Menu 
{

    void addNewStudent() throws Exception // Menu Item 1
    {

        try {
            Scanner in = new Scanner(System.in);
            FileWriter fW = new FileWriter(fs, true);
            PrintWriter print = new PrintWriter(fW);
            Scanner s = new Scanner(fs);
            FileReader frs = new FileReader(fs);
            BufferedReader brs = new BufferedReader(frs);
            ArrayList<String> arrayS = new ArrayList<>();

            String ch;
            while (brs.readLine() != null) {
                ch = s.next();
                arrayS.add(ch);
                s.nextLine();
            }

            System.out.println("•ENTER THE NEW STUDENT NUMBER: ");
            super.student_id = in.next();

            if (arrayS.isEmpty()) {

                System.out.println("\n•ENTER THE FIRST NAME OF THE NEW STUDENT: ");
                super.first_name = in.next();
                System.out.println("•ENTER THE LAST NAME OF THE NEW STUDENT: ");
                super.last_name = in.next();

                //print.println("Student ID \t" + "First Name" + "\tLast Name");//
                //print.println(super.student_id + "\t\t" + super.first_name + "\t\t" + super.last_name);//
                print.println(super.student_id + "\t" + super.first_name + " " + super.last_name);
                System.out.println("\nThe new student has been successfully added ✔ \n");
                print.close();

            } else if (!arrayS.contains(student_id)) {

                System.out.println("\n•ENTER THE FIRST NAME OF THE NEW STUDENT: ");
                super.first_name = in.next();
                System.out.println("•ENTER THE LAST NAME OF THE NEW STUDENT: ");
                super.last_name = in.next();

                //print.println(super.student_id + "\t\t" + super.first_name + "\t\t" + super.last_name);//
                print.println(super.student_id + "\t" + super.first_name + " " + super.last_name);
                System.out.println("\nThe new student has been successfully added ✔ \n");
                print.close();

            } else {

                System.out.println("\n*Student Already Available* \n");

            }
        } catch (Exception e) {

            System.out.println(e);  } }

    void addNewCourse() throws Exception // Menu Item 2
    {

        try {
            Scanner in = new Scanner(System.in);
            FileWriter fW = new FileWriter(fsc, true);
            PrintWriter print = new PrintWriter(fW);

            Scanner s = new Scanner(fs);
            FileReader frs = new FileReader(fs);
            BufferedReader brs = new BufferedReader(frs);
            ArrayList<String> arrayS = new ArrayList<>();

            Scanner c = new Scanner(fsc);
            FileReader frc = new FileReader(fsc);
            BufferedReader brc = new BufferedReader(frc);
            ArrayList<String> arrayC = new ArrayList<>();

            String ch;
            while (brs.readLine() != null) {
                ch = s.next();
                arrayS.add(ch);
                s.nextLine();
            }

            String ch1;
            while (c.hasNext()) {
                ch1 = brc.readLine();
                arrayC.add(ch1);
                c.nextLine();
            }

            int i = 0;
            boolean che = false;

            System.out.println("•ENTER THE STUDENT ID: ");
            super.student_id = in.next();

            if (arrayS.contains(student_id)) {

                System.out.println("\n•ENTER THE STUDENT‘S NEW COURSE ID: ");
                super.course_id = in.next();

                while (i < arrayC.size()) {
                    if (arrayC.get(i).contains(student_id) && arrayC.get(i).contains(course_id)) {
                        System.out.println("\n*Course Available* \n");
                        che = true;
                        break;
                    }
                    i++;
                }

                if (arrayC.isEmpty() || che == false) {
                    print.println(super.student_id + " " + super.course_id);
                    System.out.println("\nThe new subject has been successfully added to the student ✔ \n");
                    print.close();
                }
            } else {
                System.out.println("\n*Student Not Available* \n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void addMark() throws Exception // Menu Item 3
    {

        try {
            Scanner in = new Scanner(System.in);

            Scanner s = new Scanner(fs);
            FileReader frs = new FileReader(fs);
            BufferedReader brs = new BufferedReader(frs);
            ArrayList<String> arrayS = new ArrayList<>();

            Scanner c = new Scanner(fsc);
            FileReader frc = new FileReader(fsc);
            BufferedReader brc = new BufferedReader(frc);
            ArrayList<String> arrayC = new ArrayList<>();

            String ch;
            while (brs.readLine() != null) {
                ch = s.next();
                arrayS.add(ch);
                s.nextLine();
            }

            String ch1;
            while (c.hasNext()) {
                ch1 = brc.readLine();
                arrayC.add(ch1);
                c.nextLine();
            }

            int i = 0;
            boolean ci = false;
            ////String path = "C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\project_programing2\\StudentCourse.txt";

            System.out.println("•ENTER THE STUDENT ID: ");
            super.student_id = in.next();

            if (arrayS.contains(student_id)) {

                System.out.println("\n•ENTER THE STUDENT‘S COURSE ID: ");
                super.course_id = in.next();

                while (i < arrayC.size()) {
                    if (arrayC.get(i).contains(student_id) && arrayC.get(i).contains(course_id)) {
                        System.out.println("\n•ENTER THE GRADE: ");
                        super.course_mark = in.next();
                        String nS = arrayC.get(i) + " " + course_mark;
                        methodAddMark(path, arrayC.get(i), nS);
                        System.out.println("\nThe course grade has been successfully added to the student ✔ \n");
                        ci = true;
                        break;
                    }
                    i++;
                }

                if (ci == false) {
                    System.out.println("\n*Course Not Available* \n");
                }

            } else {
                System.out.println("\n*Student Not Available* \n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //In Superclass, there is a method belonging to List No. 3, which takes the grades from the text file(StudentCourse).
    
    void gpaCalculate() throws Exception // Menu Item 4
    {

        try {
            Scanner in = new Scanner(System.in);

            Scanner s = new Scanner(fs);
            FileReader frs = new FileReader(fs);
            BufferedReader brs = new BufferedReader(frs);
            ArrayList<String> arrayS = new ArrayList<>();

            Scanner c = new Scanner(fsc);
            FileReader frc = new FileReader(fsc);
            BufferedReader brc = new BufferedReader(frc);
            ArrayList<String> arrayC = new ArrayList<>();

            Scanner s1 = new Scanner(fs);
            FileReader frs1 = new FileReader(fs);
            BufferedReader brs1 = new BufferedReader(frs1);
            ArrayList<String> arrayS1 = new ArrayList<>();

            Scanner c1 = new Scanner(fsc);
            FileReader frc1 = new FileReader(fsc);
            BufferedReader brc1 = new BufferedReader(frc1);
            ArrayList<String> arrayC1 = new ArrayList<>();

            FileReader frc2 = new FileReader(fsc);
            BufferedReader brc2 = new BufferedReader(frc2);
            ArrayList<String> arrayC2 = new ArrayList<>();
            
            String ch;
            while (s.hasNext()) {
                ch = brs.readLine();
                arrayS.add(ch);
                s.nextLine();
            }

            String ch1;
            while (c.hasNext()) {
                ch1 = brc.readLine();
                arrayC.add(ch1);
                c.nextLine();
            }

            String ch2;
            while (s1.hasNext()) {
                ch2 = s1.next();
                arrayS1.add(ch2);
                s1.nextLine();
            }
            String ch3;
            while (c1.hasNext()) {
                ch3 = c1.next();
                arrayC1.add(ch3);
                c1.nextLine();
            }

            
            
            String ch4 ;
            while ((ch4=brc2.readLine()) != null) {
                if (ch4.split(" ").length == 3) {

                    arrayC2.add(ch4.split(" ")[2]);
                } else {
                    arrayC2.add("0");
                }
            }
            

            int i = 0;
            int i2 = 0;
            int i3 = 1;
            int grade;
            int sum = 0;
            int count = 0;

            System.out.println("•ENTER THE STUDENT ID: ");
            super.student_id = in.next();
            System.out.print("\n");

            while (i < arrayS.size()) {
                if (arrayS1.contains(student_id) && !arrayC1.contains(student_id)) {

                    System.out.println("\n*The Student does Not Have Any Courses* \n");
                    break;
                }
                if (!arrayS1.contains(student_id)) {

                    System.out.println("\n*Student Not Available* \n");
                    break;

                }

                if (arrayS1.contains(student_id) && arrayS.get(i).contains(student_id)) {
                    System.out.println("-------------------------------");
                    System.out.println("Student ID And Student Name:");
                    System.out.println(arrayS.get(i)+"\n");
                    break;

                }
                i++;
            }

            if (arrayS1.contains(student_id)) {

                while (i2 < arrayC.size()) {
                    if (arrayS1.contains(student_id) && !arrayC1.contains(student_id)) {

                        break;
                    }
                    if (arrayC1.contains(student_id) && arrayC.get(i2).contains(student_id)) {
                       if(arrayC2.get(i2)!="0")
                        System.out.println("Grade " + i3 + " = " + arrayC2.get(i2));
                        grade = Integer.parseInt(arrayC2.get(i2));
                        sum += grade;
                        count++;
                        i3++;
                    }
                    i2++;
                }

                if (arrayC1.contains(student_id) && arrayS.get(i).contains(student_id)) {
                    //System.out.println("Sum = " + sum);
                    System.out.println("\nnumber of courses: " + count);
                    super.gpa = (double) sum / count;
                    System.out.println("\nGpa = " + super.gpa+"%");
                    System.out.println("-------------------------------\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void printAllCourses() throws Exception // Menu Item 5
    {

        try {
            Scanner in = new Scanner(System.in);

            Scanner s = new Scanner(fs);
            FileReader frs = new FileReader(fs);
            BufferedReader brs = new BufferedReader(frs);
            ArrayList<String> arrayS = new ArrayList<>();

            Scanner c = new Scanner(fsc);
            FileReader frc = new FileReader(fsc);
            BufferedReader brc = new BufferedReader(frc);
            ArrayList<String> arrayC = new ArrayList<>();

            Scanner s1 = new Scanner(fs);
            FileReader frs1 = new FileReader(fs);
            BufferedReader brs1 = new BufferedReader(frs1);
            ArrayList<String> arrayS1 = new ArrayList<>();

            Scanner c1 = new Scanner(fsc);
            FileReader frc1 = new FileReader(fsc);
            BufferedReader brc1 = new BufferedReader(frc1);
            ArrayList<String> arrayC1 = new ArrayList<>();

            Scanner c2 = new Scanner(fsc);
            FileReader frc2 = new FileReader(fsc);
            BufferedReader br4 = new BufferedReader(frc2);
            ArrayList<String> arrayC2 = new ArrayList<>();

            String ch;
            while (s.hasNext()) {
                ch = brs.readLine();
                arrayS.add(ch);
                s.nextLine();
            }

            String ch1;
            while (c.hasNext()) {
                ch1 = c.next();
                ch1 = c.next();
                arrayC.add(ch1);
                c.nextLine();
            }

            String ch2;
            while (s1.hasNext()) {
                ch2 = s1.next();
                arrayS1.add(ch2);
                s1.nextLine();
            }

            String ch3;
            while (c1.hasNext()) {
                ch3 = c1.next();
                arrayC1.add(ch3);
                c1.nextLine();
            }
            String ch4;
            while (c2.hasNext()) {
                ch4 = br4.readLine();
                arrayC2.add(ch4);
                c2.nextLine();
            }

            int i = 0;
            int i2 = 0;

            System.out.println("•ENTER THE STUDENT ID: ");
            super.student_id = in.next();

            if (!arrayS1.contains(student_id)) {

                System.out.println("\n*Student Not Available* \n");
            }

            if (arrayS1.contains(student_id)) {

                while (i < arrayC.size()) {
                    if (arrayS1.contains(student_id) && !arrayC1.contains(student_id)) {

                        System.out.println("\n*The Student does Not Have Any Courses* \n");
                        
                        break;
                    } else if (arrayS1.contains(student_id) && arrayS.get(i).contains(student_id)) {
                        System.out.println("\n-------------------------------");
                        System.out.println("Student ID And Student Name:");
                        System.out.println(arrayS.get(i));
                        break;

                    }
                    i++;
                }
                
                if (arrayS1.contains(student_id) && arrayC2.get(i2).contains(student_id))
                    System.out.print("\nThe Courses:\n");
                
                while (i2 < arrayC.size()) {
                    if (arrayS1.contains(student_id) && arrayC2.get(i2).contains(student_id)) {
                       
                        System.out.println(arrayC.get(i2));
                    
                    }
                    i2++;
                }
                System.out.println("-------------------------------\n");
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void printAllStudents() throws Exception // Menu Item 6
    {

        try {
            Scanner in = new Scanner(System.in);

            Scanner c = new Scanner(fsc);
            FileReader frc = new FileReader(fsc);
            BufferedReader brc = new BufferedReader(frc);
            ArrayList<String> arrayC = new ArrayList<>();

            Scanner c1 = new Scanner(fsc);
            FileReader frc1 = new FileReader(fsc);
            BufferedReader brc1 = new BufferedReader(frc1);
            ArrayList<String> arrayC1 = new ArrayList<>();

            Scanner c2 = new Scanner(fsc);
            FileReader frc2 = new FileReader(fsc);
            BufferedReader brc2 = new BufferedReader(frc2);
            ArrayList<String> arrayC2 = new ArrayList<>();

            String ch;
            while (c.hasNext()) {
                ch = c.next();
                ch = c.next();
                arrayC.add(ch);
                c.nextLine();
            }

            String ch1;
            while (c1.hasNext()) {
                ch1 = c1.next();
                arrayC1.add(ch1);
                c1.nextLine();
            }
            String ch2;
            while (c2.hasNext()) {
                ch2 = brc2.readLine();
                arrayC2.add(ch2);
                c2.nextLine();
            }

            int i = 0;

            System.out.println("•ENTER THE STUDENT‘S COURSE ID: ");
            super.course_id = in.next();
            if (!arrayC.contains(course_id)) {

                System.out.println("\n•Course Not Available \n");

            }
            if (arrayC.contains(course_id)) {
                System.out.println("\n------------------");
                System.out.println("Course ID: "+course_id);
                System.out.println("\nThe Students: ");
            }
            
            while (i < arrayC2.size()) {

                if (arrayC.contains(course_id) && arrayC2.get(i).contains(course_id)) {

                    System.out.println(arrayC1.get(i));

                }
                i++;

            }
            System.out.println("------------------\n");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void closeProgram() // Method Close The Program
    {
        
        System.out.print("The program will be closed at your request\n");
        System.exit(0);
        
    }
    
}

public class Project_programing2 extends Application {

    @Override
    public void start(Stage myStage) // Method javaFx
    {

        ProgramMenu b = new ProgramMenu();

        Button bt1 = new Button("Add New Student");
        Button bt2 = new Button("Add New Course");
        Button bt3 = new Button("Add Mark For Course");
        Button bt4 = new Button("Show GPA For Student");
        Button bt5 = new Button("Show All Student Courses");
        Button bt6 = new Button("Show All Course Students");
        Button bt7 = new Button("Close The Program");

        GridPane pane = new GridPane();
        pane.setHgap(60);
        pane.setVgap(20);
        pane.add(bt1, 1, 1);
        pane.add(bt2, 1, 3);
        pane.add(bt3, 1, 5);
        pane.add(bt4, 1, 7);
        pane.add(bt5, 1, 9);
        pane.add(bt6, 1, 11);
        pane.add(bt7, 1, 13);

        Scene scene = new Scene(pane, 300, 500);
        myStage.setScene(scene);
        myStage.show();

        bt1.setOnAction(e -> 
        {

            try {
                b.addNewStudent();
            } catch (Exception ex) {
                System.out.println(ex);
            }

        });

        bt2.setOnAction(e -> 
        {

            try {
                b.addNewCourse();
            } catch (Exception ex) {
                System.out.println(ex);
            }

        });

        bt3.setOnAction(e -> 
        {

            try {
                b.addMark();
            } catch (Exception ex) {
                System.out.println(ex);
            }

        });

        bt4.setOnAction(e -> 
        {

            try {
                b.gpaCalculate();
            } catch (Exception ex) {
                System.out.println(ex);
            }

        });

        bt5.setOnAction(e -> 
        {

            try {
                b.printAllCourses();
            } catch (Exception ex) {
                System.out.println(ex);
            }

        });

        bt6.setOnAction(e -> 
        {

            try {
                b.printAllStudents();
            } catch (Exception ex) {
                System.out.println(ex);
            }

        });

        bt7.setOnAction(e -> 
        {

            b.closeProgram();

        });
    }

    public static void main(String[] args) 
    {
        
        Application.launch(); // Invoke Method javaFx
        
    }
}
