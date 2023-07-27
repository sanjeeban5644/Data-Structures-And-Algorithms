import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
    }
}

public class BinarySearchTree {
    static Node root;

    public Node insert(Node root,int data){
        Node newnode = new Node(data);
        if(root==null) return newnode;
        Node temp = root;
        int flag=1;
        while(flag==1){
            if(data<temp.data){
                if(temp.left!=null){
                    temp=temp.left;
                }else{
                    temp.left=newnode;
                    flag=0;
                }
            }
            if(data>temp.data){
                if(temp.right!=null){
                    temp=temp.right;
                }else{
                    temp.right=newnode;
                    flag=0;
                }
            }
        }
        return root;
    }

    boolean search(Node root,int data){
        if(root==null) return false;
        if(root.data==data) return true;
        if(data>root.data){
            return search(root.right,data);
        }else{
            return search(root.left,data);
        }
    }

    void display(Node root){
        if(root==null) return;
        display(root.left);
        System.out.print(" "+root.data);
        display(root.right);
    }

    Node delete(Node root,int val){

        if(root==null){
            return root;
        }

        if(val>root.data){
            root.right = delete(root.right,val);
        }else if(val<root.data){
            root.left = delete(root.left,val);
        }else{
            //case 1;
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2;
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            //case 3;
            root.data = InorderSuccessor(root.right);
            root.right=delete(root.right,root.data);
        }
        return root;
    }

        int InorderSuccessor(Node root){
        int min = root.data;
            while(root.left!=null){
                min=root.left.data;
                root=root.left;
            }
            return min;
        }

    void printRoot_Leaf(Node root, List<Integer> list){
        if(root==null) return;
        list.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(list);
        }else{
            printRoot_Leaf(root.left,list);
            printRoot_Leaf(root.right,list);
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        root = tree.insert(root,5);
        boolean isPresent = tree.search(root,60);
        tree.display(root);
        root=tree.delete(root,3);
        tree.display(root);
        tree.printRoot_Leaf(root,new ArrayList<>());
    }
}
