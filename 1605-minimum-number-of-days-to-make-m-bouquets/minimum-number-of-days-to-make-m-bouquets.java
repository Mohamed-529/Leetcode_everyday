class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
     int left=1,right=0;

     for (int bloom:bloomDay){
        right=Math.max(bloom,right);
     }
     int ans=-1;

     while (left<=right){
        int mid=left+(right-left)/2;

        int bouq=0,adj=0;
        for (int bloom:bloomDay){
            if (bloom<=mid){
                adj++;
                if(adj==k){
                    bouq++;
                    adj=0;
                }
            } else {
                adj=0;
            }
        }

        if (bouq>=m){
            ans=mid;
            right=mid-1;
        } else {
            left=mid+1;
        }
     }

     return ans;   
    }
}