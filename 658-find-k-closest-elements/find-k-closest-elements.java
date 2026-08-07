import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        
        // Shrink the window until its size is exactly k
        while (right - left + 1 > k) {
            // Check distances to x from both extremes
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++; // Left element is further away, drop it
            } else {
                right--; // Right element is further away (or equal, prefer smaller element), drop it
            }
        }
        
        // Build the final result from the remaining window
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
