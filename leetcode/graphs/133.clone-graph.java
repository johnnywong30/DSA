/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Integer, Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }
        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node.val, clone);
        for (Node n: node.neighbors) {
            clone.neighbors.add(cloneGraph(n));
        }
        return clone;
    }
}
// @lc code=end

