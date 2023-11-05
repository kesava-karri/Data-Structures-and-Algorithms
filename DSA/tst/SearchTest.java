package tst;

import org.junit.Test;
import src.Search;
import src.Search.FindPeakElement;
import src.Search.SearchInRotatedSortedArray;
import util.MyUtilityClass;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    Search obj = new Search();

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
