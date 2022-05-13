package main.java.medium;

/*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:
    Input: grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]
    Output: 1

    Example 2:
    Input: grid = [
      ["1","1","0","0","0"],
      ["1","1","0","0","0"],
      ["0","0","1","0","0"],
      ["0","0","0","1","1"]
    ]
    Output: 3

    Constraints:
    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
*/

public class _200_NumbeOfIslands {
    public int numIslands(char[][] grid) {
        int[][] alreadyVisited = new int[grid.length][grid[0].length];
        int islandCount = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && alreadyVisited[i][j] == 0) {
                    islandCount++;
                    discoverIsland(grid, alreadyVisited, i, j);
                } else if(grid[i][j] == '0') {
                    alreadyVisited[i][j] = 1;
                }
            }
        }
        return islandCount;
    }

    private void discoverIsland(char[][] grid, int[][] alreadyVisited, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if(grid[i][j] == '1' && alreadyVisited[i][j] == 0) {
            alreadyVisited[i][j] = 1;
            //discover top
            discoverIsland(grid, alreadyVisited, i - 1, j);
            //discover right
            discoverIsland(grid, alreadyVisited, i, j + 1);
            //discover bottom
            discoverIsland(grid, alreadyVisited, i + 1, j);
            //discover left
            discoverIsland(grid, alreadyVisited, i, j - 1);
        }
    }
}

/*
    Runtime: 8 ms, faster than 25.57% of Java online submissions for Number of Islands.
    Memory Usage: 57.7 MB, less than 29.96% of Java online submissions for Number of Islands.
*/
