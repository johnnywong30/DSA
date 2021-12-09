/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    private Node head, tail;
    private int cap, size;
    private Map<Integer, Node> cache;

    private class Node {
        int key, value;
        Node next, prev;

        private Node() {
            this(0, 0);
        }

        private Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    // LRU will be at the end of the DLList
    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        // head and tail mark the borders of the LRUCache
        // node right after head is the MRU node
        // node right before tail is the LRU node
        head.next = tail;
        tail.prev = head;
    }
    
    // O(1)
    // place right after head after fetch
    public int get(int key) {
        Node n = cache.get(key);
        // if n key does not exist
        if (n == null) {
            return -1;
        }
        // make most recent
        update(n);
        return n.value;
    }
    
    // O(1)
    // place right after the head
    public void put(int key, int value) {
        Node n = cache.get(key);
        if (n == null) {
            n = new Node(key, value);
            add(n);
            cache.put(key, n);
            size++;
        }
        else {
            n.value = value;
            // make most recent
            update(n);   
        }

        if (size > cap) {
            Node leastRecent = tail.prev;
            cache.remove(leastRecent.key);
            remove(leastRecent);
            size--; 
        }
    }

    private void update(Node n) {
        remove(n);
        add(n);
    }

    private void add(Node n) {
        Node after = head.next;
        head.next = n;
        n.prev = head;
        n.next = after;
        after.prev = n;
    }

    private void remove(Node n) {
        Node before = n.prev;
        Node after = n.next;
        before.next = after;
        after.prev = before;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

