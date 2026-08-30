class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0;

        for(int pile:piles){
            right=Math.max(right,pile);
        }

        int ans=right;

        while(left<=right){
            int mid=left+(right-left)/2;
            long time=0;

            for (int pile:piles){
                time += (pile / mid) + (pile % mid == 0 ? 0 : 1);
            }

            if (time<=h){
                ans=Math.min(ans,mid);
                right=mid-1;
            } else {
                left=mid+1;
            }

        }
        return ans;
    }
}