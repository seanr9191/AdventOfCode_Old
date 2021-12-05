package com.advent.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/* Note: All numbers are bumped up by 1 to allow for negative values signifying a marked number.
         0 is a valid number, so we needed to normalize all values. Printed board and called numbers
         will not match what is in the input file, but when calculating the score, we bring the values
         back to match the input, guaranteeing the correct score.
 */
public class part1 {
    public part1() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day5/part1.txt");
        Scanner in = new Scanner(input);

        HashMap<String, Integer> vents = new HashMap<>();
        int count = 0;
        while (in.hasNextLine()) {
            String[] ventLine = in.nextLine().split(" -> ");
            String startPoint = ventLine[0];
            String endPoint = ventLine[1];

            String[] startValues = startPoint.split(",");
            String[] endValues = endPoint.split(",");

            int startx = Integer.parseInt(startValues[0]);
            int starty = Integer.parseInt(startValues[1]);

            int endx = Integer.parseInt(endValues[0]);
            int endy = Integer.parseInt(endValues[1]);

            // Normalize so lower values are first.
            if (startx > endx || starty > endy) {
                int tempx = startx;
                startx = endx;
                endx = tempx;
                int tempy = starty;
                starty = endy;
                endy = tempy;
            }

            if (startx == endx) {
                for (int i = starty; i <= endy; i++) {
                    String key = startx + "," + i;
                    if (vents.containsKey(key)) {
                        vents.put(key, vents.get(key)+1);
                    } else {
                        vents.put(key, 1);
                    }
                }
            } else if (starty == endy) {
                for (int i = startx; i <= endx; i++) {
                    String key = i + "," + starty;
                    if (vents.containsKey(key)) {
                        vents.put(key, vents.get(key)+1);
                    } else {
                        vents.put(key, 1);
                    }
                }
            }
        }

        for (int value : vents.values()) {
            if (value > 1)
                count++;
        }

        System.out.printf("Count: %d", count);
    }
}
