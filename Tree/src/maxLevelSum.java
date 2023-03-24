import java.util.LinkedList;
import java.util.Queue;

public class maxLevelSum {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        TreeNode root;
        tree.root = new TreeNode(1);
        root = tree.root;
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(903);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(1000);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.left.right = new TreeNode(27);

        int maxlevel = findMaxSumLevel(root);
        System.out.println("The max sum of a level is: "+maxlevel);


    }


    static int findMaxSumLevel(TreeNode root){
        int sum=0;
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int currsum=0;
            int len = q.size();
            for(int i = 1;i<=len;i++){
                TreeNode node = q.poll();
                currsum+=node.data;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right
                );
            }
            if(currsum>sum) sum=currsum;
        }
        return sum;
    }
}
