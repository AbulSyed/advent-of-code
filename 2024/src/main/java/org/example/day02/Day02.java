package org.example.day02;

import org.example.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 {

    private static final String DEMO_TXT = "d2-demo.txt";
    private static final String INPUT_TXT = "d2-input.txt";

    public static void main(String[] args) {
        partOne(DEMO_TXT);
        partOne(INPUT_TXT);
        partTwo(DEMO_TXT);
        partTwo(INPUT_TXT);
    }

    public static int partOne(String fileName) {
        int counter = 0;

        try {
            List<String> lines = new Util().getFileAsInputStream(fileName);

            for (String line : lines) {
                List<Integer> lineArr = Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .toList();
                if (isSafe(lineArr)) {
                    counter++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);

        return counter;
    }

    public static int partTwo(String fileName) {
        int counter = 0;

        try {
            List<String> lines = new Util().getFileAsInputStream(fileName);

            for (String line : lines) {
                List<Integer> lineArr = Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .toList();
                if (isSafe(lineArr)) {
                    counter++;
                } else {
                    for (int i = 0; i < lineArr.size(); i++) {
                        List<Integer> modifiedLineArr = new ArrayList<>(lineArr);
                        modifiedLineArr.remove(i);
                        if (isSafe(modifiedLineArr)) {
                            counter++;
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter);

        return counter;
    }

    private static boolean isSafe(List<Integer> input) {
        boolean increasing = false;
        boolean decreasing = false;
        boolean atLeastOneOrMostThree = true;

        int l = 0;
        int r = 1;

        while (r < input.size()) {
            int diff = Math.abs(input.get(l) - input.get(r));

            if (input.get(r) > input.get(l)) {
                increasing = true;
                if (diff < 1 || diff > 3) {
                    atLeastOneOrMostThree = false;
                    break;
                }
            } else {
                decreasing = true;
                if (diff < 1 || diff > 3) {
                    atLeastOneOrMostThree = false;
                    break;
                }
            }

            if (increasing && decreasing) {
                return false;
            }

            l++;
            r++;
        }

        return increasing != decreasing && atLeastOneOrMostThree;
    }
}
