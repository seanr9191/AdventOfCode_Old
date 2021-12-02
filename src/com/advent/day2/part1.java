package com.advent.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part1 {
    public part1() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day2/part1.txt");
        Scanner in = new Scanner(input);
        int depth = 0;
        int distance = 0;
        while (in.hasNextLine()) {
            String movement = in.next();
            int value = in.nextInt();

            switch (movement) {
                case "forward":
                    distance += value;
                    break;
                case "up":
                    depth -= value;
                    break;
                case "down":
                    depth += value;
                    break;
                default:
                    break;
            }
        }

        System.out.println(String.format("Depth: %d, Distance: %d, Multiplied: %d", depth, distance, depth*distance));
    }
}
