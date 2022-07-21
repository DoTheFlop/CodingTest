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
    }

    static List<Node> directory = new LinkedList<>();
    static Node root;

    void init(int n) {
        directory.clear();
        directory.add(new Node(0, "/", null));
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
            Node newNode = new Node(0, fullName.toString(), root);
            root.childList.add(newNode);
            directory.add(newNode);
            root.count++;
        }
        else{
            Node node = foundNode(fullPath.toString());
            node.childList.add(new Node(0, fullName.toString(), node));
        }
    }

    void cmd_rm(char[] path) {
        root = directory.get(0);
        StringBuilder fullPath = new StringBuilder();
        for (int i = 0; i < path.length-1; i ++) {
            fullPath.append(path[i]);
        }

        if(fullPath.toString().equals("/")){
            root.childList.clear();
            root.count = 0;
        }

        else{
            Node removeNode = foundNode(fullPath.toString());
            Node parent = removeNode.parent;
            removeNode.parent = null;

            parent.childList.remove(parent.childList.indexOf(removeNode));
        }
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

        toNode.childList.add(fromNode);
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

        Node parent = fromNode.parent;
        fromNode.parent = toNode;

        parent.childList.remove(parent.childList.indexOf(fromNode));

        toNode.childList.add(fromNode);
    }

    int cmd_find(char[] path) {

        return 0;
    }

    Node foundNode(String path){ //root의 하위 디렉토리 탐색
        root = directory.get(0);
        StringTokenizer st = new StringTokenizer(path, "/");
        int i1 = st.countTokens();
        for(int i = 0; i < i1; i++){
            String findDir = st.nextToken();
            if(root.dir.equals(findDir)) return root;
            for(int j = 0; j < root.childList.size(); j++){
                String dir = root.childList.get(j).dir;
                if(root.childList.get(j).dir.equals(findDir)){
                    root = root.childList.get(j);
                    break;
                }
            }
        }
        Node node = root;
        return node;
    }


//
//    static void downNode(int index) {
//        count++;
//        if (tree[index].left != null) {
//            downNode(tree[index].left);
//        }
//        if (tree[index].right != null) {
//            downNode(tree[index].right);
//        }
//    }
}
