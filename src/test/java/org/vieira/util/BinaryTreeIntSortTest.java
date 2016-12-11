package org.vieira.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Fernando José Vieira
 *
 */
public class BinaryTreeIntSortTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testArrayOutOfBoundInSortAscending() {
        Assert.assertArrayEquals(new int[] {}, BinaryTreeIntSort.sortArrayAscending(new int[] {}));
    }

    @Test
    public void testSortAscending() {

        Assert.assertArrayEquals(new int[] { 1 }, BinaryTreeIntSort.sortArrayAscending(new int[] { 1 }));

        Assert.assertArrayEquals(new int[] { 0, 0, 0 }, BinaryTreeIntSort.sortArrayAscending(new int[] { 0, 0, 0 }));

        Assert.assertArrayEquals(new int[] { 1, 2, 3 }, BinaryTreeIntSort.sortArrayAscending(new int[] { 1, 2, 3 }));

        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 },
                BinaryTreeIntSort.sortArrayAscending(new int[] { 1, 2, 3, 4, 5, 6 }));

        Assert.assertArrayEquals(new int[] { 2, 3, 4, 5, 6 },
                BinaryTreeIntSort.sortArrayAscending(new int[] { 6, 2, 3, 4, 5 }));

        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 },
                BinaryTreeIntSort.sortArrayAscending(new int[] { 6, 5, 4, 3, 2, 1 }));

        Assert.assertArrayEquals(new int[] { 0, 1, 2, 3, 4, 5, 6, 1000 },
                BinaryTreeIntSort.sortArrayAscending(new int[] { 6, 5, 4, 1, 2, 3, 0, 1000 }));

        Assert.assertArrayEquals(new int[] { -1000, 0, 1, 2, 3, 4, 5, 6 },
                BinaryTreeIntSort.sortArrayAscending(new int[] { 6, 5, 4, 1, 2, 3, 0, -1000 }));

        Assert.assertArrayEquals(new int[] { -2, -2, -1, -1, 0, 1, 2, 3 },
                BinaryTreeIntSort.sortArrayAscending(new int[] { -1, -2, -1, -2, 3, 2, 1, 0 }));
    }

    @Test
    public void testSortDescending() {
        Assert.assertArrayEquals(new int[] { 1 }, BinaryTreeIntSort.sortArrayDescending(new int[] { 1 }));

        Assert.assertArrayEquals(new int[] { 0, 0, 0 }, BinaryTreeIntSort.sortArrayDescending(new int[] { 0, 0, 0 }));

        Assert.assertArrayEquals(new int[] { 3, 2, 1 }, BinaryTreeIntSort.sortArrayDescending(new int[] { 1, 2, 3 }));

        Assert.assertArrayEquals(new int[] { 6, 5, 4, 3, 2, 1 },
                BinaryTreeIntSort.sortArrayDescending(new int[] { 1, 2, 3, 4, 5, 6 }));

        Assert.assertArrayEquals(new int[] { 6, 5, 4, 3, 2 },
                BinaryTreeIntSort.sortArrayDescending(new int[] { 6, 2, 3, 4, 5 }));

        Assert.assertArrayEquals(new int[] { 6, 5, 4, 3, 2, 1 },
                BinaryTreeIntSort.sortArrayDescending(new int[] { 6, 5, 4, 3, 2, 1 }));

        Assert.assertArrayEquals(new int[] { 1000, 6, 5, 4, 3, 2, 1, 0 },
                BinaryTreeIntSort.sortArrayDescending(new int[] { 6, 5, 4, 1, 2, 3, 0, 1000 }));

        Assert.assertArrayEquals(new int[] { 3, 2, 1, 0, -1, -1, -2, -2 },
                BinaryTreeIntSort.sortArrayDescending(new int[] { -1, -2, -1, -2, 3, 2, 1, 0 }));
    }
}
