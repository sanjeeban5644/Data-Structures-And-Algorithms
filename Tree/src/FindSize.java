import java.util.Queue;
import java.util.LinkedList;

public class FindSize {
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

        System.out.println("The Size of the tree is: "+findSize_r(root)+" (recursive)");
        System.out.println("The Size of the tree is: "+findSize_i(root)+" (iterative)");
    }
    static int findSize_r(TreeNode root){
        if(root==null) return 0;
        return 1+findSize_r(root.left)+findSize_r(root.right);
    }
    static int findSize_i(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while(!q.isEmpty()){
            int len = q.size();
            count+=len;
            for(int i = 1;i<=len;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
        return count;
    }

}
