class Solution {
    public ListNode reverseList(ListNode head) {
        // 如果头节点为空或者只有一个节点，反转了也是本身
        if(head == null || head.next == null) return head;
        
        // 新建一个dummy node 来作为虚假的head前置节点
        ListNode dummy = null;
        ListNode cur = head;
        ListNode prev = dummy;
        
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }
}
