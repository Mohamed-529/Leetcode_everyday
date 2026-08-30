class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length<(long)m*k){
            return -1;
        }
        int left=1,right=0;

        for (int bloom:bloomDay){
            right=Math.max(bloom,right);
        }

        int ans=right;

        while(left<=right){
            int mid=left+(right-left)/2;
            int bouquet=0,flowers=0;


            for (int bloom:bloomDay){
                if(bloom<=mid){
                    flowers++;
                    if(flowers==k){
                        bouquet++;
                        flowers=0;
                    }
                } else {
                    flowers=0;
                }
            }

            if (bouquet>=m){
                ans=Math.min(ans,mid);
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return ans;
    }
}