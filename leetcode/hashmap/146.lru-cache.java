/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {

    private Map<Integer, DLLNode> cache;
    private DLLNode head, tail;
    private int cap, size;

    private class DLLNode {
        
        int key;
        int value;
        DLLNode prev = null;
        DLLNode next = null;

        private DLLNode() {
            this(0, 0);
        }
        
        private DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLLNode n = cache.get(key);
        // pair does not exist
        if (n == null) {
            return -1;
        }
        update(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        DLLNode n = cache.get(key);
        // pair does not exist
        if (n == null) {
            n = new DLLNode(key, value);
            cache.put(key, n);
            add(n);
            size++;
        }
        else {
            n.value = value;
            update(n);
        }
        if (size > cap) {
            DLLNode leastRecent = tail.prev;
            remove(leastRecent);
            cache.remove(leastRecent.key);
            size--;
        }
    }

    private void update(DLLNode node) {
        remove(node);
        add(node);
    }
    private void add(DLLNode node) {
        DLLNode after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }
    private void remove(DLLNode node) {
        DLLNode before = node.prev;
        DLLNode after = node.next;
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

