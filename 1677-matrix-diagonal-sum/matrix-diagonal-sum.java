class Solution {
    public int diagonalSum(int[][] mat) {
        int ans=0;
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[i].length;j++){
                if (i==j){
                    ans+=mat[i][j]+mat[mat.length-1-i][j];
                }
            }
        }
        if (mat.length%2!=0){
            int center= mat.length/2;
            ans=ans-mat[center][center];
        }
        return ans;
    }
}