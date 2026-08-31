class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> map=new HashSet<>();

        for (List<Integer> range:nums){
            for(int i=range.get(0);i<=range.get(1);i++){
                map.add(i);
            }
        }

        return map.size();
    }
}