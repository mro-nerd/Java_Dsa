/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above*/

import java.util.*;

public class nQueen {

    ArrayList<StringBuilder> board;
    boolean[] col, tlTobr, blTotr;

    boolean isSafe(int i, int j, int n) {
        return !col[j] && !tlTobr[i - j + n - 1] && !blTotr[i + j];
    }

    void exploreAllOptions(int i, int n, List<List<String>> validOptions) {
        if (i == n) {
            List<String> compatibleBoard = new ArrayList<>();
            for (StringBuilder sb : board) {
                compatibleBoard.add(sb.toString());
            }
            validOptions.add(compatibleBoard);
            return;
        }

        for (int j = 0; j < n; ++j) {
            if (isSafe(i, j, n)) {
                board.get(i).setCharAt(j, 'Q');
                col[j] = true;
                tlTobr[i - j + n - 1] = true;
                blTotr[i + j] = true;

                exploreAllOptions(i + 1, n, validOptions);

                board.get(i).setCharAt(j, '.'); // Backtrack
                col[j] = false;
                tlTobr[i - j + n - 1] = false;
                blTotr[i + j] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        StringBuilder nDots = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            nDots.append(".");
        }

        board = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            board.add(new StringBuilder(nDots));
        }

        col = new boolean[n];
        tlTobr = new boolean[2 * n];
        blTotr = new boolean[2 * n];

        List<List<String>> validOptions = new ArrayList<>();
        exploreAllOptions(0, n, validOptions);
        return validOptions;
    }

    public static void main(String[] args) {
        nQueen obj=new nQueen();
        int n = 4;

        List<List<String>> solutions = obj.solveNQueens(n);

        System.out.println("Valid N-Queens configurations for n = " + n + ":");
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
