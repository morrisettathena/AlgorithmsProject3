/****************************************************************************
 * Author: Hirwa Ishimwe
 * Date: April 17, 2023
 * Description: Sequence Alignment Using Divide-and-Conquer Basic Operations
 ****************************************************************************/

 public class DivideConquer_BasicOperations {

    //Define global variable for the comparison counter
    private static int comparisons = 0;
    
    //Main
    public static void main(String[] args) {

        //Define two DNA sequences as strings
        String x = "AACAGTTACC";
        String y = "TAAGGTCA";

        //Get the length of each sequence
        int m = x.length();
        int n = y.length();

        //Calculate the optimal cost of alignment
        int result = opt(x, y, m, n, 0, 0);

        //Print the result
        System.out.println("The optimal cost of alignment is: " + result);
        System.out.println("The number of comparisons made is: " + getComparisonCount());
    }

    public static int opt(String x, String y, int m, int n, int i, int j) {
        //Base case: if we reach the end of the first sequence
        if (i == m) {
            comparisons++; //Increment the counter for the If comparison
            return 2 * (n - j);
        }
        //Base case: if we reach the end of the second sequence
        else if (j == n) {
            comparisons += 2; //Increment the counter for the If and if-else comparisons
            return 2 * (m - i);
        } else {
            comparisons += 3; //Increment the counter for the If and if-else comparisons
                            // plus the if-else comparison
            int penalty;

            //Determine the penalty for a mismatch between the current characters
            if (x.charAt(i) == y.charAt(j)) {
                penalty = 0;
            } else {
                penalty = 1;
            }

            //Recursively compute the optimal cost for the three possible moves
            return Math.min(Math.min(opt(x, y, m, n, i + 1, j + 1) + penalty,
                                     opt(x, y, m, n, i + 1, j) + 2),
                            opt(x, y, m, n, i, j + 1) + 2);
        }
    }
    // Get the number of comparison count
    public static int getComparisonCount() {
        return comparisons;
    }
}

