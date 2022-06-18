package com.nanducoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumCalculator {

    /**
     * Find the 2 numbers in the array that add up to {@param target}, returning their respective indexes
     *
     * @param numbers the input numbers
     * @param target  the target that we want to find 2 numbers to add up
     * @return the 2 indexes belonging to the 2 respective numbers that add up to target
     * @implNote This could have been implemented with brute force on O(n^2). This is slightly more complicated but it
     * performs better on O(n)
     */
    public int[] findIndicesThatAddUp(int[] numbers, int target) {
        Map<Integer, List<Integer>> indicesLookup = new HashMap<>();

        // Create a map of all present numbers and their respective indices.
        // This would be useful to find the needed counterpart to add up to target
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            List<Integer> indices = indicesLookup.computeIfAbsent(number, k -> new ArrayList<>());
            indices.add(i);
        }

        // now that the map is ready, we can simply check if for each number exists the value ($target - number)
        for (int i = 0; i < numbers.length; i++) {
            int number1 = numbers[i];
            int number2 = target - number1;
            List<Integer> number2Indexes = indicesLookup.get(number2);
            if (number2Indexes != null) {
                if (number1 != number2) {
                    // we found the counterpart. Let's return the 2 indices. If there are multiple combinations we assume the first index
                    return new int[]{i, number2Indexes.get(0)};
                } else if (number2Indexes.size() > 1) {
                    // the number is the same, so we need to make sure we return both different indexes
                    return new int[]{number2Indexes.get(0), number2Indexes.get(1)};
                }
            }
        }
        throw new IllegalArgumentException(
            "There is no 2 numbers in input array that add up to target. input=" + numbers + " target=" + target
        );
    }

}
