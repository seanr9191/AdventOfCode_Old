package com.advent.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;


public class part2 {
    public part2() {
    }

    public int fuelForMovement(int n) {
        return (n * (n+1))/2;
    }

    public int calculateFuelCost(int[] crabs, int spot) {
        int sum = 0;
        for (int crab : crabs) {
            sum += fuelForMovement(Math.abs(crab-spot));
        }
        return sum;
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day7/part2.txt");
        Scanner in = new Scanner(input);
        int[] crabs = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int lowestCrab = Arrays.stream(crabs).min().getAsInt();
        int highestCrab = Arrays.stream(crabs).max().getAsInt();

        int lowestFuel = -1;
        for (int i = lowestCrab; i < highestCrab; i++) {
            int fuelCost = calculateFuelCost(crabs, i);
            if (lowestFuel == -1 || fuelCost < lowestFuel) {
                lowestFuel = fuelCost;
            }
        }

        System.out.printf("Fuel Cost: %d", lowestFuel);

        /*
        DONT BE LIKE ME AND TRY TO OPTIMIZE TOO EARLY.

        int[] fuelOptions = Arrays.stream(crabs).boxed().sorted().distinct().mapToInt(x -> x).toArray();

        System.out.println(Arrays.toString(crabs));
        System.out.println(Arrays.toString(fuelOptions));

        boolean foundLowestFuel = false;
        int lowestFuel = -1;
        while (!foundLowestFuel) {
            int fuelOptionCount = fuelOptions.length;
            int startingIndex = (int) Math.round(fuelOptionCount*.25);
            int endingIndex = (int) Math.round(fuelOptionCount*.75);

            int startFuel = calculateFuelCost(crabs, crabs[startingIndex]);
            int endFuel = calculateFuelCost(crabs, crabs[endingIndex]);

            if (endFuel > startFuel) {
                int startInnerFuel = calculateFuelCost(crabs, crabs[startingIndex+1]);
                int endInnerFuel = calculateFuelCost(crabs, crabs[endingIndex-1]);

                if (startInnerFuel > startFuel) {
                    lowestFuel = startFuel;
                    foundLowestFuel = true;
                } else if (endInnerFuel > endFuel) {
                    lowestFuel = endFuel;
                    foundLowestFuel = true;
                }
            }

            foundLowestFuel = true;
        }
        */




    }
}
