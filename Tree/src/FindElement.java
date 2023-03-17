public class FindElement {
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
        System.out.println("Presence of 20?: "+search(root,20));
        System.out.println("Presence of 5?: "+search(root,5));
    }

    public static boolean search(TreeNode root,int data){
        if(root==null) return false;
        boolean temp;
        if(root.data==data){
            return true;
        }else{
            temp = search(root.left,data);
            if(temp){
                return temp;
            }else{
                return search(root.right,data);
            }
        }

    }









}
