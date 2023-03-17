import java.util.LinkedList;
import java.util.Queue;

public class FindMaxElement {
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
        System.out.println("Max element is: "+findMax(root));
    }

    private static int findMax(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 1;i<=len;i++){
                TreeNode temp = q.poll();
                if(temp.data>max) max= temp.data;
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
        return max;
    }


}
