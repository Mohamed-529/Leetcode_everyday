class Solution {
    public int minOperations(int[] nums, int x) {

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int rem = total - x;

        if (rem < 0) {
            return -1;
        }

        int match = 0;
        int left = 0;
        int maxLen = -1;

        for (int right = 0; right < nums.length; right++) {

            match += nums[right];

            while (match > rem) {
                match -= nums[left];
                left++;
            }

            if (match == rem) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        if (maxLen == -1) {
            return -1;
        }

        return nums.length - maxLen;
    }
}