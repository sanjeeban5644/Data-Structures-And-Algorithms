public class findDiameter {


    static int diam=0;
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root;
        tree.root = new TreeNode(1);
        root = tree.root;
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(903);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(99);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.left.right = new TreeNode(27);
        int ans = calheight(root);
        System.out.println("Height of tree is: "+ans);
        System.out.println("The Diameter of the tree is: "+diam);

    }

    static int calheight(TreeNode root){
        if(root==null) return 0;
        int lh = calheight(root.left);
        int rh = calheight(root.right);
        diam = Math.max(diam,1+lh+rh);
        return 1+Math.max(lh,rh);
    }

}
