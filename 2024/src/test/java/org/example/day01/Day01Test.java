package org.example.day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Day01Test {

    @CsvSource({
        "d1-demo.txt,11",
        "d1-input.txt,2176849"
    })
    @ParameterizedTest
    void partOneTest(String fileName, int expectedValue) {
        int value = new Day01().partOne(fileName);

        Assertions.assertEquals(value, expectedValue);
    }

    @CsvSource({
        "d1-demo.txt,31",
        "d1-input.txt,23384288"
    })
    @ParameterizedTest
    void partTwoTest(String fileName, int expectedValue) {
        int value = new Day01().partTwo(fileName);

        Assertions.assertEquals(value, expectedValue);
    }
}
