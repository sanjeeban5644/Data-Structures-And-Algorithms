import java.util.Scanner;

public class Lca {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root;
        tree.root = new TreeNode(1);
        root = tree.root;
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(7);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.left.right = new TreeNode(8);
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the 1st digit: ");
        int a = in.nextInt();
        System.out.println("Enter the 2nd digit: ");
        int b = in.nextInt();

        TreeNode isLCA = ancestor(root,a,b);
        System.out.println("The LCA is: "+isLCA.data);

    }

    static TreeNode ancestor(TreeNode root,int a,int b){
        if(root==null) return null;
        if(root.data==a || root.data==b) return root;
        TreeNode left = ancestor(root.left,a,b);
        TreeNode right = ancestor(root.right,a,b);
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }




}
