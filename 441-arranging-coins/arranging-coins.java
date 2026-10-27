class Solution {
    public int arrangeCoins(int n) {
        int res=0;
        if (n==1){
            return n;
        }
        for (int i=1;i<=n;i++){
            
            if (i<=n){
                n=n-i;
                res++;
            }
        }

        return res;
    }
}