class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode cur = head;
        List<ListNode> pointers = new ArrayList<>();
        while (cur != null) {
            length++;
            pointers.add(cur);
            cur = cur.next;
        }
        int index = length - n;
        if (index > 0) {
            pointers.get(index - 1).next = pointers.get(index).next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        //
        
    }
 }