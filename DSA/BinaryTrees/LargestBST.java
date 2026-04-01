public class LargestBST {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
    static class Info{
        int size; // size of subtree
        int min; // min value in subtree
        int max; // max value in subtree

        Info(int min, int max, int size){
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    private static Info largestBSTUtil(Node root){
        // Base case
        if(root == null){
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        } 

        Info leftInfo = largestBSTUtil(root.left);
        Info rightInfo = largestBSTUtil(root.right);

        // Condition for current node to be BST
        if(leftInfo.max < root.val && root.val < rightInfo.min){
            int currMin = Math.min(root.val, leftInfo.min);
            int currMax = Math.max(root.val, rightInfo.max);
            int currSize = leftInfo.size + rightInfo.size + 1;
            return new Info(currMin, currMax, currSize);
        } else{
            // If not BST, return size of largest BST in left or right subtree
            int currSize = Math.max(leftInfo.size, rightInfo.size);
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, currSize);
        }

    }
    private static int largestBST(Node root){
        Info info = largestBSTUtil(root);
        return info.size; // max size of largest BST subtree
    }
    public static void main(String[] args) {
            Node root = new Node(10);
            root.left = new Node(5);
            root.right = new Node(15);
            root.left.left = new Node(1);
            root.left.right = new Node(8);
            root.right.right = new Node(50);
    
            System.out.println(largestBST(root)); // Output: 3
    }
}
