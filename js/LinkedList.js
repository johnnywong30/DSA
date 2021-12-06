class LLNode {
    constructor(data = null) {
        this.val = data;
        this.next = null;
    }
}


class LinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    prepend(value) {
        const currHead = this.head;
        const newNode = new LLNode(value);
        newNode.next = currHead;
        this.head = newNode;
        if (! this.tail) { // no head or tail in this case, empty list
            this.tail = newNode;
        }
    }

    append(value) {
        const newNode = new LLNode(value);
        if (! this.head) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            const currTail = this.tail;
            currTail.next = newNode;
            this.tail = newNode;
        }
    }
}