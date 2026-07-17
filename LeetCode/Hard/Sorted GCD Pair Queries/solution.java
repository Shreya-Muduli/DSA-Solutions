import java.util.Arrays;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        // Count frequencies of each number in nums
        int[] counts = new int[maxVal + 1];
        for (int num : nums) {
            counts[num]++;
        }
        
        // countGcd[g] will hold the EXACT number of pairs with GCD equal to g
        long[] countGcd = new long[maxVal + 1];
        
        // Iterate backwards from maxVal down to 1
        for (int g = maxVal; g >= 1; g--) {
            long multiplesCount = 0;
            
            // Step 1: Count how many numbers are multiples of g
            for (int multiple = g; multiple <= maxVal; multiple += g) {
                multiplesCount += counts[multiple];
            }
            
            // Step 2: Calculate total combinations of pairs from these multiples
            long totalPairs = (multiplesCount * (multiplesCount - 1)) / 2;
            
            // Step 3: Inclusion-Exclusion. Subtract pairs that have a larger GCD (2g, 3g...)
            for (int multiple = 2 * g; multiple <= maxVal; multiple += g) {
                totalPairs -= countGcd[multiple];
            }
            
            countGcd[g] = totalPairs;
        }
        
        // Step 4: Build prefix sum array of the pair counts
        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + countGcd[i];
        }
        
        // Step 5: Answer each query using a custom binary search (upper bound)
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = binarySearch(prefixSums, queries[i]);
        }
        
        return ans;
    }
    
    // Custom binary search to find the first index where prefixSums[idx] > target
    private int binarySearch(long[] prefixSums, long target) {
        int low = 1;
        int high = prefixSums.length - 1;
        int result = high;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] > target) {
                result = mid; // Candidate found, try to look for a smaller index
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}