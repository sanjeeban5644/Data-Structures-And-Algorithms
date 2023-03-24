import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class rootToLeafPath {
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

        RootToLeaf(root);



    }


    static void RootToLeaf(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root,list);
    }
    static void dfs(TreeNode node,List<Integer> list){
        if(node==null) return;
        list.add(node.data);
        if(node.left==null && node.right==null){
            System.out.println(list.toString());
        }else{
            dfs(node.left,list);
            dfs(node.right,list);
        }
        list.remove(list.size()-1);

    }



}
