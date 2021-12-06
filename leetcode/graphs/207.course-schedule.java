/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        int edges = prerequisites.length; 
        // turn edge array into graph to setup for topological sort
        for (int[] edge: prerequisites) {
            int from = edge[1];
            int to = edge[0];
            indegrees[to]++;
            List<Integer> reachable = graph.getOrDefault(from, new LinkedList<Integer>());
            reachable.add(to);
            graph.put(from, reachable);
        }
        // q is the list of start nodes with indegrees of 0
        Queue<Integer> q = new LinkedList<>();
        for (int node = 0; node < numCourses; node++) {
            if (indegrees[node] == 0) q.offer(node);
        }
        
        // can finish course schedule if there are no cycles
        // cycles are present if there are edges still in the graph
        // after topological sort
        while (! q.isEmpty()) {
            int node = q.poll();
            List<Integer> reachable = graph.getOrDefault(node, new LinkedList<Integer>());
            for (int i = 0; i < reachable.size(); i++) {
                int to = reachable.get(i);
                edges--; // remove the edge
                indegrees[to]--; // also means indegree of to node decrements
                // if indegree of this node is now 0, that means we can add it
                // to list of start nodes
                if (indegrees[to] == 0) q.offer(to);
            }
        }
        return edges == 0;
    }
}
// @lc code=end

