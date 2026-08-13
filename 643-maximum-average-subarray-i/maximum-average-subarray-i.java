class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans=0;
        for (int i=0;i<k;i++){
            ans+=nums[i];
        }
        double res=ans;
        for (int j=k;j<nums.length;j++){
            ans=(ans-nums[j-k])+nums[j];
            res=Math.max(res,ans);
        }


        return res/k;
    }
}