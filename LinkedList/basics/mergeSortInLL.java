package basics;

public class mergeSortInLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head;
    private static Node getmid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            } else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;

            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public static Node mergeSort(Node head){
        if(head==null || head.next == null){
            return head;
        }
        Node mid=getmid(head);
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    } 
    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }
    public static void main(String[]args){
        head=new Node(3);
        head.next=new Node(1);
        head.next.next=new Node(2);
        head.next.next.next=new Node(3);
        printList(head);
        head=mergeSort(head);
        printList(head);
    }
    
}
