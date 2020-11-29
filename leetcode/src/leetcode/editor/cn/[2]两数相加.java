//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5178 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a=0;
        ListNode s=new ListNode((l1.val+l2.val)%10);
        ListNode p=s;
        a=(l1.val+l2.val)/10;
        l1=l1.next;
        l2=l2.next;
        while((l1!=null)&&(l2!=null)){
            p.next=new ListNode((l1.val+l2.val+a)%10);
            a=(l1.val+l2.val+a)/10;
            p=p.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            p.next=new ListNode((l1.val+a)%10);
            a=(l1.val+a)/10;
            p=p.next;
            l1=l1.next;
        }
        while (l2!=null){
            p.next=new ListNode((l2.val+a)%10);
            a=(l2.val+a)/10;
            p=p.next;
            l2=l2.next;
        }
        if(a!=0){
            p.next=new ListNode(a);
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
