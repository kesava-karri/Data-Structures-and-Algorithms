package src;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
    class CourseSchedule {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // look for all the courses from a vertex (course here) & get it done with that course
            // Cyclic graphs can also exist where it each course is linked to another making it
            // impossible to finish those courses so we should also avoid cyclic graphs
            // Map of Lists; bi -> [ai1, ai2]
            // Create adjacency list
            Map<Integer, List<Integer>> adj = new HashMap<>();
            int[] inDegrees = new int[numCourses];

            for (int i = 0; i < prerequisites.length; i++) {
                int ai = prerequisites[i][0];
                int bi = prerequisites[i][1];

                List<Integer> list = adj.getOrDefault(bi, new ArrayList<>());
                list.add(ai);
                adj.put(bi, list);

                inDegrees[ai]++;
            }

            // Queue for topological sorting
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                // we can start with the nodes which doesn't have any incoming edges
                // i.e., these are the courses which doesn't have any pre-reqs
                // If inDegrees are not 0 for at least 1 vertex it implies that a cycle exist
                if (inDegrees[i] == 0) {
                    queue.add(i);
                }
            }

            // Perform topological sorting
            while (!queue.isEmpty()) {
                int course = queue.poll();
                if (adj.containsKey(course)) {
                    for (int nextCourse : adj.get(course)) {
                        inDegrees[nextCourse]--;
                        if (inDegrees[nextCourse] == 0) {
                            queue.add(nextCourse);
                        }
                    }
                }
            }

            // Check if all courses have been visited implies no cycles
            for (int i = 0; i < numCourses; i++) {
                if (inDegrees[i] > 0) {
                    return false;
                }
            }

            return true;
        }
    }

    class NetworkDelayTime {
        public int networkDelayTime(int[][] times, int n, int k) {
            // 1 extra space to leave 0th index and start from 1 to be similar to node labeling
            List<Pair<Integer, Integer>>[] adj = new ArrayList[n + 1];

            for (int i = 0; i < n + 1; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < times.length; i++) {
                int u = times[i][0];
                int v = times[i][1];
                int w = times[i][2];
                adj[u].add(new Pair(v, w));
            }

            int[] weights = new int[n + 1];
            // starting at source node, so set weight to 0 & rest infinity
            Arrays.fill(weights, Integer.MAX_VALUE);
            weights[k] = 0;
            // Pair(v, w)
            PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
            pq.add(new Pair(k, weights[k]));

            while (!pq.isEmpty()) {
                Pair<Integer, Integer> pair = pq.poll();
                int u = pair.getKey();
                int w = pair.getValue();

                for (Pair<Integer, Integer> neighbor : adj[u]) {
                    int v = neighbor.getKey();
                    int newWeight = w + neighbor.getValue();
                    if (newWeight < weights[v]) {
                        weights[v] = newWeight;
                        pq.add(new Pair(v, newWeight));
                    }
                }
            }

            int ans = -1;
            for (int i = 1; i <= n; i++) {
                if (weights[i] == Integer.MAX_VALUE) {
                    return -1; // There is an unreachable node
                }
                ans = Math.max(ans, weights[i]);
            }

            return ans;
        }
    }

    public class CheapestFlightsWithinKStops {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // Dijkstra's Algorithm :)
            // Create Adjacency List
            List<int[]>[] adj = new ArrayList[104];
            // [ [[1, 2, 3], [2,3,4]], [[], [], []] ]

            for (int i = 0; i < 104; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < flights.length; i++) {
                int u = flights[i][0];
                int v = flights[i][1];
                int w = flights[i][2];
                adj[u].add(new int[]{v, w});
            }

            int[] dist = new int[105];
            int[] visited = new int[105];
            Arrays.fill(dist, Integer.MAX_VALUE);
            visited[1] = 0;
            dist[src] = 0;

            for (int i = 0; i <= 100; i++) {
                dist[1] = Integer.MAX_VALUE;
                visited[i] = 0;
                dist[src] = 0;
                // { stops, dis, u}
                PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq = new PriorityQueue<>(
                        Comparator.comparingInt(a -> a.getKey())
                );
                pq.add(new Pair<>(0, new Pair<>(0, src)));

                while (!pq.isEmpty()) {
                    Pair<Integer, Pair<Integer, Integer>> t = pq.poll();

                    int stops = t.getKey();
                    int dis = t.getValue().getKey();
                    int u = t.getValue().getValue();

                    visited[u] = 1;

                    for (int j = 0; j < adj[u].size(); j++) {
                        int[] pair = adj[u].get(j);
                        int v = pair[0];
                        int w = pair[1];

                        if (dist[v] > dis + w && stops <= k) {
                            dist[v] = dis + w;
                            pq.add(new Pair<>(stops + 1, new Pair<>(dis + w, v)));
                        }
                    }
                }
            }

            return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
        }
    }

    public class SurroundedRegions {
        // DFS approach
        // zeros not to flip are the ones which are on the borders
        // so go to each zero on the borders & do a dfs to find the connected graph of Os an turn them into a new symbol for example *
        // Now Xs, Os, *s will be present and these Os are the ones not connected to borders, so flip all these Os to Xs
        // Finally turn all the *s back to zeros, boom there is your answer
        int m, n;
        public void solve(char[][] board) {
            m = board.length;
            n = board[0].length;

            // Creating stars [*] :)
            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // To not flip the Os on the edges & their Os graphs
                    // Change them to *s
                    if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                        if (board[i][j] == 'O') {
                            dfs(i, j, board);
                        }
                    }
                }
            }

            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // flip Os not connected to borders
                    if (board[i][j] == 'O') board[i][j] = 'X';
                        // bring back our 0s on the borders with it's respective connected graphs
                    else if (board[i][j] == '*') board[i][j] = 'O';
                }
            }
        }

        private void dfs(int row, int col, char[][] board) {
            if (row >= m || row < 0 || col >= n || col < 0
                    || board[row][col] != 'O') {
                return;
            }
            board[row][col] = '*';

            dfs(row + 1, col, board);
            dfs(row - 1, col, board);
            dfs(row, col + 1, board);
            dfs(row, col - 1, board);
        }
    }

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
