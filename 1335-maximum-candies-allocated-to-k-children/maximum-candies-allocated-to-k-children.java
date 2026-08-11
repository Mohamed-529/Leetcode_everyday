class Solution {
    public int maximumCandies(int[] candies, long k) {

        

        int left=1,right=0,ans=0;
        long total=0;

        for (int nums:candies){
            right=Math.max(nums,right);
            total+=nums;
        }

        if (total<k){
            return 0;
        } 

        while (left<=right){
            int mid=left+(right-left)/2;

            long totalCandies=0;
            for (int num:candies){
                totalCandies+=num/mid;
            }

            if (totalCandies>=k){
                ans=mid;
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        return ans;
    }
}