class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr=new int[128];
        int left=0,ans=0;

        for (int right=0;right<s.length();right++){
            char each=s.charAt(right);
            arr[each]++;

            while(arr[each]>1){
                char ind=s.charAt(left);
                arr[ind]--;
                left++;
            }

            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}