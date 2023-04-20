/*
 * dynamic_sequence_align.java
 * 
 * Authors:  Isabel Cyr and John Morrisett
 * 
 * April 19th 2023
 * Class: Algorithms
 * Dr. Cates
 * 
 * Purpose:  A dynamic programming approach to sequence alignment
 */

class dynamic_sequence_align {

    final static int MIS_PENALTY = 1; //Misalignment penalty
    final static int GAP_PENALTY = 2; //Gap penalty
    public static void main(String args[]){
        String s1 = "AACAGTTACC"; //test cases
        String s2 = "TAAGGTCA";
        sequence_align_func(s1, s2);
    }

    public static void sequence_align_func(String s1, String s2) {

        //Get the dimensions of the matrix
        int m = s1.length(); 
        int n = s2.length();

        int[][] arr = new int[m+1][n+1];
        arr[m][n] = 0; //this is because there is no mismatch penalty starting out

        //Get row and column base penalty
        for (int i = 0; i < n; i++) {
            arr[m][i] = GAP_PENALTY*(n-i);

        }
        for (int j = 0; j < m; j++) {
            arr[j][n] = GAP_PENALTY*(m-j);
        }
            
        //Assign penalties based on sequence matching
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {

                //If characters do not match, consider it a misalignment penalty
                int penalty = 0;
                if (s1.charAt(i) != s2.charAt(j))
                    penalty = MIS_PENALTY;

                //Determine the smallest penalty out of the three options
                int a = arr[i+1][j+1] + penalty;
                int b = arr[i+1][j] + GAP_PENALTY;
                int c = arr[i][j+1] + GAP_PENALTY;
                int min_val = Integer.min(Integer.min(a, b), c);
                
                arr[i][j] = min_val;
            }
        }
        
        //print out the matrix
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.printf("%3d", arr[i][j]);
            }
            System.out.println();
        }
    }


}