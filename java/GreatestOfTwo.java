import java.util.Scanner;

public class GreatestOfTwo {
    public static void main(String[] args) {
        int a,b;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        a = sc.nextInt();
        System.out.print("Enter the second number: ");
        b = sc.nextInt();
        if (a > b) {    
            System.out.println("The greatest number is: " + a);
        } else {
            System.out.println("The greatest number is: " + b);
        }
    }
}