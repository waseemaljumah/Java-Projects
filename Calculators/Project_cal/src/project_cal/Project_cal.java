package project_cal;

import java.util.Date;
import java.util.Scanner;

public class Project_cal {

    public static void addition(double[] savedValue) {
        System.out.println(savedValue[0] + "+" + savedValue[1] + "=" + (savedValue[0] + savedValue[1]));
        System.out.print("|---------------|\n");
    }

    public static void subtraction(double[] savedValue) {
        System.out.println("\n" + savedValue[0] + "-" + savedValue[1] + "=" + (savedValue[0] - savedValue[1]));
        System.out.print("|---------------|\n");
    }

    public static void multiplication(double[] savedValue) {
        System.out.println(savedValue[0] + "x" + savedValue[1] + "=" + (savedValue[0] * savedValue[1]));
        System.out.print("|---------------|\n");
    }

    public static void division(double[] savedValue) {
        if (savedValue[1] == 0) {
            System.out.println("can not divide by 0");
        } else {
            System.out.println(savedValue[0] + "/" + savedValue[1] + "=" + (savedValue[0] / savedValue[1]));
            System.out.print("|---------------|\n");
        }
    }

    public static void modulus(double[] savedValue) {
        System.out.println(savedValue[0] + "%" + savedValue[1] + "=" + (savedValue[0] % savedValue[1]));
        System.out.print("|---------------|\n");
    }

    public static void power(double[] savedValue) {
        System.out.println(savedValue[0] + "pow" + savedValue[1] + "=" + (Math.pow(savedValue[0], savedValue[1])));
        System.out.print("|---------------|\n");
    }

    public static void SquareRoot(double[] storeValue) {
        if (storeValue[0] >= 0) {
            System.out.println("√" + storeValue[0] + "(sqrt)=" + (Math.sqrt(storeValue[0])));
            System.out.print("|---------------|\n");
        } else {
            System.out.println("");
            System.out.println("square of a Negative Number doesn’t exitst !!");
        }
    }

    public static void factorialOfN(double[] savedValue) {
        double factorial = 1;
        for (int i = 1; i <= savedValue[0]; i++) {
            factorial *= i;
        }
        if (savedValue[0] >= 0) {
            System.out.println("The factorial of  "
                    + savedValue[0]
                    + " = " + factorial);
            System.out.print("|---------------|\n");
        } else {
            System.out.println("");
            System.out.println("Factorial of a Negative Number doesn’t exitst !!");
        }
    }

    public static void log(double[] savedValue) {
        if (savedValue[0] > 0) {
            System.out.println(savedValue[0] + "(log)=" + (Math.log(savedValue[0])));
            System.out.print("|---------------|\n");
        } else {
            System.out.println("");
            System.out.println("Logarithm of Zero or a Negative Number doesn’t exitst !!");
        }
    }

    public static void sin(double[] savedValue) {
        System.out.println(savedValue[0] + "(sin)=" + (Math.sin(savedValue[0])));
        System.out.print("|---------------|\n");
    }

    public static void absolute(double[] savedValue) {
        System.out.println("(|" + savedValue[0] + "|)=" + (Math.abs(savedValue[0])));
        System.out.print("|---------------|\n");
    }

    public static void avg(double[] savedValue) {
        double valusAdder = 0;
        int valusNum = 0;
        for (int i = 0; i < savedValue.length; i++) {
            valusAdder += savedValue[i];
            valusNum++;
            System.out.print("|---------------|\n");
        }
        System.out.println("avg is=" + (valusAdder / valusNum));
        System.out.print("|---------------|\n");
    }

    public static void menu_project() {
        System.out.println("the number of operation:");
        System.out.println("\t|------------------------------------------------------------------------------------|");
        System.out.println("\t|\t1-Additiont[+]|\t2-Subtraction[-]|   3-Multiplication[x]\t   |\t4-Division[/]|\n\t|---------------------|-----------------|--------------------------|-----------------|");
        System.out.print("\t|\t5-Modulus[%]  |\t6-Power\t\t|\t7-Square root\t   | 8-Factorial[n!] |\n\t|---------------------|-----------------|--------------------------|-----------------|\n");

        System.out.print("\t|\t9-log\t      |\t10-sin\t\t|\t11-absolute(||)\t   |\t12-avg\t     |\n");
        System.out.println("\t|------------------------------------------------------------------------------------|");
    }

    public static void cese() {
        String project_name = "";
        calculator(project_name);

        Date day_time = new Date();
        System.out.print(day_time + "\n");
        
        
        Scanner run = new Scanner(System.in);
        while (true) {
            String op = "operation";

            System.out.print("Enter the number of values:");
            int numOfValue = run.nextInt();

            double[] storeValue = new double[numOfValue];
            int k = 1;
            for (int j = 0; j < storeValue.length; j++) {
                System.out.print("enter value number(" + k + "):");
                storeValue[j] = run.nextInt();
                k++;
            }
            
            menu_project();
            System.out.print("\t|" + op.toUpperCase() + "=");
            int operation = run.nextInt();
            if (operation < 13) {
                System.out.print("|---------------|\nslution=");
                switch (operation) {

                    case 1:
                        addition(storeValue);
                        break;
                    case 2:
                        subtraction(storeValue);
                        break;
                    case 3:
                        multiplication(storeValue);
                        break;
                    case 4:
                        division(storeValue);
                        break;
                    case 5:
                        modulus(storeValue);
                        break;
                    case 6:
                        power(storeValue);
                        break;
                    case 7:
                        SquareRoot(storeValue);
                        break;
                    case 8:
                        factorialOfN(storeValue);
                        break;
                    case 9:
                        log(storeValue);
                        break;
                    case 10:
                        sin(storeValue);
                        break;
                    case 11:
                        absolute(storeValue);
                        break;
                    case 12:
                        avg(storeValue);
                        break;
                    default:
                        System.out.println("wrong input");
                        System.out.println("");
                }
            }
            System.out.println();
            int cho;
            for (;;) {
                System.out.println("\t|-----------------------------------------|");
                System.out.println("\t|\t1-TO START|\t0-TO FINISH       |");
                System.out.println("\t|-----------------------------------------|");
                System.out.print("Choose the appropriate number:");
                cho = run.nextInt();
                if (cho == 1) {
                    break;
                } else if (cho == 0) {
                    break;
                } else {
                    System.out.println("Wrong Input");
                    System.out.println("");
                }
            }
            if (cho == 0) {
                break;
            }
        }
    }

    public static void calculator(String name) {
        System.out.println("\t\t\t|----welcome to calculator----|");
    }

    public static void main(String[] args) {
        
        cese();
        
    }
}
