class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map= new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxx=0;
        for (int num:nums){
            if (map.containsKey(num+1)){
                int tot=map.get(num)+map.get(num+1);
                maxx=Math.max(tot,maxx);
            }
        }

        return maxx;
    }
}