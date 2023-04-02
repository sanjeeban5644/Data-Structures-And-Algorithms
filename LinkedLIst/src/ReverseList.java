public class ReverseList {
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

        System.out.println("The Linked List is: ");
        print(head);
//        System.out.println();
//        System.out.println("The Linked List after reversing is: (I)");
//        Node newHead = reverseList_i(head);
//        print(newHead);
        System.out.println();
        System.out.println("The Linked List after reversing is: (R)");
        Node newHead = reverseList_r(head);
        print(newHead);


    }


    static Node reverseList_r(Node head){
        if(head==null || head.next==null){
            return  head;
        }
        Node newhead = reverseList_r(head.next);
        Node headnext = head.next;
        headnext.next=head;
        head.next=null;
        return newhead;
    }



    static Node reverseList_i(Node head){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
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
