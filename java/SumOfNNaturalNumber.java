import java.util.Scanner;

public class SumOfNNaturalNumber {
    public static void main(String[] args) {
        int n; // Example value for n
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        n = sc.nextInt(); // Read the input value for n
        for (int i = 1; i <= n; i++) {
            sum += i;//sum = sum + i;
        }
        
        System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
    }
}
