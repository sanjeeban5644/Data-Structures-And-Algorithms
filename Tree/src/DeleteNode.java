import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeleteNode {
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
        inorder(root);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the node to be deleted: ");
        int ele = in.nextInt();
        int success = deleteNode(root,ele);

        if(success==1){
            System.out.println("Node successfully deleted");
        }else{
            System.out.println("Node not present in Tree");
        }

        inorder(root);

    }

    static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(" "+root.data);
        inorder(root.right);
    }


    static int deleteNode(TreeNode root,int element){
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return 0;
        q.add(root);
        TreeNode deepestNode = root;
        TreeNode prev = null;
        TreeNode targetNode = null;
        while(!q.isEmpty()){
            int len = q.size();
            if(deepestNode.left==null && deepestNode.right==null){

            }else{
                prev=deepestNode;
            }
            for(int i = 1;i<=len;i++){
                deepestNode = q.poll();
                if(deepestNode.data==element){
                    targetNode = deepestNode;
                }
                if(deepestNode.left!=null) q.add(deepestNode.left);
                if(deepestNode.right!=null) q.add(deepestNode.right);
            }

        }
        System.out.println(prev.data);
        if(targetNode!=null){
            targetNode.data=deepestNode.data;
            if(prev.left==deepestNode){
                prev.left=null;
            }else{
                prev.right=null;
            }
            return 1;
        }else{
            return 0;
        }


    }
}
