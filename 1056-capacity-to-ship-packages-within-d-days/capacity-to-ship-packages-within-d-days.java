class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=0;

        for (int each:weights){
            right+=each;
            left=Math.max(each,left);
        }
        

        while (left<=right){
            int mid=left+(right-left)/2;

            int wei=0,day=1;
            for (int each:weights){
                if(wei+each > mid){
                    day++;
                    wei=each;
                }else {
                    wei+=each;
                }
            }

            if (day<=days){
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}