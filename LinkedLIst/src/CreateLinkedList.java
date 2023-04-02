class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

public class CreateLinkedList {
    static Node head=null;
    static Node tail=null;


    public static void insert(int data){
        Node temp = new Node(data);
        if(head==null){
            head = temp;
            tail = temp;
        }else{
            tail.next=temp;
            tail=temp;
        }

    }

    public static void main(String[] args) {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        insert(60);



    }
}
