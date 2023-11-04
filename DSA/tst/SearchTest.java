package tst;

import org.junit.Test;
import src.Search;
import src.Search.FindPeakElement;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    Search obj = new Search();
    @Test
    public void testFindPeakElement() {
        FindPeakElement o1 = obj.new FindPeakElement();
        assertEquals(5, o1.findPeakElement(new int[] {1,2,1,3,5,6,4}));
    }
}
