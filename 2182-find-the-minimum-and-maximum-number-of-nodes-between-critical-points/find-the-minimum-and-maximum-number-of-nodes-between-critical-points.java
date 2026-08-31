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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int res[]={-1,-1};
        List<Integer> temp=new ArrayList<>();
        ListNode prev=head;
        ListNode curr=head.next;
        ListNode coming=head.next.next;
        if(curr==null || coming==null)
        {
            return res;
        }
        int i=1;
        while(coming!=null)
        {
            if((curr.val>prev.val && curr.val>coming.val) || (curr.val<prev.val && curr.val<coming.val))
            {
                temp.add(i);
            }
            i++;
            prev=curr;
            curr=coming;
            coming=coming.next;
        }
        if(temp.size()<2)
        {
            return res;
        }
        int min=Integer.MAX_VALUE;
        for(int j=1;j<temp.size();j++)
        {
            int diff=temp.get(j)-temp.get(j-1);
            if(diff<min)
            {
                min=diff;
            }
        }
        return new int[]{min,temp.get(temp.size()-1)-temp.get(0)};
    }
}