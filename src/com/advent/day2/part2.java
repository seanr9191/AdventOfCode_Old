package com.advent.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2 {
    public part2() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day2/part2.txt");
        Scanner in = new Scanner(input);
        int depth = 0;
        int distance = 0;
        int aim = 0;
        while (in.hasNextLine()) {
            String movement = in.next();
            int value = in.nextInt();

            switch (movement) {
                case "forward":
                    distance += value;
                    depth += aim*value;
                    break;
                case "up":
                    aim -= value;
                    break;
                case "down":
                    aim += value;
                    break;
                default:
                    break;
            }
        }

        System.out.println(String.format("Depth: %d, Distance: %d, Multiplied: %d", depth, distance, depth*distance));
    }
}
