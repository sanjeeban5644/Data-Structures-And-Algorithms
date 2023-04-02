public class MiddleList {

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
        insert(70);

        System.out.println("The Linked List is: ");
        print(head);
        System.out.println();
        Node mid = findMid(head);
        System.out.println("The Mid of the List is: "+mid.data);
    }

    static Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }


        return slow;

    }

    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            if(temp.next==null){
                System.out.print(temp.data);
            }else{
                System.out.print(temp.data+"->");
            }
            temp=temp.next;
        }
    }


}
