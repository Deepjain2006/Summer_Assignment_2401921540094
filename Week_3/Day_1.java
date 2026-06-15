package week3;

public class Day_1 {
    
    public boolean hasCycle(ListNode head) {
        ListNode f=head;
        ListNode s=head;

        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;

            if(f==s){
                return true;
            }
        }
        return false;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        while(head!=null){
            ListNode next =head.next;
            head.next=prev;
            prev=head;
            head=next;
            
        }

        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;

        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }

        return s;
    }
}
