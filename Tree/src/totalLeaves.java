import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class totalLeaves {
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

        System.out.println("The Total no.of leaf nodes is: "+countLeaves(root));
    }

    static int countLeaves(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return 0;
        q.add(root);
        int count = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 1;i<=len;i++){
                TreeNode node = q.poll();
                if(node.left==null && node.right==null){
                    count++;
                }
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return count;

    }


}
