class bstNode{
    int data;
    bstNode left;
    bstNode right;

    bstNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }


    static bstNode insert(bstNode root, int data){
        if(root==null){
            return new bstNode(data);
        }else if(data<root.data){
            root.left = insert(root.left,data);
        }else{
            root.right = insert(root.right,data);
        }
        return root;
    }

}

public class BSTdefinition {

    static bstNode root = null;
    public static void main(String[] args) {
        root = bstNode.insert(root,10);
        root = bstNode.insert(root,20);
        root = bstNode.insert(root,30);
        root = bstNode.insert(root,40);
        root = bstNode.insert(root,50);
        root = bstNode.insert(root,60);

        print(root);

    }


    static void print(bstNode root){
        if(root==null) return;
        print(root.left);
        System.out.print(" "+root.data);
        print(root.right);
    }


}
