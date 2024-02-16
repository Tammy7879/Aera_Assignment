package org.example.Questions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrappingRainWaterTest {

    private Trapping_rain_water TrappingRainWater ;


    @Test
    public void testTrappingRainWater() {
        int[] trap = {3, 2, 0, 5, 1, 3, 6};
        int expectedTotalUnits = 10 ; // Expected total units of trapped rainwater

        int actualTotalUnits = Trapping_rain_water.calculateTrappedWater(trap);

        assertEquals(expectedTotalUnits, actualTotalUnits, "Total units of trapped water should match");
    }

    @Test
    public void testTrappingRainWaterWithEmptyArray() {
        int[] trap = {};
        int expectedTotalUnits = 0; // Expected total units of trapped rainwater in an empty array

        int actualTotalUnits = TrappingRainWater.calculateTrappedWater(trap);

        assertEquals(expectedTotalUnits, actualTotalUnits, "Total units of trapped water should be 0 for an empty array");
    }

    @Test
    public void testTrappingRainWaterWithSingleElement() {
        int[] trap = {5};
        int expectedTotalUnits = 0; // Expected total units of trapped rainwater for a single element array

        int actualTotalUnits = Trapping_rain_water.calculateTrappedWater(trap);

        assertEquals(expectedTotalUnits, actualTotalUnits, "Total units of trapped water should be 0 for a single element array");
    }

    @Test
    public void testTrappingRainWaterWithDescendingArray() {
        int[] trap = {5, 4, 3, 2, 1};
        int expectedTotalUnits = 0; // Expected total units of trapped rainwater for a descending array

        int actualTotalUnits = Trapping_rain_water.calculateTrappedWater(trap);

        assertEquals(expectedTotalUnits, actualTotalUnits, "Total units of trapped water should be 0 for a descending array");
    }
}

