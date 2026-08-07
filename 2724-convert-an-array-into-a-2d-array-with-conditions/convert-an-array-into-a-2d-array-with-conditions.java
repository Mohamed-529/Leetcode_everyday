import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            // Track duplicates using consecutive pointer check
            if (i > 0 && nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1; // Reset for a new unique number
            }
            
            // If the 2D list doesn't have enough rows for this duplicate frequency, add a row
            if (res.size() < count) {
                res.add(new ArrayList<>());
            }
            
            // Place it in the appropriate row
            res.get(count - 1).add(nums[i]);
        }
        return res;
    }
}
