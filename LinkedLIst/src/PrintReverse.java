public class PrintReverse {

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
        System.out.println("The List in Reverse is: ");
        printRev(head);
    }

    static void printRev(Node head){
        if(head==null) return;
        printRev(head.next);
        System.out.print(" "+head.data);
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
