package com.nanducoder;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class WaterContainerOptimizerTest {

    public static final WaterContainerOptimizer PROBLEM_2 = new WaterContainerOptimizer();

    private static Stream<Arguments> problem2Scenarios() {
        return Stream.of(
            //problem sample cases
            Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
            Arguments.of(new int[]{1, 2}, 1),
            Arguments.of(new int[]{4, 3, 2, 1, 4}, 16),
            Arguments.of(new int[]{1, 2, 1}, 2),
            Arguments.of(new int[]{1, 1}, 1),
            //middle high bars narrow container
            Arguments.of(new int[]{4, 3, 2, 100, 1, 100, 2, 3, 4}, 200),
            //right side high bars narrow container
            Arguments.of(new int[]{4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8, 100, 1, 100, 19}, 200),
            //left side high bars narrow container
            Arguments.of(new int[]{18, 100, 1, 100, 8, 7, 6, 5, 4, 3, 2, 1}, 200),
            //edge cases - return 0
            Arguments.of(new int[]{}, 0),
            Arguments.of(new int[]{0, 0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("problem2Scenarios")
    public void testFindingOptimalContainerArea(int[] input, int expectedArea) {
        assertThat(PROBLEM_2.optimizeArea(input), is(expectedArea));
    }

}