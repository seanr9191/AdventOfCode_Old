package com.advent.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1 {
    public part1() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day1/part1.txt");
        Scanner in = new Scanner(input);
        int lastMeasure = -1;
        int increases = 0;
        while (in.hasNextInt()) {
            int measure = in.nextInt();
            if (lastMeasure != -1) {
                if (measure > lastMeasure)
                    increases++;
            }
            lastMeasure = measure;
        }
        System.out.println("Number of Increases: " + increases);
    }
}
