import java.util.*;

public class TrieImplementation {
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for(int i = 0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }


    static Node root = new Node();


    public static void insert(String word){
        Node temp = root;

        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(temp.children[index]==null){
                temp.children[index]=new Node();
            }
            temp=temp.children[index];
        }
        temp.eow=true;
    }


    public static boolean search(String word){
        Node temp = root;

        for(char ch: word.toCharArray()){
            int index = ch-'a';
            if(temp.children[index]==null){
                return false;
            }
            temp=temp.children[index];
        }
        return temp.eow;
    }

    public static void main(String[] args) {
        insert("hello");
        System.out.println("Is 'hello' present?: "+search("hello"));
        System.out.println("Is 'hell' present?: "+search("hell"));
    }
}



