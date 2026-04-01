import java.util.ArrayList;

public class GetPredSucc {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
    // Find Inorder pred of root 
    private static Node rightMost(Node root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
    // Find Inorder succ of root
    private static Node leftMost(Node root){
        while(root.left != null){
            root = root.left;
        } 
        return root;
    }

    // Find Predecessor & Successor in a BST
    public static ArrayList<Node> findPredSucc(Node root, int key) {
        Node curr = root;
        Node pred = null;
        Node succ = null;
        ArrayList<Node> result = new ArrayList<>();
        while(curr != null){
            if(key < curr.val){
                succ = curr;
                curr = curr.left; // search key in left sub-tree
            }else if(key > curr.val){
                pred = curr;
                curr = curr.right; //search key in right sub-tree
            }else{ // key == root.val
                if(curr.left != null){
                    // Inorder pred
                    pred = rightMost(curr.left);
                }
                if(curr.right != null){
                    // Inorder succ
                    succ = leftMost(curr.right);
                }
                break;
            }
        }
        result.add(pred);
        result.add(succ);
        return result;
    }
    public static void main(String[] args) {
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        int key = 3;
        ArrayList<Node> result = findPredSucc(root, key);
        System.out.println("Predecessor: " + (result.get(0) != null ? result.get(0).val : "null")); //pred = 60
        System.out.println("Successor: " + (result.get(1) != null ? result.get(1).val : "null")); //succ = 70
    }
}
