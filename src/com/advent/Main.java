package com.advent;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("------------");
        System.out.println("Day 1 Part 1");
        System.out.println("------------");
        com.advent.day1.part1 day1part1 = new com.advent.day1.part1();
        day1part1.solve();
        System.out.println();
        System.out.println();

        System.out.println("------------");
        System.out.println("Day 1 Part 2");
        System.out.println("------------");
        com.advent.day1.part2 day1part2 = new com.advent.day1.part2();
        day1part2.solve();
        System.out.println();
        System.out.println();
    }
}
