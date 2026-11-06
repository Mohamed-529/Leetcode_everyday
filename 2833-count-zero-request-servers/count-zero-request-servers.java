import java.util.Arrays;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];
        
        // 1. Sort logs chronologically by their request time: logs[i][1]
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        
        // 2. Create a 2D array for queries to store [query_time, original_index]
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        // Sort queries chronologically by query_time
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        // 3. Setup tracking array for server request frequencies
        int[] serverCounts = new int[n + 1];
        int activeServers = 0;
        
        // Two pointers for the sliding window over logs
        int i = 0; // Left pointer (shrinks window)
        int j = 0; // Right pointer (expands window)
        
        // 4. Process each query offline
        for (int k = 0; k < m; k++) {
            int queryTime = sortedQueries[k][0];
            int originalIndex = sortedQueries[k][1];
            
            // Expand window: Include all logs that occur up to queryTime
            while (j < logs.length && logs[j][1] <= queryTime) {
                int serverId = logs[j][0];
                if (serverCounts[serverId] == 0) {
                    activeServers++;
                }
                serverCounts[serverId]++;
                j++;
            }
            
            // Shrink window: Exclude logs that occurred strictly before (queryTime - x)
            while (i < logs.length && logs[i][1] < queryTime - x) {
                int serverId = logs[i][0];
                serverCounts[serverId]--;
                if (serverCounts[serverId] == 0) {
                    activeServers--;
                }
                i++;
            }
            
            // Total servers minus active servers gives the number of zero-request servers
            ans[originalIndex] = n - activeServers;
        }
        
        return ans;
    }
}
