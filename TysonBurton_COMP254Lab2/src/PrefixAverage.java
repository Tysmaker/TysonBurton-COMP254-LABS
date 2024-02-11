
class PrefixAverage {

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        for (int j=0; j < n; j++) {
            double total = 0;            // begin computing x[0] + ... + x[j]
            for (int i=0; i <= j; i++)
                total += x[i];
            a[j] = total / (j+1);        // record the average
        }
        return a;
    }

    /** Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j]. */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n];    // filled with zeros by default
        double total = 0;              // compute prefix sum as x[0] + x[1] + ...
        for (int j=0; j < n; j++) {
            total += x[j];               // update prefix sum to include x[j]
            a[j] = total / (j+1);        // compute average based on current sum
        }
        return a;
    }


    public static void main(String[] args) {
        // Array with testing elements
        int[] sizes = {10000, 20000, 30000, 40000, 50000};  // Input sizes to test

        // Loop through each size in the sizes array
        for (int size : sizes) {

            //Create a new array called input which will store the size of each element
            //I also multiply the array size by 2
            double[] input = new double[size * 2];

            //Create a long which gets the current time of your system in Milliseconds
            long startTime1 = System.currentTimeMillis();

            //Call the prefixAverage Methods and pass the perameter of input
            prefixAverage1(input);
            //Create a long which gets the current time of your system in Milliseconds
            long endTime1 = System.currentTimeMillis();
            //We create a new variable that will store the result of endtime1 - startime1;
            double time1 = endTime1 - startTime1;

            //rinse and repeat for the pefixAverage 2 method
            long startTime2 = System.currentTimeMillis();
            prefixAverage2(input);
            long endTime2 = System.currentTimeMillis();
            double time2 = endTime2 - startTime2;

            //When finished we will output what the size was for each of the methods used
            //we will output both in milliseconds for long it took to each method to runs
            System.out.println(" Size:" + size * 2 + " \n prefixAverage1 RunTime: " + time1 + " Milliseconds");
            System.out.println(" prefixAverage2 RunTime: " + time2 + " Milliseconds");

            System.out.println("===============================================================================");
        }
    }
}
