public class TreeMirror {
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
        inorder(root);
        System.out.println();
        makeMirror(root);
        inorder(root);


    }

    static void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        System.out.print(" "+root.data);
        inorder(root.right);
    }


    static void makeMirror(TreeNode root){
        if(root==null) return;
        if(root.left!=null && root.right!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right=temp;
        }else if(root.left!=null){
            root.right = root.left;
            root.left = null;
        }else{
            root.left = root.right;
            root.right=null;
        }

        makeMirror(root.left);
        makeMirror(root.right);
    }

}
