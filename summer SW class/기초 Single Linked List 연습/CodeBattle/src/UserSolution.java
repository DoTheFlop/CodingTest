class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
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
    }

    public void addNode2Num(int data, int num) {
        if (head == null) {
            Node addNode = getNode(data);
            head = addNode;
            return;
        }

        Node prev = null;
        Node cur = head;
        for (int count = 0; count < num-1; count++) {
            prev = cur;
            cur = cur.next;
        }
        Node temp = getNode(data);
        if(prev == null){
            temp.next = head;
            head = temp;
        }else if(cur == null){
            cur = temp;
            prev.next = cur;
        }else{
            prev.next = temp;
            temp.next = cur;
        }
    }

    public void removeNode(int data) {
        if (head == null) {
            return;
        }

        Node cur = head;
        Node prev = null;

        while (cur.next != null) {
            if(cur.data == data) break;
            prev = cur;
            cur = cur.next;
        }

        if (prev == null) {
            head = head.next;
        } else if (cur.next == null) {
            prev.next = null;
        } else {
            prev.next = cur.next;
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
}