class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean hasNonZero = false;

        // Step 1: Calculate total XOR and check for non-zero elements
        for (int num : nums) {
            totalXor ^= num;
            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Step 2: Evaluate the three possible cases
        if (!hasNonZero) {
            return 0; // Case 1: Array is all 0s
        }
        
        if (totalXor != 0) {
            return n; // Case 2: Full array has a non-zero XOR sum
        } else {
            return n - 1; // Case 3: Total XOR is 0; dropping 1 element fixes it
        }
    }
}
