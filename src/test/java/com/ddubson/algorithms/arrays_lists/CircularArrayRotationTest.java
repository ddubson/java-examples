package com.ddubson.algorithms.arrays_lists;

import org.junit.Test;

import static com.ddubson.algorithms.arrays_lists.CircularArrayRotation.rotate;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Author: ddubson
 */
public class CircularArrayRotationTest {
    @Test
    public void circularArrayRotation() throws Exception {
        int[] input = new int[] {3,4,1};

        // 0 rotations
        assertThat(rotate(input, 0), equalTo(input));

        // empty array
        assertThat(rotate(new int[1], 0), equalTo(new int[1]));

        // 1 rotation
        int[] rotated = rotate(input, 1);
        assertThat(rotated[0], equalTo(1));
        assertThat(rotated[1], equalTo(3));
        assertThat(rotated[2], equalTo(4));
    }


}