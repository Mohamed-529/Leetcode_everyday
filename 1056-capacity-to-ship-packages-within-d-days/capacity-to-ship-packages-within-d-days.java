class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int left=0,right=0;
        for (int num:weights){
            left=Math.max(num,left);
            right+=num;
        }
        int sum=right,ans=0;

        while (left <= right){
            int mid=left+(right-left)/2;
            
            int isFit=0,count=1;
            for(int num:weights){
                isFit+=num;
                if(isFit>mid){
                    isFit=num;
                    count++;
                }
            }

            if (count<=days){
                ans=mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return ans;
    }
}