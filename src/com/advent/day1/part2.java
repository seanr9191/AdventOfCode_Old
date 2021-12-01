package com.advent.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class part2 {
    public part2() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day1/part2.txt");
        Scanner in = new Scanner(input);
        int lastSum = -1;
        int[] lastThree = new int[3];
        int increases = 0;
        int index = 0;
        int readNums = 0;
        while (in.hasNextInt()) {
            readNums++;
            int measure = in.nextInt();
            lastThree[index] = measure;
            index++;

            if (readNums >= 3) {
                int currSum = Arrays.stream(lastThree).sum();
                if (lastSum != -1 && currSum > lastSum) {
                    increases++;
                }
                lastSum = currSum;
                if (index % 3 == 0)
                    index = 0;
            }
        }
        System.out.println("Number of Increases: " + increases);
    }
}
