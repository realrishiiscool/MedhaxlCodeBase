import java.util.Scanner;

public class SumOfRange {
    public static void main(String[] args) {    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int firstNumber = sc.nextInt();
        System.out.print("Enter the second number: ");
        int secondNumber = sc.nextInt();
        int sum = 0;
        for (int i = firstNumber; i <= secondNumber; i++) {
            sum += i;
        }
        System.out.println("The sum of numbers from " + firstNumber + " to " + secondNumber + " is: " + sum);
    }
}
