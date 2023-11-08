package tst;

import org.junit.Test;
import src.Search;
import src.Search.FindMinRotatedSortedArrayII;
import src.Search.FindPeakElement;
import src.Search.SearchInRotatedSortedArray;
import src.Search.SearchInRotatedSortedArrayII;
import util.MyUtilityClass;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchTest {
    Search obj = new Search();

    @Test
    public void testFindMinRotatedSortedArrayII() {
        FindMinRotatedSortedArrayII o1 = obj.new FindMinRotatedSortedArrayII();
        assertEquals(1,o1.findMin(new int[] {10,1,10,10,10}));
        assertEquals(1,o1.findMin(new int[] {3,5,1}));
        assertEquals(0,o1.findMin(new int[] {4,5,6,7,0,1,2}));
        assertEquals(1,o1.findMin(new int[] {1,3,5}));
        assertEquals(1,o1.findMin(new int[] {1}));
    }

    @Test
    public void testSearchInRotatedSortedArrayII() {
        SearchInRotatedSortedArrayII o1 = obj.new SearchInRotatedSortedArrayII();

        assertTrue(o1.search(new int[] {1,0,1,1,1}, 0));
        assertFalse(o1.search(new int[] {1,1,1,1,3,1}, 3));
    }

    @Test
    public void testSearchInRotatedSortedArray() {
        SearchInRotatedSortedArray o1 = obj.new SearchInRotatedSortedArray();
        assertEquals(6, o1.search(new int[] {8,1,2,3,4,5,6,7}, 6));
    }

    @Test
    public void testFindPeakElement() {
        FindPeakElement o1 = obj.new FindPeakElement();
        assertEquals(5, o1.findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }
}
