public class Exercise1 {

        public static int recursiveProduct(int m, int n) {
            // Checking for Base Case if either m or n is less than equal to 1 return the other number
            // The reason I check for less then 1 is more so for edge cases but not sure if it's really necessary

            if (m <= 1)
            {
                return n;
            }
            else if (n <= 1)
            {
                return m;
            }

            // using Recursion to get the product by adding n to the product of (m-1) and n
            return n + recursiveProduct(m - 1, n);
        }

        public static void main(String[] args)
        {
            int result = recursiveProduct(5, 7);
            System.out.println("The product is " + result);
        }
}



