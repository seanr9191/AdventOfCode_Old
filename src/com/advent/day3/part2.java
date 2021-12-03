package com.advent.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class part2 {
    public part2() {
    }

    public void solve() throws FileNotFoundException {
        File input = new File("src/com/advent/day3/part2.txt");
        Scanner in = new Scanner(input);

        ArrayList<String> readingsOxygen = new ArrayList<String>();
        ArrayList<String> readingsCO2 = new ArrayList<String>();
        while (in.hasNextLine()) {
            String currReading = in.nextLine();
            readingsOxygen.add(currReading);
            readingsCO2.add(currReading);
        }

        int currIndex = 0;
        while (readingsOxygen.size() > 1 && currIndex < readingsOxygen.get(0).length()) {
            int currCount = 0;
            for (String reading : readingsOxygen) {
                if (reading.charAt(currIndex) == '0') {
                    currCount -= 1;
                } else {
                    currCount += 1;
                }
            }

            int finalCurrIndex = currIndex;
            if (currCount < 0) {
                readingsOxygen.removeIf(reading -> {
                    if (reading.charAt(finalCurrIndex) == '1') {
                        return true;
                    }
                    return false;
                });
            } else {
                readingsOxygen.removeIf(reading -> {
                    if (reading.charAt(finalCurrIndex) == '0') {
                        return true;
                    }
                    return false;
                });
            }

            currIndex++;
        }

        currIndex = 0;
        while (readingsCO2.size() > 1 && currIndex < readingsCO2.get(0).length()) {
            int currCount = 0;
            for (String reading : readingsCO2) {
                if (reading.charAt(currIndex) == '0') {
                    currCount -= 1;
                } else {
                    currCount += 1;
                }
            }

            int finalCurrIndex = currIndex;
            if (currCount < 0) {
                readingsCO2.removeIf(reading -> {
                    if (reading.charAt(finalCurrIndex) == '0') {
                        return true;
                    }
                    return false;
                });
            } else {
                readingsCO2.removeIf(reading -> {
                    if (reading.charAt(finalCurrIndex) == '1') {
                        return true;
                    }
                    return false;
                });
            }

            currIndex++;
        }

        String oxygenRating = readingsOxygen.get(0);
        String co2Rating = readingsCO2.get(0);

        int oxygenValue = Integer.parseInt(oxygenRating, 2);
        int co2Value = Integer.parseInt(co2Rating, 2);


        System.out.println(String.format("Oxygen: %s (%d), CO2: %s (%d), Multiplied: %d",
                oxygenRating, oxygenValue,
                co2Rating, co2Value,
                oxygenValue*co2Value));
    }
}
