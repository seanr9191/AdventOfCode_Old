package com.advent.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class part1 {
    public part1() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day6/part1.txt");
        Scanner in = new Scanner(input);
        List<Integer> fishies = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());



        for (int i = 0; i < 11; i++) {
            List<Integer> newFish = new ArrayList<>();
            for (int fish : fishies) {
                if (fish >= 7) {
                    newFish.add(fish-7);
                } else {
                    newFish.add(fish);
                    newFish.add(fish+2);
                }
            }
            fishies.clear();
            fishies.addAll(newFish);
            System.out.println("Day " + (7*(i+1)) + ": " + fishies.size());
        }

        for (int i = 0; i < 3; i++) {
            List<Integer> newFish = new ArrayList<>();
            for (int fish : fishies) {
                fish = fish - 1;
                if (fish < 0) {
                    fish = 6;
                    newFish.add(8);
                }
                newFish.add(fish);
            }
            fishies.clear();
            fishies.addAll(newFish);
            System.out.println("Day " + (77+(i+1)) + ": " + fishies.size());
        }

        System.out.printf("Fish Count: %d", fishies.size());


    }
}
