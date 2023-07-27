class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}

public class LinkedList {
   Node head;
   Node tail;
   private int size;

   LinkedList(){
       size=0;
   }

   void insertLast(int data){
       Node newnode = new Node(data);
       size++;
       if(head==null){
           head=newnode;
           tail=newnode;
       }else{
           tail.next=newnode;
           tail=newnode;
       }
   }

   void display(){
       Node temp = head;
       while(temp!=null){
           System.out.print(" "+temp.data);
           temp=temp.next;
       }
   }


   int getsize(){
       return size;
   }

   void delete(int position){
       if(position==0){
           head=head.next;
       }
       if(position>size){
           return;
       }
       Node temp = head;
       for(int i = 0;i<position-1;i++){
           temp=temp.next;
       }
       if(temp.next.next==null) {
           temp.next = null;
       }else{
           temp.next=temp.next.next;
       }
   }

   int findmid(){
       Node slow = head;
       Node fast = head;
       while(fast!=null && fast.next!=null && fast.next.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       return slow.data;
   }

   static Node reverse(Node head){
       if(head==null) return head;
       Node prev=null;
       Node curr=head;
       Node fut = head;
       while(curr!=null){
           fut=curr.next;
           curr.next=prev;
           prev=curr;
           curr=fut;
       }
        return prev;
   }



    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertLast(10);
        ll.display();
        System.out.println("Size of ll is: "+ll.getsize());
        ll.delete(2);
        int mid = ll.findmid();
        System.out.println(mid);
        Node newhead = reverse(ll.head);
//        LinkedList ll2 = new LinkedList();
//        ll2.insertLast(15);
//        ll2.insertLast(25);
//        ll2.insertLast(35);
//        ll2.insertLast(45);
//        Node head = mergeTwoList(ll.head,ll2.head);
//        display(head);
//        Node head = sortList(ll.head);
//        display(head);
    }

    static Node mergeTwoList(Node list1,Node list2){
        if(list1==null && list2==null) return null;
        if(list1==null && list2!=null) return list2;
        if(list1!=null && list2==null) return list1;

        Node temp_head=null;
        Node temp_tail=null;

        while(list1!=null && list2!=null){
            int value = 0;
            if(list1.data<list2.data){
                value = list1.data;
                list1=list1.next;
            }else{
                value = list2.data;
                list2=list2.next;
            }

            Node newnode = new Node(value);
            if(temp_head==null){
                temp_head=newnode;
                temp_tail=newnode;
            }else{
                temp_tail.next=newnode;
                temp_tail=newnode;
            }
        }

        if(list1==null){
            while(list2!=null){
                Node newnode = new Node(list2.data);
                temp_tail.next=newnode;
                temp_tail=newnode;
                list2=list2.next;
            }
        }else{
            while(list1!=null){
                Node newnode = new Node(list1.data);
                temp_tail.next=newnode;
                temp_tail=newnode;
                list1=list1.next;
            }
        }

        return temp_head;
    }

    static void display(Node newhead){
        Node temp = newhead;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp=temp.next;
        }
    }

    static Node sortMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid = slow.next;
        slow.next=null;
        return mid;
    }

    static Node sortList(Node head){
       if(head==null || head.next==null) return head;
        Node mid = sortMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return mergeTwoList(left,right);
    }
}
