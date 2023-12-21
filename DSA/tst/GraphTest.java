package tst;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import src.Graph;
import src.Graph.NumberOfIslands;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GraphTest {
    @Mock
    private Graph obj;

    @Test
    public void testNumberOfIslands() {
        // Arrange
        char[][] grid = new char[][] {
          {'1','1','0','0','0'},
          {'1','1','0','0','0'},
          {'0','0','1','0','0'},
          {'0','0','0','1','1'}
        };
        int ans = 3;

        // Act
        NumberOfIslands o1 = obj.new NumberOfIslands();
        int result = o1.numIslands(grid);

        // Assert
        assertEquals(ans, result);
    }
}
