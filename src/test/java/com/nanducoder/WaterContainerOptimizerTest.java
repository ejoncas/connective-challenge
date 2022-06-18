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
            Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49)
        );
    }

    @ParameterizedTest
    @MethodSource("problem2Scenarios")
    public void testFindingOptimalContainerArea(int[] input, int expectedArea) {
        assertThat(PROBLEM_2.optimizeArea(input), is(expectedArea));
    }


}