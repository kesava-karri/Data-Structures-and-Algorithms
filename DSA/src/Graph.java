package src;

public class Graph {
    public class NumberOfIslands {
        // Assume start vertex to be (0, 0) and start going to each child using DFS
        // and make sure that same child is not visited twice
        // Keep track of visited child using another 2d array
        int m, n;
        public int numIslands(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int[][] visited = new int[m][n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // When current vertex is land only then dfs for it's adjacent land
                    // Also this land should not be from the land that is already included
                    if (grid[i][j] == '1' && visited[i][j] != 1) {
                        dfs(i, j, visited, grid);
                        // increment number of islands when search for land is done,
                        // all vertical & horizontal surroundings are now water
                        ans++;
                    }
                }
            }
            return ans;
        }
        private void dfs(int row, int col, int[][] visited, char[][] grid) {
            // Mark each vertex to 1 when it is visited
            visited[row][col] = 1;
            if (grid[row][col] == '0') return;
            // start of horizontal search
            // right
            if (col + 1 < n && visited[row][col + 1] != 1) dfs(row, col + 1, visited, grid);
            // left
            if (col - 1 >= 0 && visited[row][col - 1] != 1) dfs(row, col - 1, visited, grid);
            // end of horizontal search
            // start of vertical search
            // down
            if (row + 1 < m && visited[row + 1][col] != 1) dfs(row + 1, col, visited, grid);
            // up
            if (row - 1 >= 0 && visited[row - 1][col] != 1) dfs(row - 1, col, visited, grid);
            // end of vertical search
        }
    }
}
