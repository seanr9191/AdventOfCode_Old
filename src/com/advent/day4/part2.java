package com.advent.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/* Note: All numbers are bumped up by 1 to allow for negative values signifying a marked number.
         0 is a valid number, so we needed to normalize all values. Printed board and called numbers
         will not match what is in the input file, but when calculating the score, we bring the values
         back to match the input, guaranteeing the correct score.
 */
public class part2 {
    public part2() {
    }

    public boolean isBingo(int[][] board, int startingy, int startingx) {
        boolean foundBingox = true;
        boolean foundBingoy = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][startingx] > 0) {
                foundBingox = false;
            }
            if (board[startingy][i] > 0) {
                foundBingoy = false;
            }
            if (!foundBingox && !foundBingoy)
                break;
        }

        return foundBingox || foundBingoy;
    }

    public int calculateScore(int[][] board, int lastCalledNumber) {
        int score = 0;
        for (int i = 0; i < board.length; i++) {
            for (int p = 0; p < board[i].length; p++) {
                if (board[i][p] > 0) {
                    score += board[i][p]-1;
                }
            }
        }
        return score*(lastCalledNumber-1);
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day4/part2.txt");
        Scanner in = new Scanner(input);

        List<Integer> numbers = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt).map(n -> n+1).collect(Collectors.toList());

        int[][] bestBoard = new int[0][];
        int bestScore = 0;
        int slowestBingo = -1;
        while (in.hasNextLine()) {
            in.nextLine();
            int[][] currBoard = new int[5][5];
            for (int i = 0; i < 5; i++) {
                String[] currBoardLine = in.nextLine().trim().split("\\s+");
                for (int p = 0; p < currBoardLine.length; p++) {
                    currBoard[i][p] = Integer.parseInt(currBoardLine[p])+1;
                }
            }

            bingocheck:
            for (int numIndex = 0; numIndex < numbers.size(); numIndex++) {
                for (int i = 0; i < 5; i++) {
                    for (int p = 0; p < currBoard[i].length; p++) {
                        if (currBoard[i][p] == numbers.get(numIndex)) {
                            currBoard[i][p] *= -1;
                            if (isBingo(currBoard, i, p)) {
                                if (numIndex+1 <= slowestBingo)
                                    break bingocheck;
                                slowestBingo = numIndex+1;
                                bestScore = calculateScore(currBoard, numbers.get(numIndex));
                                bestBoard = currBoard;
                                break bingocheck;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Winning Board: \n" + Arrays.deepToString(bestBoard).replace("], ", "]\n"));
        System.out.println(String.format("Score: %d, Number of Turns: %d", bestScore, slowestBingo));
    }
}
