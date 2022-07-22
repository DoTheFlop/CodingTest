import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class UserSolution {

    private final static int NAME_MAXLEN	= 6;
    private final static int PATH_MAXLEN	= 1999;

//	 The below commented methods are for your reference. If you want
//	 to use it, uncomment these methods.
//
//	int mstrcmp(char[] a, char[] b) {
//		int i;
//		for (i = 0; a[i] != '\0'; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return a[i] - b[i];
//	}
//
//	int mstrncmp(char[] a, char[] b, int len) {
//		for (int i = 0; i < len; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return 0;
//	}
//
//	int mstrlen(char[] a) {
//		int len = 0;
//
//		while (a[len] != '\0')
//			len++;
//
//		return len;
//	}
//
//	void mstrcpy(char[] dest, char[] src) {
//		int i = 0;
//		while (src[i] != '\0') {
//			dest[i] = src[i];
//			i++;
//		}
//		dest[i] = src[i];
//	}
//
//	void mstrncpy(char[] dest, char[] src, int len) {
//		for (int i = 0; i < len; i++) {
//			dest[i] = src[i];
//		}
//		dest[len] = '\0';
//	}
    class Node{
        Integer count;
        String dir;
        Node parent;
        List<Node> childList = new LinkedList<>();
        public Node(Integer count, String dir, Node parent) {
            this.count = count;
            this.dir = dir;
            this.parent = parent;
        }

    @Override
    public String toString() {
        return "Node{" +
                "count=" + count +
                ", dir='" + dir + '\'' +
                ", parent=" + parent +
                ", childList=" + childList +
                '}';
    }
}
    static List<Node> directory = new LinkedList<>();
    static Node root;

    void init(int n) {
        directory.clear();
        directory.add(new Node(1, "/", null));
    }

    void cmd_mkdir(char[] path, char[] name) {
        root = directory.get(0);

        StringBuilder fullPath = new StringBuilder();
        StringBuilder fullName = new StringBuilder();

        for (int i = 0; i < path.length-1; i ++) {
            fullPath.append(path[i]);
        }
        for (int i = 0; i < name.length-1; i ++) {
            fullName.append(name[i]);
        }

        if(fullPath.toString().equals("/")){
            Node newNode = new Node(1, fullName.toString(), root);
            root.childList.add(newNode);
            root.count++;
        }
        else{
            Node node = foundNode(fullPath.toString());
            node.childList.add(new Node(1, fullName.toString(), node));
            countModify(node, 1);
        }
    }

    void cmd_rm(char[] path) {
        root = directory.get(0);
        StringBuilder fullPath = new StringBuilder();
        for (int i = 0; i < path.length-1; i ++) {
            fullPath.append(path[i]);
        }

        Node removeNode = foundNode(fullPath.toString());
        Node parent = removeNode.parent;

        removeNode.parent = null;
        parent.childList.remove(parent.childList.indexOf(removeNode));
        countModify(parent, -removeNode.count);
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        StringBuilder fromPath = new StringBuilder();
        StringBuilder toPath = new StringBuilder();

        for (int i = 0; i < srcPath.length-1; i ++) {
            fromPath.append(srcPath[i]);
        }
        for (int i = 0; i < dstPath.length-1; i ++) {
            toPath.append(dstPath[i]);
        }

        Node fromNode = foundNode(fromPath.toString());
        Node toNode = foundNode(toPath.toString());

        Node copyNode = new Node(fromNode.count, fromNode.dir, fromNode.parent);
        copyNode.childList = fromNode.childList;

        toNode.childList.add(copyNode);
        copyNode.parent = toNode;

        countModify(toNode, copyNode.count);
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        root = directory.get(0);
        StringBuilder fromPath = new StringBuilder();
        StringBuilder toPath = new StringBuilder();

        for (int i = 0; i < srcPath.length-1; i ++) {
            fromPath.append(srcPath[i]);
        }
        for (int i = 0; i < dstPath.length-1; i ++) {
            toPath.append(dstPath[i]);
        }

        Node fromNode = foundNode(fromPath.toString());
        Node toNode = foundNode(toPath.toString());
        Node moveNode = new Node(fromNode.count, fromNode.dir, fromNode.parent);
        moveNode.childList = fromNode.childList;

        Node parent = fromNode.parent;

        parent.childList.remove(parent.childList.indexOf(fromNode));
        countModify(parent, -fromNode.count);

        moveNode.parent = toNode;
        toNode.childList.add(moveNode);
        countModify(toNode, moveNode.count);
    }

    int cmd_find(char[] path) {
        StringBuilder fromPath = new StringBuilder();
        for (int i = 0; i < path.length-1; i ++) {
            fromPath.append(path[i]);
        }
        Node foundNode = foundNode(fromPath.toString());
        return foundNode.count-1;
    }

    Node foundNode(String path){ //root의 하위 디렉토리 탐색
        root = directory.get(0);
        StringTokenizer st = new StringTokenizer(path, "/");
        int i1 = st.countTokens();

        for(int i = 0; i < i1; i++){
            String findDir = st.nextToken();
            for(int j = 0; j < root.childList.size(); j++){
                if(root.childList.get(j).dir.equals(findDir)){
                    root = root.childList.get(j);
                    break;
                }
            }
        }
        return root;
    }

    void countModify(Node cur, int size){
        while(true)
        {
            cur.count += size;
            if(cur.dir.equals("/")) break;
            cur = cur.parent;
        }
    }
}
