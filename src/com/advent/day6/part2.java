package com.advent.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class part2 {
    public part2() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day6/part2.txt");
        Scanner in = new Scanner(input);
        List<Integer> fishies = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());


        long[] fishCount = new long[9];

        for (int fish : fishies) {
            fishCount[fish]++;
        }


        for (int i = 0; i < 36; i++) {
            long[] newFishCount = new long[9];
            for (int p = 0; p < fishCount.length; p++) {
                if (p >= 7) {
                    newFishCount[p-7] += fishCount[p];
                } else {
                    newFishCount[p] += fishCount[p];
                    newFishCount[p+2] += fishCount[p];
                }
            }
            fishCount = newFishCount;


            System.out.println("Day " + (7*(i+1)) + ": " + Arrays.stream(fishCount).sum());
        }

        for (int i = 0; i < 4; i++) {
            long[] newFishCount = new long[9];
            for (int p = 0; p < fishCount.length; p++) {
                if (p == 0) {
                    newFishCount[8] += fishCount[0];
                    newFishCount[6] += fishCount[0];
                } else {
                    newFishCount[p-1] += fishCount[p];
                }
            }
            fishCount = newFishCount;
            System.out.println("Day " + (252+(i+1)) + ": " + Arrays.stream(fishCount).sum());
        }


    }
}
