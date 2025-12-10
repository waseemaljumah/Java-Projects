package groupproject;
import java.util.Scanner;
public class GroupProject {

//Function sum
    public static void sum() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double nU1 = in.nextDouble();
        System.out.println("Enter the second number: ");
        double nU2 = in.nextDouble();
        double sum = nU1 + nU2;
        System.out.println("");
        System.out.println("The Result " + nU1 + " + " + nU2 + " = " + sum);
        System.out.println("");
    }

//Function subtract
    public static void subtract() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double nU1 = in.nextDouble();
        System.out.println("Enter the second number: ");
        double nU2 = in.nextDouble();
        double sub = nU1 - nU2;
        System.out.println("");
        System.out.println("The Result " + nU1 + " - " + nU2 + " = " + sub);
        System.out.println("");
    }

//Function Multiplication  
    static void Multiplication() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double nU1 = in.nextDouble();
        System.out.println("Enter the second number: ");
        double nU2 = in.nextDouble();
        double multi = nU1 * nU2;
        System.out.println("");
        System.out.println("The Result " + nU1 + " * " + nU2 + " = " + multi);
        System.out.println("");
    }

//Function Division  
    static void Division() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double nU1 = in.nextDouble();
        System.out.println("Enter the second number: ");
        double nU2 = in.nextDouble();
        if (nU2 == 0) {
            System.out.println("");
            System.out.println("can not divide by 0");
            System.out.println("");
        } else {
            double div = nU1 / nU2;
            System.out.println("");
            System.out.println("The Result " + nU1 + " / " + nU2 + " = " + div);
            System.out.println("");
        }
    }

//Function Modulus 
    public static void Modulus() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double nU1 = in.nextDouble();
        System.out.println("Enter the second number: ");
        double nU2 = in.nextDouble();
        double Mod = nU1 % nU2;
        System.out.println("");
        System.out.println("The Modulus " + nU1 + " % " + nU2 + " = " + Mod);
        System.out.println("");
    }

//Function Power 
    public static void Power() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number: ");
        double nU1 = in.nextDouble();
        System.out.println("Enter a power: ");
        double nU2 = in.nextDouble();
        double pow = Math.pow(nU1, nU2);
        System.out.println("");
        System.out.println("The Pow " + nU1 + " Power " + nU2 + " = " + pow);
        System.out.println("");
    }

//Function square
    public static void square() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Positive number: ");
        double nU1 = in.nextDouble();
        double squ = Math.sqrt(nU1);
        System.out.println("");
        if (nU1 >= 0) {
            System.out.println("√" + nU1 + " = " + squ);
            System.out.println("");
        } else {
            System.out.println("square of a Negative Number doesn’t exitst !!");
            System.out.println("");
        }
    }

//Function Factorial
    public static void Factorial() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Positive Number: ");
        int nU1 = in.nextInt();
        long Fact = 1;
        for (int i = 1; i <= nU1; i++) {
            Fact = Fact * i;
        }
        System.out.println("");
        if (nU1 >= 0) {
            System.out.println(nU1 + "!" + " = " + Fact);
            System.out.println("");
        } else {
            System.out.println("Factorial of a Negative Number doesn’t exitst !!");
            System.out.println("");
        }
    }

//Function log
    public static void log() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Positive Number: ");
        double nU1 = in.nextDouble();
        double log = Math.log(nU1);
        System.out.println("");
        if (nU1 > 0) {
            System.out.println("log " + "(" + nU1 + ")" + " = " + log);
            System.out.println("");
        } else {
            System.out.println("Logarithm of Zero or a Negative Number doesn’t exitst !!");
            System.out.println("");
        }
    }

//Function Sin
    public static void findSin() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Degree :");
        double nU1 = in.nextDouble();
        System.out.println("");
        System.out.println("Sin " + "(" + nU1 + ")" + " = " + Math.sin(Math.toRadians(nU1)));
        System.out.println("");
    }

//Function Abs
    public static void findAbs() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a Number :");
        double nU1 = in.nextDouble();
        System.out.println("");
        System.out.println("|" + nU1 + "|" + " = " + Math.abs(nU1));
        System.out.println("");
    }

//Function AvgArray
    public static void findAvgArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("How Many Numbers You Want to calculate :");
        int N = in.nextInt();
        double[] ref = new double[N];
        System.out.println("Enter the Numbers :");
        for (int i = 0; i < ref.length; i++) {
            ref[i] = in.nextDouble();
        }
        double Sum = 0;
        for (int i = 0; i < ref.length; i++) {
            Sum += ref[i];
        }
        double Avg = Sum / ref.length;
        System.out.println("");
        System.out.println("The Average = " + Avg);
        System.out.println("");
    }

//Function operation
    public static void selOpe() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Choose the operation ( + , - , * , / , % , ! , power->p , square->q , log->l , sin->s , absolute->b , average->a )");
            char ope = in.next().charAt(0);
            switch (ope) {
                case '+':
                    sum();
                    break;
                case '-':
                    subtract();
                    break;
                case '*':
                    Multiplication();
                    break;
                case '/':
                    Division();
                    break;
                case '%':
                    Modulus();
                    break;
                case 'P':
                case 'p':
                    Power();
                    break;
                case 'Q':
                case 'q':
                    square();
                    break;
                case '!':
                    Factorial();
                    break;
                case 'L':
                case 'l':
                    log();
                    break;
                case 'S':
                case 's':
                    findSin();
                    break;
                case 'B':
                case 'b':
                    findAbs();
                    break;
                case 'A':
                case 'a':
                    findAvgArray();
                    break;

                default:
                    System.out.println("wrong input");
                    System.out.println("");
            }

            char ch;
            for (;;) {
                System.out.println("Do you want to choose another operation? (y\\n)");
                ch = in.next().charAt(0);
                if (ch == 'y' || ch == 'Y') {
                    break;
                } else if (ch == 'n' || ch == 'N') {
                    break;
                } else {
                    System.out.println("Wrong Input");
                    System.out.println("");
                }
            }
            if (ch == 'n' || ch == 'N') {
                break;
            }
        }
    }

    public static void main(String[] args) {
        selOpe();
    }
}
