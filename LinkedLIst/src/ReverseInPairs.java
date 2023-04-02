public class ReverseInPairs {

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
        System.out.println("After Reversing in Pairs: ");
        Node newHead = reversePairs(head);
        print(newHead);

    }


    static Node reversePairs(Node head){
        Node t1=null;
        Node t2=null;
        Node curr=head;
        while(curr!=null && curr.next!=null){
            if(t1!=null){
                t1.next.next = curr.next;
            }
            t1=curr.next;
            curr.next = curr.next.next;
            t1.next = curr;
            if(t2==null) t2=t1;
            curr=curr.next;
        }
        return t2;
    }



    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            if(temp.next==null){
                System.out.print(" "+temp.data);
            }else{
                System.out.print(" "+temp.data+" ->");
            }

            temp=temp.next;
        }
    }


}
