public class Exercises {

    /** Returns the sum of the integers in given array. */

    /*
     * The Big O time complexity would be O(n)
     * n representing the length of the array (Which we consider the worst case scenario)
     * Which would represent as Linear
     */

    public static int example1(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            total += arr[j];
        return total;
    }

    /*
     * The Big O time complexity would be O(n)
     * even though here we increment by 2 we still iterate through n number of elements
     * Which would represent as Linear
     */

    /** Returns the sum of the integers with even index in given array. */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2)    // note the increment of 2
            total += arr[j];
        return total;
    }

    /*
     * The Big O time complexity would be O(n^2)
     * we have increased the amount to iterate through by adding a nested for loop
     * Which would represent as Quadratic
     */

    /** Returns the sum of the prefix sums of given array. */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++)       // loop from 0 to n-1
            for (int k=0; k <= j; k++)    // loop from 0 to j
                total += arr[j];
        return total;
    }


    /*
     * The Big O time complexity would be O(n)
     * We are still only iterating through using one for loop of n elements
     * Which would represent as Linear
     */

    /** Returns the sum of the prefix sums of given array. */

    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j=0; j < n; j++) {     // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
        }
        return total;
    }

    /*
     * The Big O time complexity would be O(n^3)
     * We have 3 for loops which are nested iterating through n number of elements
     * Which would represent as Quadratic
     */

    /** Returns the number of times second array stores sum of prefix sums from first. */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i=0; i < n; i++) {     // loop from 0 to n-1
            int total = 0;
            for (int j=0; j < n; j++)     // loop from 0 to n-1
                for (int k=0; k <= j; k++)  // loop from 0 to j
                    total += first[k];
            if (second[i] == total) count++;
        }
        return count;
    }
}
