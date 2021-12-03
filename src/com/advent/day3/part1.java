package com.advent.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class part1 {
    public part1() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day3/part1.txt");
        Scanner in = new Scanner(input);

        int[] commons = new int[0];
        while (in.hasNextLine()) {
            String reading = in.nextLine();
            char[] readingChars = reading.toCharArray();

            if (commons.length == 0)
                commons = new int[reading.length()];

            for (int i = 0; i < readingChars.length; i++) {
                if (readingChars[i] == '0') {
                    commons[i] -= 1;
                } else {
                    commons[i] += 1;
                }
            }
        }

        String gamma = "";
        String epsilon = "";
        for (int i = 0; i < commons.length; i++) {
            if (commons[i] < 0) {
                gamma += "0";
                epsilon += "1";
            } else {
                gamma += "1";
                epsilon += "0";
            }
        }

        int gammaValue = Integer.parseInt(gamma, 2);
        int epsilonValue = Integer.parseInt(epsilon, 2);


        System.out.println(String.format("Gamma: %s (%d), Epsilon: %s (%d), Multiplied: %d",
                gamma, gammaValue,
                epsilon, epsilonValue,
                gammaValue*epsilonValue));
    }
}
