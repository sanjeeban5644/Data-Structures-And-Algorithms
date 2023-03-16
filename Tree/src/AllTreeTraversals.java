import java.util.Scanner;
import java.util.Stack;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data = data;
    }
}
class BinaryTree{
    Scanner in = new Scanner(System.in);
    TreeNode insert(){
        System.out.println("Enter the Node value: ");
        int data = in.nextInt();
        if(data==-1) return null;
        TreeNode newnode = new TreeNode(data);
        System.out.println("Enter the left child of "+newnode.data);
        newnode.left = insert();
        System.out.println("Enter the right child of "+newnode.data);
        newnode.right = insert();

        return newnode;
    }
}

public class AllTreeTraversals {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.insert();
        System.out.print("Recursive Preorder Traversal is: ");
        r_preorder(root);
        System.out.println();
        System.out.print("Iterative Preorder Traversal is: ");
        i_preorder(root);
        System.out.println();
    }
    static void r_preorder(TreeNode root){
        if(root==null) return ;
        System.out.print(" "+root.data);
        r_preorder(root.left);
        r_preorder(root.right);
    }
    static void i_preorder(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> st = new Stack<>();
        while(true){
            while(root!=null){
                System.out.print(" "+root.data);
                st.push(root);
                root=root.left;
            }
            if(st.isEmpty()) break;
            root = st.pop();
            root=root.right;
        }
    }
}
