class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search on the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            // Partition nums1
            int partition1 = (left + right) / 2;

            // Partition nums2
            int partition2 = (m + n + 1) / 2 - partition1;

            // Boundary values
            int left1 = (partition1 == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partition1 - 1];

            int right1 = (partition1 == m)
                    ? Integer.MAX_VALUE
                    : nums1[partition1];

            int left2 = (partition2 == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partition2 - 1];

            int right2 = (partition2 == n)
                    ? Integer.MAX_VALUE
                    : nums2[partition2];

            // Correct partition
            if (left1 <= right2 && left2 <= right1) {

                // Even total length
                if ((m + n) % 2 == 0) {
                    int maxLeft = Math.max(left1, left2);
                    int minRight = Math.min(right1, right2);

                    return (maxLeft + minRight) / 2.0;
                }

                // Odd total length
                else {
                    return Math.max(left1, left2);
                }
            }

            // Too many elements taken from nums1
            else if (left1 > right2) {
                right = partition1 - 1;
            }

            // Too few elements taken from nums1
            else {
                left = partition1 + 1;
            }
        }

        return 0.0;
    }
}