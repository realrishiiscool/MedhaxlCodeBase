import java.util.Scanner;

class LeapYear {
    public static void main(String[] args) {
        int year; 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        year = sc.nextInt();
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        if (isLeapYear) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }
    }
}