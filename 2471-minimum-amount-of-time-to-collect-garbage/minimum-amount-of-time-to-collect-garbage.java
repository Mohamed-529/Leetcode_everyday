class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalTime = 0;
        
        // 1. Always add the constant pickup time
        for (String g : garbage) {
            totalTime += g.length();
        }
        
        // Flags to track if a truck has started working (from right to left)
        boolean hasM = false;
        boolean hasP = false;
        boolean hasG = false;
        
        // 2. Iterate backward through the houses
        for (int i = garbage.length - 1; i > 0; i--) {
            // Check what garbage types are present in the current house
            if (garbage[i].contains("M")) hasM = true;
            if (garbage[i].contains("P")) hasP = true;
            if (garbage[i].contains("G")) hasG = true;
            
            // If a truck is active, it must have traveled across travel[i-1]
            if (hasM) totalTime += travel[i - 1];
            if (hasP) totalTime += travel[i - 1];
            if (hasG) totalTime += travel[i - 1];
        }
        
        return totalTime;
    }
}
