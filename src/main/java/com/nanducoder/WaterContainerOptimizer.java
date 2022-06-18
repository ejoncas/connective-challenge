package com.nanducoder;

public class WaterContainerOptimizer {

    /**
     * Given an array of bar heights, it assumes the area between the bars can be filled with water and it tries
     * to find the optimal bars that would allow for the max area to be filled with water.
     * It returns the optimal area, discarding what bars actually give you that result
     *
     * @param heights the height of each bar. From left to right.
     * @return the optimal area for water
     */
    public int optimizeArea(int[] heights) {
        int result = 0;
        int leftPointer = 0;
        int rightPointer = heights.length - 1;
        while (leftPointer < rightPointer) {
            // We start with the widest possible container
            int containerWidth = rightPointer - leftPointer;

            // We calculate the area on each step and replace the result if the current area is bigger than current one
            // we also consider the lowers height as water would only get as high as that bar
            int leftHeight = heights[leftPointer];
            int rightHeight = heights[rightPointer];
            int containerArea = Math.min(leftHeight, rightHeight) * containerWidth;
            if (containerArea > result) {
                result = containerArea;
            }

            // finally we're trying to maximise the area so we keep going by moving forward from the lowest side.
            if (leftHeight <= rightHeight) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return result;
    }
}
