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
    public ListNode sortList(ListNode head) {
        if(head == null) return null; 
        
        ArrayList<ListNode> nodes = new ArrayList<ListNode>(); 
        ListNode cur = head; 
        while(cur != null) {
            nodes.add(cur); 
            cur = cur.next; 
        }
        
        //sort 
        Collections.sort(nodes, new Comparator<ListNode>(){
           @Override 
           public int compare(ListNode a, ListNode b) {
               return a.val - b.val; 
           }
        });
        
        //restructure 
        for(int i = 0; i < nodes.size()-1; i++) {
            nodes.get(i).next = nodes.get(i+1); 
        }
        nodes.get(nodes.size()-1).next = null; 
        
        return nodes.get(0); 
    }
}
