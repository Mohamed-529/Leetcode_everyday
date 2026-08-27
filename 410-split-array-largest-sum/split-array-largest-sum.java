class Solution {
    public int splitArray(int[] nums, int k) {
        int left=0,right=0;

        for (int num:nums){
            right+=num;
            left=Math.max(left,num);
        }

        int ans=right;

        while (left<=right){
            int mid=left+(right-left)/2;

            int kk=1,every=0;
            for (int num:nums){

                if(every+num>mid){
                    kk++;
                    every=num;
                } else {
                    every+=num;
                }
            }

            if (kk<=k){
                    ans=Math.min(ans,mid);
                    right=mid-1;
            }else {
                    left=mid+1;
            }

        }

        return ans;
    }
}