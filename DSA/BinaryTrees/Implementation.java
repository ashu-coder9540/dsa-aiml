import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
    }
}
class Pair{
    Node node;
    int level;
    Pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
}
public class Implementation {
    // display tree element
    //          3
    //        /   \
    //      4      2
    //    / \     / \
    //   -1   5   1   6 
   private static void preOrder(Node root){

    // Base case
        if(root == null) return;    
    // self work
        System.out.print(root.val + " ");
    // recursive work
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inOrder(Node root){
        // Base case
        if(root == null) return;
        // recursive work
        inOrder(root.left);
        // self work
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void postOrder(Node root){
        // Base case
        if(root == null) return;
        // recursive work
        postOrder(root.left);
        postOrder(root.right);
        // self work
        System.out.print(root.val + " ");
    }

    // Size of a binary tree 
    private static int size(Node root){
        if(root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    // Sum of values of a binary tree
    private static int sumOfBT(Node root){
        if(root == null) return 0;
        return root.val + sumOfBT(root.left) + sumOfBT(root.right);
    }

    // Product of values of a Binary Tree 
    private static int prodOfBT(Node root){
        if(root == null) return 1;
        return root.val * prodOfBT(root.left) * prodOfBT(root.right);
    }

    // Product of non-zeroes values of a binary Tree
    private static long nonZeroProd(Node root){
        if(root == null) return 1;

        long val = (root.val == 0) ? 1 : root.val;

        return val * nonZeroProd(root.left) * nonZeroProd(root.right);
    }

    // Maximum value in a binary tree
    private static int maxValue(Node root){
        // base case
        if(root == null) return Integer.MIN_VALUE;
        // self work
        int maxi = root.val;
        // recursive work
        return Math.max(maxi, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    // Levels of a binary tree
    private static int levels(Node root){ //Kaam ki cheez hai
        // base case
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    // level order traversal (BFS)
    private static void levelOrder(Node root){
        if(root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            System.out.print(curr.val + " ");
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
    }
    System.out.println();
}

    private static void levelOrderLineWise(Node root){
        if(root == null) return;
        Queue<Pair> q = new LinkedList<>();
        int currLevel = 0;
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
           Pair front = q.remove();
           Node node = front.node;
           int level = front.level;
           if(front.level != currLevel){
                currLevel++;
                System.out.println();
           }
            System.out.print(front.node.val + " ");
            if(node.left != null) q.add(new Pair(node.left, level+1));
            if(node.right != null) q.add(new Pair(node.right, level+1));
    }
    System.out.println();
    }

    // Print nth level
    private static void kthLevel(Node root, int lvl, int k){
        if(root == null) return;
        if(lvl == k) System.out.print(root.val + " ");
        kthLevel(root.left,lvl+1,k);
        kthLevel(root.right,lvl+1,k);
    }
   
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
       ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
       ArrayList<Integer> arr = new ArrayList<>();
       dfs(root, arr, ans);  
       return ans; 
    }

    private static void dfs(Node root, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans){
        if(root==null) return;
        if(root.left == null && root.right == null){
            arr.add(root.val);
            // create deep copy 
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(arr);
            ans.add(list);
        }
        arr.add(root.val);
        dfs(root.left, arr, ans);
        dfs(root.right, arr, ans);
        arr.remove(arr.size()-1);  //backtracking
    }

     private boolean exists(Node root, int val) {
        if(root == null) return false;
        if(root.val == val) return true;
        return exists(root.left, val) || exists(root.right, val);
    }

    // Method 1: using exists helper method 
    /*  Node lca(Node root, int p, int q) { //TC = O(n)
        if(root == null) return null;
        if(root.val==p || root.val==q) return root;
        boolean pLiesInLeft =  exists(root.left, p);
        boolean qLiesInRight = exists(root.right, q);
        if(!pLiesInLeft && qLiesInRight)//both right
            return lca(root.right,p,q); 
        else if(pLiesInLeft && !qLiesInRight)//both left
            return lca(root.left,p,q);
        else // one lies in right and another in left and vice versa
            return root;
    } */

    // Method 2: without using any exists helper method
    Node lca(Node root, int p, int q) { //TC = O(n)
        if(root == null) return null;
        if(root.val==p || root.val==q) return root;
        Node l = lca(root.left, p, q);
        Node r = lca(root.right, p, q);
        if(l!=null && r!=null){
            return root;
        }
        return (l==null) ? r : l;
    }
 
   
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(5);
        Node f = new Node(1);
        Node g = new Node(6);

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;

        // we can also print level line by line using kthLevel method
       /*  for(int i=0; i<levels(a); i++){
        kthLevel(a,0,i);
        System.out.println();
        } */
        /* preOrder(a);

        System.out.println();

        int size = size(a);
        System.out.print("Size of given tree is: " + size);
        System.out.println();

        int sum = sumOfBT(a);
        System.out.print("Sum Of Binary Tree is: "+ sum);
        System.out.println();

        long prod = nonZeroProd(a);
        System.out.print("Product of Binary Tree is: "+ prod);
        System.out.println();

        int max = maxValue(a);
        System.out.println("max value in a binary tree: " + max);

        int levels = levels(a);
        System.out.println("levels of given binary tree: " + levels); */

        // DFS Traversals
        // preOrder(a);
        // System.out.println();

        // inOrder(a);
        // System.out.println();

        // postOrder(a);
        // System.out.println();

        // BFS Traversal can be done using Queue (LinkedList in Java)
        // levelOrder(a);

        // levelOrderLineWise(a);

       
    } 
}
