public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        
        // Optimize k to handle rotations larger than the grid capacity
        k = k % total;
        
        // Initialize the nested result list
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0); // Pre-populate with dummy values
            }
            result.add(row);
        }
        
        // Map elements from the original grid to their new positions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Formula to convert 2D index -> 1D index -> shifted 1D index
                int newIndex = (i * n + j + k) % total;
                
                // Convert 1D index back to 2D row and column
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                
                // Set the value in our dynamic List structure
                result.get(newRow).set(newCol, grid[i][j]);
            }
        }
        
        return result;
    }
}