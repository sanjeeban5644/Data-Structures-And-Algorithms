import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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
    TreeNode root;




    TreeNode insert_m(){
        System.out.println("Enter the Node value: ");
        int data = in.nextInt();
        if(data==-1) return null;
        TreeNode newnode = new TreeNode(data);
        System.out.println("Enter the left child of "+newnode.data);
        newnode.left = insert_m();
        System.out.println("Enter the right child of "+newnode.data);
        newnode.right = insert_m();

        return newnode;
    }

}

public class AllTreeTraversals {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        TreeNode root;
        System.out.println("1->Auto. 0->Manual.  Enter the choice: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        if(choice == 0){
            root = tree.insert_m();
        }else{
            tree.root = new TreeNode(1);
            root = tree.root;
            tree.root.left = new TreeNode(2);
            tree.root.right = new TreeNode(3);
            tree.root.left.left = new TreeNode(4);
            tree.root.left.right = new TreeNode(5);
            tree.root.right.right = new TreeNode(7);
            tree.root.right.left = new TreeNode(6);
        }


        System.out.print("Recursive Preorder Traversal is: ");
        r_preorder(root);
        System.out.println();
        System.out.print("Iterative Preorder Traversal is: ");
        i_preorder(root);
        System.out.println();
        System.out.print("Recursive Inorder Traversal is: ");
        r_inorder(root);
        System.out.println();
        System.out.print("Iterative Inorder Traversal is: ");
        i_inorder(root);
        System.out.println();
        System.out.print("Recursive Postorder Traversal is: ");
        r_postorder(root);
        System.out.println();
        System.out.print("Iterative Postorder Traversal is: ");
        i_postorder(root);
        System.out.println();
        System.out.print("Level Order Traversal is: ");
        levelOrder(root);
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
    static void r_inorder(TreeNode root){
        if(root==null) return;
        r_inorder(root.left);
        System.out.print(" "+root.data);
        r_inorder(root.right);
    }
    static void i_inorder(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        while(true){
            while(root!=null){
                st.push(root);
                root=root.left;
            }
            if(st.isEmpty()) break;
            TreeNode temp = st.pop();
            System.out.print(" "+temp.data);
            root=temp.right;

        }
    }

    static void r_postorder(TreeNode root){
        if(root==null) return;
        r_postorder(root.left);
        r_postorder(root.right);
        System.out.print(" "+root.data);
    }

    static void i_postorder(TreeNode root){
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || curr!=null){
            if(curr!=null){
                st.push(curr);
                curr=curr.left;
            }else{
                TreeNode temp = st.peek().right;
                if(temp!=null){
                    curr=temp;
                }else{
                    temp=st.pop();
                    System.out.print(" "+temp.data);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp=st.pop();
                        System.out.print(" "+temp.data);
                    }
                }
            }

        }
    }

    static void levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 1;i<=len;i++){
                TreeNode temp = q.poll();
                System.out.print(" "+temp.data);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
    }



}
