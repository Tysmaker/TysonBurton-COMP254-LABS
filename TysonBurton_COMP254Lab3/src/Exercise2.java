//Importing scanner class to allow for user input
import java.util.Scanner;

public class Exercise2 {

    public static boolean isPalindrome(String s) {
        // Checking for base case is an empty string or a string with one character is a palindrome
        if (s.length() <= 1)
        {
            return true;
        }
        else
        {
            // Check if the first and last characters are equal
            if (s.charAt(0) == s.charAt(s.length() - 1))
            {
                // use recursion on the substring without the first and last characters
                return isPalindrome(s.substring(1, s.length() - 1));
            }
            else
            {
                // If the first and last characters are not equal it's not a palindrome
                return false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter to check if Palindrome?: \n");

        //Allow for input and force the input to be lowercase, just incase some characters are uppercase
        //I was testing with upper and lowercase letters it fails if all are lower and one is upper
        // this will fix that issue
        String input = scanner.next().toLowerCase();

        if (isPalindrome(input))
        {
            System.out.println(" This is a Palindrome :)");
        }
        else
        {
            System.out.println("This is not Palindrome :(");
        }

        scanner.close();
    }
}

