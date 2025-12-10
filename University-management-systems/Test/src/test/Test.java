package test;
//basic project.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import static test.Add_Course_Mark.modifyFile;

public class Test{

    public static void main(String[] args) throws Exception {

        //1 
        //Add_New_Student a = new Add_New_Student();
        //a.setNewStudent();
        //2
        //Add_New_Course b = new Add_New_Course();
        //b.setNewCourse();
        //3
        //Add_Course_Mark c = new Add_Course_Mark();
        //c.setMark();
        //4
        //Claculate_the_Average d = new Claculate_the_Average();
        //d.setGpa();
        //5
        //printCourse e = new printCourse();
        //e.printCourse();
        //6
        //printStudent f = new printStudent();
        //f.printStudent();
        
    }
}

class Student_Information {

    String student_id;
    String first_name;
    String last_name;
    String course_id;
    String course_mark;
    double gpa;

}

class Add_New_Student extends Student_Information // Menu Item 1
{

    File f = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\Student.txt");

    void setNewStudent() throws IOException {

        try {
            Scanner in = new Scanner(System.in);
            FileWriter fw = new FileWriter(f, true);
            PrintWriter output = new PrintWriter(fw);
            Scanner sc = new Scanner(f);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList<>();

            String l;
            while (br.readLine() != null) {
                l = sc.next();
                list.add(l);
                sc.nextLine();
            }

            super.student_id = in.next();
            
            if (list.isEmpty()) {

                super.first_name = in.next();
                super.last_name = in.next();

                output.println(super.student_id + "\t" + super.first_name + " " + super.last_name);
                output.close();
            } else if (!list.contains(student_id)) {

                super.first_name = in.next();
                super.last_name = in.next();

                output.println(super.student_id + "\t" + super.first_name + " " + super.last_name);
                output.close();
            } else {
                System.out.println("Student Already Available");

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class Add_New_Course extends Student_Information // Menu Item 2
{

    File f = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\StudentCourse.txt");
    File f1 = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\Student.txt");

    void setNewCourse() throws IOException {

        try {
            Scanner in = new Scanner(System.in);
            FileWriter fw = new FileWriter(f, true);
            PrintWriter output = new PrintWriter(fw);

            Scanner sc = new Scanner(f1);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList<>();

            Scanner sc1 = new Scanner(f);
            FileReader fr1 = new FileReader(f);
            BufferedReader br1 = new BufferedReader(fr1);
            ArrayList<String> list1 = new ArrayList<>();

            String l;
            while (br.readLine() != null) {
                l = sc.next();
                list.add(l);
                sc.nextLine();
            }

            String l1;
            while (sc1.hasNext()) {
                l1 = br1.readLine();
                list1.add(l1);
                sc1.nextLine();
            }

            int i = 0;
            boolean ci = false;

            super.student_id = in.next();

            if (list.contains(student_id)) {

                super.course_id = in.next();

                while (i < list1.size()) {

                    if (list1.get(i).contains(student_id) && list1.get(i).contains(course_id)) {

                        System.out.println("Course Available");
                        ci = true;
                        break;
                    }
                    i++;
                }
                if (list1.isEmpty() || ci == false) {
                    output.println(super.student_id + "\t" + super.course_id);
                    output.close();
                }

            } else {
                System.out.println("Student Not Available");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class Add_Course_Mark extends Student_Information // Menu Item 3
{

    File f = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\StudentCourse.txt");
    File f1 = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\Student.txt");

    void setMark() throws IOException {

        try {
            Scanner in = new Scanner(System.in);

            Scanner sc = new Scanner(f1);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList<>();

            Scanner sc1 = new Scanner(f);
            FileReader fr1 = new FileReader(f);
            BufferedReader br1 = new BufferedReader(fr1);
            ArrayList<String> list1 = new ArrayList<>();

            String l;
            while (br.readLine() != null) {
                l = sc.next();
                list.add(l);
                sc.nextLine();
            }

            String l1;
            while (sc1.hasNext()) {
                l1 = br1.readLine();
                list1.add(l1);
                sc1.nextLine();
            }

            int i = 0;
            boolean ci = false;
            String path = "C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\StudentCourse.txt";

            super.student_id = in.next();

            if (list.contains(student_id)) {

                super.course_id = in.next();

                while (i < list1.size()) {
                    if (list1.get(i).contains(student_id) && list1.get(i).contains(course_id)) {

                        super.course_mark = in.next();

                        String newS = list1.get(i) + "  " + course_mark;

                        modifyFile(path, list1.get(i), newS);

                        ci = true;
                        break;
                    }
                    i++;
                }

                if (ci == false) {
                    System.out.println("Course Not Available");

                }

            } else {

                System.out.println("Student Not Available");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    static void modifyFile(String filePath, String oldString, String newString) {
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
}

class Claculate_the_Average extends Student_Information // Menu Item 4
{

    File f = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\StudentCourse.txt");
    File f1 = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\Student.txt");

    void setGpa() throws IOException {

        try {
            Scanner in = new Scanner(System.in);

            Scanner sc = new Scanner(f1);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList<>();

            Scanner sc1 = new Scanner(f);
            FileReader fr1 = new FileReader(f);
            BufferedReader br1 = new BufferedReader(fr1);
            ArrayList<String> list1 = new ArrayList<>();

            Scanner sc2 = new Scanner(f1);
            FileReader fr2 = new FileReader(f1);
            BufferedReader br2 = new BufferedReader(fr2);
            ArrayList<String> list2 = new ArrayList<>();

            Scanner sc3 = new Scanner(f);
            FileReader fr3 = new FileReader(f);
            BufferedReader br3 = new BufferedReader(fr3);
            ArrayList<String> list3 = new ArrayList<>();

            Scanner sc4 = new Scanner(f);
            FileReader fr4 = new FileReader(f);
            BufferedReader br4 = new BufferedReader(fr4);
            ArrayList<String> list4 = new ArrayList<>();

            String l;
            while (sc.hasNext()) {
                l = br.readLine();
                list.add(l);
                sc.nextLine();
            }

            String l1;
            while (sc1.hasNext()) {
                l1 = br1.readLine();
                list1.add(l1);
                sc1.nextLine();
            }

            String l2;
            while (sc2.hasNext()) {
                l2 = sc2.next();
                list2.add(l2);
                sc2.nextLine();
            }
            String l3;
            while (sc3.hasNext()) {
                l3 = sc3.next();
                list3.add(l3);
                sc3.nextLine();
            }

            String l4;
            while (sc4.hasNext()) {
                sc4.next();
                sc4.next();
                l4 = sc4.next();
                list4.add(l4);

            }

            int i = 0;
            int i2 = 0;
            int i3 = 1;
            int grade;
            int Sum = 0;
            int count = 0;

            super.student_id = in.next();

            while (i < list.size()) {
                if (list2.contains(student_id) && !list3.contains(student_id)) {

                    System.out.println("The Student does Not Have Any Courses");
                    break;
                }
                if (!list2.contains(student_id)) {

                    System.out.println("Student Not Available");
                    break;

                }

                if (list2.contains(student_id) && list.get(i).contains(student_id)) {

                    System.out.println(list.get(i));
                    break;

                }
                i++;
            }

            if (list2.contains(student_id)) {

                while (i2 < list1.size()) {
                    if (list2.contains(student_id) && !list3.contains(student_id)) {

                        break;
                    }
                    if (list3.contains(student_id) && list1.get(i2).contains(student_id)) {

                        System.out.println("Grade " + i3 + " = " + list4.get(i2));
                        grade = Integer.parseInt(list4.get(i2));
                        Sum += grade;
                        count++;
                        i3++;
                    }
                    i2++;
                }

                if (list3.contains(student_id) && list.get(i).contains(student_id)) {
                    //System.out.println("Sum = " + Sum);
                    //System.out.println("number of course = " + count);
                    super.gpa = (double) Sum / count;
                    System.out.println("Gpa = " + super.gpa);

                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class printCourse extends Student_Information // Menu Item 5
{

    File f = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\StudentCourse.txt");
    File f1 = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\Student.txt");

    void printCourse() throws IOException {

        try {
            Scanner in = new Scanner(System.in);

            Scanner sc = new Scanner(f1);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<String> list = new ArrayList<>();

            Scanner sc1 = new Scanner(f);
            FileReader fr1 = new FileReader(f);
            BufferedReader br1 = new BufferedReader(fr1);
            ArrayList<String> list1 = new ArrayList<>();

            Scanner sc2 = new Scanner(f1);
            FileReader fr2 = new FileReader(f1);
            BufferedReader br2 = new BufferedReader(fr2);
            ArrayList<String> list2 = new ArrayList<>();

            Scanner sc3 = new Scanner(f);
            FileReader fr3 = new FileReader(f);
            BufferedReader br3 = new BufferedReader(fr3);
            ArrayList<String> list3 = new ArrayList<>();

            Scanner sc4 = new Scanner(f);
            FileReader fr4 = new FileReader(f);
            BufferedReader br4 = new BufferedReader(fr4);
            ArrayList<String> list4 = new ArrayList<>();

            String l;
            while (sc.hasNext()) {
                l = br.readLine();
                list.add(l);
                sc.nextLine();
            }

            String l1;
            while (sc1.hasNext()) {
                l1 = sc1.next();
                l1 = sc1.next();
                list1.add(l1);
                sc1.nextLine();
            }

            String l2;
            while (sc2.hasNext()) {
                l2 = sc2.next();
                list2.add(l2);
                sc2.nextLine();
            }

            String l3;
            while (sc3.hasNext()) {
                l3 = sc3.next();
                list3.add(l3);
                sc3.nextLine();
            }
            String l4;
            while (sc4.hasNext()) {
                l4 = br4.readLine();
                list4.add(l4);
                sc4.nextLine();
            }

            int i = 0;
            int i2 = 0;
            super.student_id = in.next();

            if (!list2.contains(student_id)) {

                System.out.println("Student Not Available");
            }

            if (list2.contains(student_id)) {

                while (i < list1.size()) {
                    if (list2.contains(student_id) && !list3.contains(student_id)) {

                        System.out.println("The Student does Not Have Any Courses");
                        break;
                    } else if (list2.contains(student_id) && list.get(i).contains(student_id)) {

                        System.out.println(list.get(i));
                        break;

                    }
                    i++;
                }

                while (i2 < list1.size()) {
                    if (list2.contains(student_id) && list4.get(i2).contains(student_id)) {

                        System.out.println(list1.get(i2));

                    }
                    i2++;

                }

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

class printStudent extends Student_Information // Menu Item 6
{

    File f = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\StudentCourse.txt");
    File f1 = new File("C:\\Users\\Waseem\\OneDrive\\المستندات\\NetBeansProjects\\Test\\Student.txt");

    void printStudent() throws IOException {
        try {
            Scanner in = new Scanner(System.in);

            Scanner sc1 = new Scanner(f);
            FileReader fr1 = new FileReader(f);
            BufferedReader br1 = new BufferedReader(fr1);
            ArrayList<String> list1 = new ArrayList<>();

            Scanner sc3 = new Scanner(f);
            FileReader fr3 = new FileReader(f);
            BufferedReader br3 = new BufferedReader(fr3);
            ArrayList<String> list3 = new ArrayList<>();

            Scanner sc4 = new Scanner(f);
            FileReader fr4 = new FileReader(f);
            BufferedReader br4 = new BufferedReader(fr4);
            ArrayList<String> list4 = new ArrayList<>();

            String l1;
            while (sc1.hasNext()) {
                l1 = sc1.next();
                l1 = sc1.next();
                list1.add(l1);
                sc1.nextLine();
            }

            String l3;
            while (sc3.hasNext()) {
                l3 = sc3.next();
                list3.add(l3);
                sc3.nextLine();
            }
            String l4;
            while (sc4.hasNext()) {
                l4 = br4.readLine();
                list4.add(l4);
                sc4.nextLine();
            }

            int i = 0;
            super.course_id = in.next();
            if (!list1.contains(course_id)) {

                System.out.println("Course Not Available");

            }
            if (list1.contains(course_id)) {
                System.out.println("Course id = " + course_id);
            }

            while (i < list4.size()) {

                if (list1.contains(course_id) && list4.get(i).contains(course_id)) {

                    System.out.println(list3.get(i));

                }
                i++;

            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
