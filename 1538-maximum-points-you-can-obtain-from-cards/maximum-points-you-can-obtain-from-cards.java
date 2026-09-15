class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // Initialize sum and get array length
        int currentSum = 0;
        int n = cardPoints.length;
      
        // Start by taking k cards from the right end
        // Calculate sum of the last k cards
        for (int i = n - k; i < n; i++) {
            currentSum += cardPoints[i];
        }
      
        // Initialize maximum score with the sum of k rightmost cards
        int maxSum = currentSum;
      
        // Sliding window: Replace cards from right with cards from left one by one
        // For each iteration, remove one card from the right end of our selection
        // and add one card from the left end
        for (int i = 0; i < k; i++) {
            // Add card from left (at index i)
            // Remove corresponding card from right (at index n - k + i)
            currentSum = currentSum + cardPoints[i] - cardPoints[n - k + i];
          
            // Update maximum score if current sum is greater
            maxSum = Math.max(maxSum, currentSum);
        }
      
        return maxSum;
    }
}
