/*
 * @lc app=leetcode id=684 lang=java
 *
 * [684] Redundant Connection
 */

// @lc code=start
class Solution {

    private int[] parents; 

    // find parent of node x
    private int find(int x) {
        return parents[x] == x ? x : find(parents[x]);
    }
    
    // union nodes x and y
    private boolean union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX == parentY) {
            return false;
        }
        parents[parentY] = parentX;
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        // 0 is not a node in the graph
        parents = new int[n + 1];
        // each node is their parent to start
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            if (! union(from, to)) {
                return edge;
            }
        }
        return new int[0];
    }
}
// @lc code=end

