import java.util.Arrays;

public class Uniqueness {

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique1(int[] data) {
        int n = data.length;
        for (int j=0; j < n-1; j++)
            for (int k=j+1; k < n; k++)
                if (data[j] == data[k])
                    return false;                    // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique2(int[] data) {
        int n = data.length;
        int[] temp = Arrays.copyOf(data, n);   // make copy of data
        Arrays.sort(temp);                     // and sort the copy
        for (int j=0; j < n-1; j++)
            if (temp[j] == temp[j+1])            // check neighboring entries
                return false;                      // found duplicate pair
        return true;                           // if we reach this, elements are unique
    }

    public static void main(String[] args)
    {
        // Start with a small value
        int initialN = 100;

        // Set maxLimit so N does not go higher the Integer max value
        int maxLimit = Integer.MAX_VALUE;

        //Setting Flag for whether to use Unique 1 for not
        boolean useUnique1 = true;

        while (initialN < maxLimit) {

            //Self Explanatory
            long startTime = System.currentTimeMillis();

            // Generating a random array to change the N value
            int[] dataArray = new int[initialN];
            for (int i = 0; i < initialN; i++) {
                dataArray[i] = (int) (Math.random() * 100);
            }

            boolean result;

            if (useUnique1)
            {
                result = unique1(dataArray);
            }
            else
            {
                result = unique2(dataArray);
            }

            //Self Explanatory
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;

            System.out.println("n: " + initialN + " RuntTime: " + (useUnique1 ? "unique1" : "unique2") +
                    ", Time: " + elapsedTime + "ms");

            System.out.println("===============================================================================");

            //Were checking if it's less the 1 minute (60000) Milliseconds
            if (elapsedTime < 60000) {
                // if it is we dobule the inital value of N
                initialN *= 2;
            }
            else
            {
                // if it takes longer then the 1 minute we set the max limit to whatever N was at
                maxLimit = initialN;
            }
            //Flags it for the next iteration to do Unique2
            useUnique1 = !useUnique1;
        }
    }
}

