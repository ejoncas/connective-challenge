package com.nanducoder;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class TwoSumCalculatorTest {

    public static final TwoSumCalculator PROBLEM_1 = new TwoSumCalculator();

    private static Stream<Arguments> problem1Scenarios() {
        return Stream.of(
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1}),
            Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2, 2}, 4, new int[]{0, 1}),
            Arguments.of(new int[]{2, 2, 1, 2, 1, 2, 2, 2}, 3, new int[]{0, 2}),
            //some negative numbers testing as well
            Arguments.of(new int[]{2, 1, 2, 3, -2, 5, 2, 3}, 0, new int[]{0, 4}),
            Arguments.of(new int[]{-2, -3, -4, -5, -6}, -8, new int[]{0, 4}),
            // 0 + 0 = 0
            Arguments.of(new int[]{0, 2, 2, 3, 3, 0, 2, 2, 3, 3}, 0, new int[]{0, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("problem1Scenarios")
    public void checkNumbersThatAddUp(int[] input, int target, int[] expectedIndexes) {
        assertThat(PROBLEM_1.findIndicesThatAddUp(input, target), is(expectedIndexes));
    }

    private static Stream<Arguments> problem1FailScenarios() {
        return Stream.of(
            Arguments.of(new int[]{}, 6),
            Arguments.of(new int[]{100, 200}, 123)
        );
    }

    @ParameterizedTest
    @MethodSource("problem1FailScenarios")
    public void testFailure() {
        try {
            PROBLEM_1.findIndicesThatAddUp(new int[]{100, 200}, 123);
            Assertions.fail("Expected exception");
        } catch (Exception e) {
            assertThat(e.getMessage(), containsString("There is no 2 numbers in input array that add up to target"));
        }
    }

}