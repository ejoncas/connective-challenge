package com.nanducoder;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class TwoSumCalculatorTest {

    public static final TwoSumCalculator PROBLEM_1 = new TwoSumCalculator();

    private static Stream<Arguments> problem1Scenarios() {
        return Stream.of(
            Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
            Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
            Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("problem1Scenarios")
    public void checkNumbersThatAddUp(int[] input, int target, int[] expectedIndexes) {
        assertThat(PROBLEM_1.findIndicesThatAddUp(input, target), is(expectedIndexes));
    }

}