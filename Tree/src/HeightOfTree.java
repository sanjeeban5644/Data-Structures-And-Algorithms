import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class HeightOfTree {
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

        System.out.println("Height of Tree is: "+findheight_i(root)+" (iterative)");
        System.out.println("Height of Tree is: "+(findheight_r(root)-1)+" (recursive)");



    }

    static int findheight_r(TreeNode root){
        if(root==null) return 0;
        int left = findheight_r(root.left);
        int right = findheight_r(root.right);
        return Math.max(left+1,right+1);
    }



    static int findheight_i(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return 0;
        q.add(root);
        int height = 0;
        while(!q.isEmpty()){
            height++;
            int len = q.size();
            for(int i = 1;i<=len;i++){
                TreeNode node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
        }
        return height-1;
    }





}
