class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        // Starting elements patha continuous chain length default ah 1
        int consecutiveCount = 1; 
        
        for (int i = 0; i < n; i++) {
            // Index 0 ku check panna mudiyathu, so i > 0 condition
            if (i > 0) {
                if (nums[i] == nums[i - 1] + 1) {
                    consecutiveCount++; // Chain thodaruthu!
                } else {
                    consecutiveCount = 1; // Chain break aydichu, reset to 1
                }
            }
            
            // Epolaam namma k length valid window reach panramo, appolaam result store panrom
            int windowStartIndex = i - k + 1;
            if (windowStartIndex >= 0) {
                // If our chain is at least 'k' long, elements window starting la irunthu continuous ah iruku
                if (consecutiveCount >= k) {
                    result[windowStartIndex] = nums[i]; // sorted nala last element than maximum
                } else {
                    result[windowStartIndex] = -1; // invalid chain
                }
            }
        }
        
        return result;
    }
}
