class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr= new int[26];
        int ans=0,left=0;
        for (int i=0;i<s.length();i++){
            int indc=s.charAt(i)-'a';
            arr[indc]++;

            while (arr[indc]>2){
                int ind=s.charAt(left)-'a';
                arr[ind]--;
                left++;
            }

            ans=Math.max(ans,i-left+1);
        }
        return ans;
    }
}