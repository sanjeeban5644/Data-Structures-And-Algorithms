public class SumOfAllElements {
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


        int sum = dfs(root);
        System.out.println("The sum of all elements in the tree is: "+sum);

    }

    static int dfs(TreeNode root){
        if(root==null) return 0;
        return root.data+dfs(root.left)+dfs(root.right);
    }

}
