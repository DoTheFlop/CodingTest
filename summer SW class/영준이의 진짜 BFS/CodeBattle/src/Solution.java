import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    static class Node{
    }

    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {

        }
    }

    public static int findLCA(List<Node> nodes, int a, int b){
        if (a == b) return a;

        int depA = nodes.get(a).dep, depB = nodes.get(b).dep;

        if (depA > depB){ //A가 항상 상위노드(depB가 항상 큼)
            int c = a;
            a = b;
            b = c;
            c = depA;
            depA = depB;
            depB = c;
        }

        while (depA < depB){
            b = nodes.get(b).parent;
            depB--;
        }

        return findLCA2(nodes, a, b);
    }

    public static int findLCA2(List<Node> nodes, int a, int b){
        if (a == b) return a;

        long key = (long)a * 100000 + (long)b;
        if (cache.containsKey(key)){
            return cache.get(key);
        }

        a = nodes.get(a).parent;
        b = nodes.get(b).parent;

        int result = findLCA2(nodes, a, b);

        cache.put(key, result);

        return result;
    }

    public static class Node{
        int parent, dep;
        List<Integer> children = new ArrayList<Integer>();

        public Node(){
            parent = 0;
            dep = 0;
        }

        public Node(List<Node> nodes, int parent){
            this.parent = parent;
            this.dep = nodes.get(parent).dep + 1;
        }
    }
}