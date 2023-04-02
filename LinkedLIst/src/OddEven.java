public class OddEven {

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
        insert(1);
        insert(2);
        insert(3);
        insert(4);
        insert(5);
        insert(6);
        insert(7);

        System.out.println("The Linked List is: ");
        print(head);
        System.out.println();
        System.out.println("The Linked List after Odd Even sorting is: ");
        Node newHead = oddeven(head);
        print(newHead);

    }

    static Node oddeven(Node head){
        Node odddummyhead = new Node(0);
        Node otemp = odddummyhead;
        Node evendummyhead = new Node(0);
        Node etemp = evendummyhead;
        Node temp = head;
        while(temp!=null){
            if(temp.data%2==0){
                Node newNode = new Node(temp.data);
                etemp.next = newNode;
                etemp = newNode;
            }else{
                Node newNode = new Node(temp.data);
                otemp.next = newNode;
                otemp=newNode;
            }
            temp=temp.next;
        }

        etemp.next = odddummyhead.next;
        odddummyhead.next = null;
        return evendummyhead.next;
    }


    static void print(Node head){
        Node temp = head;
        while(temp!=null){
            if(temp.next==null){
                System.out.print(" "+temp.data);
            }else{
                System.out.print(" "+temp.data+"->");
            }
            temp=temp.next;
        }
    }
}
