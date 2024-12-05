package org.example.day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Day02Test {

    @CsvSource({
        "d2-demo.txt,2",
        "d2-input.txt,242"
    })
    @ParameterizedTest
    void partOneTest(String fileName, int expectedValue) {
        int value = new Day02().partOne(fileName);

        Assertions.assertEquals(value, expectedValue);
    }

    @CsvSource({
            "d2-demo.txt,4",
            "d2-input.txt,311"
    })
    @ParameterizedTest
    void partTwoTest(String fileName, int expectedValue) {
        int value = new Day02().partTwo(fileName);

        Assertions.assertEquals(value, expectedValue);
    }
}
