import java.util.Queue;
import java.util.LinkedList;


public class MinDepth {
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
        tree.root.right.left.right.left = new TreeNode(10);

        int ans = minDepth(root);
        System.out.println("The Minimum Depth of Tree is: "+ans);
        ans = maxDepth(root);
        System.out.println("The Maximum Depth of Tree is: "+ans);

    }


    static int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = 1+maxDepth(root.left);
        int right = 1+maxDepth(root.right);
        return Math.max(left,right);
    }

    static int minDepth(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 1;i<=len;i++){
                TreeNode temp = q.poll();
                if(temp.left==null && temp.right==null){
                    return depth;
                }
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            depth++;
        }
        return depth;
    }

}
