import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
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
        System.out.print ("Inorder Traversal is: ");
        inorder(root);
        System.out.println();
        System.out.print("Zig-Zag Traversal is: ");
        zigzagTraversal(root);


    }

    static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(" "+root.data);
        inorder(root.right);
    }

    static void zigzagTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return ;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int var = 0;
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> templist = new ArrayList<>();
            for(int i = 1;i<=len;i++){
                TreeNode temp = q.poll();
                templist.add(temp.data);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            if(var%2==0){
                for(int i = 0;i<templist.size();i++){
                    list.add(templist.get(i));
                }
            }else{
                for(int i = templist.size()-1;i>=0;i--){
                    list.add(templist.get(i));
                }
            }
            var++;
        }
        System.out.println(list);

    }


}
