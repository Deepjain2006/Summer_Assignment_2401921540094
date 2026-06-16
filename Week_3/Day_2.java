public class Day_2 {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode d=new ListNode();
        ListNode tail=d;

        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tail.next=list1;
                list1=list1.next;
                tail=tail.next;
            }
            else{
                tail.next=list2;
                list2=list2.next;
                tail=tail.next;
            }
        }

        tail.next=(list1!=null) ? list1 : list2;
        return d.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s=head;
        int l=0;
        while(s!=null){
            l++;
            s=s.next;
        }
        if(l==n){
            return head.next;
        }
        int ind=l-n;
        ListNode prev=head;
        for(int i=1;i<ind;i++){        
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }

        ListNode mid=midnod(head);
        ListNode rev=revnod(mid);

        ListNode sh=head;
        
        while(rev!=null){
            if(rev.val!=sh.val){
                return false;
            }

            sh=sh.next;
            rev=rev.next;
        }

        return true;

    }

    public ListNode midnod(ListNode head){
        ListNode s=head;
        ListNode f=head;
        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }

        return s;
    }

    public ListNode revnod(ListNode head){
        if(head == null){
            return head;
        }
        ListNode prev=null;
        ListNode present= head;
        ListNode next=present.next;

        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
        }
        return prev;
    }
}
