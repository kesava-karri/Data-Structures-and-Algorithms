import java.util.Arrays;

class MaximumWealthQ1 {
    public static int bruteForce(int[][] accounts) {
        // Time Complexity: O(n * m) ; n is the length of individual accounts, m is length of accounts array
        // Space Complexity: O(n)
        /*
         * Note that only static things (let it be variables or methods) 
         * can be accessed thru the class name, non-static things need an instance to be accessed :)
         */
        int maxWealth = Integer.MIN_VALUE;
        for (int[] account : accounts) { // space complexity can be reduced by using for loop instead of for each here

            int bankWealth = 0;
            for (int i = 0; i < account.length; i++) {
                bankWealth += account[i];
            }
            if (bankWealth > maxWealth) {
                maxWealth = bankWealth;
            }
        }
        return maxWealth;
    }

    public static int builtins(int[][] accounts) {
        // System.out.println(Arrays.deepToString(accounts)); // To print multi-dimensional array

        int maxWealth = Integer.MIN_VALUE;
        int[] individualBankWealth = Arrays.stream(accounts).mapToInt(account -> Arrays.stream(account).sum())
                .toArray();
        // System.out.println(Arrays.toString(Arrays.stream(accounts).map(i -> IntStream.of(i).sum()).toArray()));

        for (int tempWealth : individualBankWealth) {
            if (tempWealth > maxWealth) {
                maxWealth = tempWealth;
            }
        }

        // System.out.println(Arrays.toString(
        //         IntStream.range(0, accounts.length).map(i -> IntStream.of(accounts[i]).sum()).toArray()));
        return maxWealth;
    }
}

class Main {
    public static void main(String[] args) {
        // System.out.println(MaximumWealthQ1.bruteForce(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }));
        // System.out.println(MaximumWealthQ1.bruteForce(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }));
        // System.out.println(MaximumWealthQ1.bruteForce(new int[][] { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } }));
        // System.out.println(MaximumWealthQ1.builtins(new int[][] { { 1, 2, 3 }, { 3, 2, 1 } }));
        // System.out.println(MaximumWealthQ1.builtins(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }));
        // System.out.println(MaximumWealthQ1.builtins(new int[][] { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } }));
    }
}