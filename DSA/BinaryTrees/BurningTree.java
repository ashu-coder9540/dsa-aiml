import java.util.*;

public class BurningTree {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
        }
    }
    static Node targetNode;
    static int targ;
    static HashMap<Node, Node> parent;
    static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void dfs(Node root){
        if(root == null) return;
        // Find target Node
        if(root.data == targ) targetNode = root;
        // Assign Parent pointer
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);
        // PreOrder DFS traversal of a binary tree
        dfs(root.left);
        dfs(root.right);
    }
    
    public static int minTime(Node root, int target) {
       targ = target;
       targetNode = null;
       parent = new HashMap<>();
       dfs(root);
       Queue<Pair> q = new LinkedList<>();
       q.add(new Pair(targetNode, 0));
       HashSet<Node> burnedNode = new HashSet<>();
       burnedNode.add(targetNode);
       int minTime = 0;
       while(q.size() > 0){
           Pair front = q.remove();
           Node node = front.node;
           int level = front.level;
           minTime = Math.max(minTime, level);
           if(node.left != null && !burnedNode.contains(node.left)){
              q.add(new Pair(node.left, level + 1));
              burnedNode.add(node.left);
           }
           if(node.right != null && !burnedNode.contains(node.right)){
              q.add(new Pair(node.right, level + 1));
              burnedNode.add(node.right);
           }
           if((node != root) && (!burnedNode.contains(parent.get(node)))){
              q.add(new Pair(parent.get(node), level + 1));
              burnedNode.add(parent.get(node));
           }
       }
       return minTime;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int target = 2;
        int result = minTime(root, target);
        System.out.println(result); // Output: 2
    }
}
