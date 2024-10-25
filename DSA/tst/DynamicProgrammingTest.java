package tst;

import org.junit.Test;
import src.DynamicProgramming;
import src.DynamicProgramming.ClimbStairs;
import src.DynamicProgramming.FibonacciSeries;
import src.DynamicProgramming.FindMaximumPathSum;
import src.DynamicProgramming.HouseRobber;

import static org.junit.Assert.assertEquals;

public class DynamicProgrammingTest {
    DynamicProgramming dpObj = new DynamicProgramming();

    @Test
    public void testFindMaximumPathSum() {
        FindMaximumPathSum o = dpObj.new FindMaximumPathSum();
        int[][] grid = new int[][] {{0,0,0,0,5}, {0,1,1,1,0}, {2,0,0,0,0}};
        assertEquals(10, o.maxPathSum(grid));
    }

    @Test
    public void testHouseRobber() {
        HouseRobber o1 = dpObj.new HouseRobber();
        assertEquals(12, o1.rob(new int[] {2,7,9,3,1}));
    }

    @Test
    public void testClimbStairs() {
        ClimbStairs o1 = dpObj.new ClimbStairs();
        assertEquals(8, o1.dpTopDown(5));
        assertEquals(8, o1.dpBottomUp(5));
    }

    @Test
    public void testFibonacciSeries() {
        FibonacciSeries o1 = dpObj.new FibonacciSeries();
        o1.iterativeApproach(10);
        System.out.println();
        o1.recursiveAltApproach(10);
        System.out.println();
        assertEquals(55, o1.recursiveApproach(10));
        assertEquals(55, o1.dp(10));
        System.out.println(o1.dpAlt(5));
    }
}
