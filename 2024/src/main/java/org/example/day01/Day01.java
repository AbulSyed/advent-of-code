package org.example.day01;

import org.example.util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day01 {

    private static final String DEMO_TXT = "demo.txt";
    private static final String INPUT_TXT = "input.txt";

    public static void main(String[] args) {
        partOne(DEMO_TXT);
        partOne(INPUT_TXT);
        partTwo(DEMO_TXT);
        partTwo(INPUT_TXT);
    }

    public static int partOne(String fileName) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int result = 0;

        try {
            List<String> lines = new Util().getFileAsInputStream(fileName);

            for (String line : lines) {
                String[] lineArr = line.split("   ");
                left.add(Integer.valueOf(lineArr[0]));
                right.add(Integer.valueOf(lineArr[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        left = left.stream().sorted().toList();
        right = right.stream().sorted().toList();

        for (int i = 0; i < left.size(); i++) {
            int diff = Math.abs(left.get(i) - right.get(i));
            result += diff;
        }

        System.out.println(result);

        return result;
    }

    public static int partTwo(String fileName) {
        List<Integer> left = new ArrayList<>();
        Map<Integer, Integer> rightValOccuranceMap = new HashMap<>();
        int result = 0;

        try {
            List<String> lines = new Util().getFileAsInputStream(fileName);

            for (String line : lines) {
                String[] lineArr = line.split("   ");
                left.add(Integer.valueOf(lineArr[0]));
                int rightVal = Integer.valueOf(lineArr[1]);

                if (!rightValOccuranceMap.containsKey(rightVal)) {
                    rightValOccuranceMap.put(rightVal, 1);
                } else {
                    rightValOccuranceMap.put(rightVal, rightValOccuranceMap.get(rightVal) + 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Integer val : left) {
            if (rightValOccuranceMap.containsKey(val)) {
                result += (val * rightValOccuranceMap.get(val));
            }
        }

        System.out.println(result);

        return result;
    }

}
