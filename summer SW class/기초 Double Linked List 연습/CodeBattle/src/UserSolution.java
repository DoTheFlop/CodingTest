class Node {
    public int data;
    public Node prev;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class UserSolution {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head = null;
        nodeCnt = 0;
        node = new Node[MAX_NODE];
    }

    public void addNode2Head(int data) {
        if (head == null){
            Node header = getNode(data);
            head = header;
            return;
        }
        Node header = getNode(data);
        header.next = head;
        head.prev = header;
        head = header;
    }

    public void addNode2Tail(int data) {

        if (head == null) {
            Node tail = getNode(data);
            head = tail;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        Node tail = getNode(data);
        cur.next = tail;
        tail.prev = cur;
    }

    public void addNode2Num(int data, int num) {
        if (head == null) {
            Node addNode = getNode(data);
            head = addNode;
            return;
        }

        Node prevNode = null;
        Node cur = head;
        for (int count = 0; count < num-1; count++) {
            if (cur == null) {
                return;
            }
            prevNode = cur;
            cur = cur.next;
        }
        Node temp = getNode(data);
        if(prevNode == null){
            temp.next = head;
            head.prev = temp;
            head = temp;
        }else if(cur == null){
            cur = temp;
            prevNode.next = cur;
            cur.prev = prevNode;
        }else{
            prevNode.next = temp;
            temp.prev = prevNode;
            temp.next = cur;
            cur.prev = temp;
        }

    }

    public int findNode(int data) {

        Node cur = head;
        int count = 0;

        while (cur.next != null) {
            count++;
            if(cur.data == data) break;
            cur = cur.next;
        }
        return count;
    }

    public void removeNode(int data) {
        if (head == null) {
            return;
        }

        Node cur = head;
        Node prevNode = null;

        while (cur.next != null) {
            if(cur.data == data) break;
            prevNode = cur;
            cur = cur.next;
        }
        if(cur.data != data) return;

        Node nextNode = cur.next;

        if (prevNode == null) {
            head = head.next;
            head.prev = null;
        } else if (cur.next == null) {
            prevNode.next = null;
            cur.prev = null;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        nodeCnt--;

    }

    public int getList(int[] output) {
        if (head == null) {
            return -1;
        }
//
//        for (int i = 0; i < nodeCnt; i++) {
//            output[i] = node[i].data;
//        }

        Node cur = head;
        for(int i = 0; i < nodeCnt; i++){
            if(cur==null) break;
            output[i] = cur.data;
            cur = cur.next;
        }
        return nodeCnt;

    }

    public int getReversedList(int[] output) {
        if (head == null) {
            return -1;
        }
//
//        for (int i = 0; i < nodeCnt; i++) {
//            output[i] = node[i].data;
//        }


        int[] outputTemp = new int[nodeCnt];

        Node cur = head;
        for(int i = nodeCnt-1; i >= 0; i--){
            if(cur==null) break;
            outputTemp[i] = cur.data;
            cur = cur.next;
        }
        for(int i = 0; i < nodeCnt; i++){
            output[i] = outputTemp[i];
        }
        return nodeCnt;
    }
}