class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] covered = new boolean[51]; // Array to track numbers 1 to 50
        
        // Mark all covered positions as true
        for (int[] range : ranges) {
            int start = Math.max(range[0], 1);
            int end = Math.min(range[1], 50);
            for (int i = start; i <= end; i++) {
                covered[i] = true;
            }
        }
        
        // Check if any number from left to right is missing
        for (int i = left; i <= right; i++) {
            if (!covered[i]) {
                return false;
            }
        }
        
        return true;
    }
}
