package com.mycompany.algorithm_final_project;

import java.util.Scanner;

/**
 *
 * @author israkkayumchowdhury
 */
public class LongestCommonSubsequence {

    public String lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Compute the length of lcs for all substrings
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Construct the lcs string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.toString();
    }

    public void main_func() {
        Scanner s = new Scanner(System.in);

        System.out.print(" Enter the first string: ");
        String str1 = s.nextLine();

        System.out.print(" Enter the second string: ");
        String str2 = s.nextLine();

        String lcs = lcs(str1, str2);
        System.out.println(" Longest Common Subsequence: " + lcs);
    }
}
