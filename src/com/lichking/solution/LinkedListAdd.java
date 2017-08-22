package com.lichking.solution;

import com.lichking.entity.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author LichKing
 *
 */
public class LinkedListAdd {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null, head = node;
        int carry = 0;
        while(true){
        	int v = 0;
        	if(l1 == null && l2 == null)
        		v = carry;
        	else if(l1 == null)
        		v = l2.val + carry;
        	else if(l2 == null)
        		v = l1.val + carry;
        	else
        		v = l1.val + l2.val + carry;
        	int v1 = v;
            if(v1 >= 10)
                v1 -= 10;

            if(node == null){
                node = new ListNode(v1);
                head = node;
            }else{
            	node.val = v1;
            }
           
            carry = v>=10 ? 1 : 0;
            
            if((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || carry == 1){
            	node.next = new ListNode(0);
            	node = node.next;
            	if(l1 != null)
            		l1 = l1.next;
            	if(l2 != null)
            		l2 = l2.next;
            }else{
            	break;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		//ListNode ll1 = new ListNode(0);
		//ListNode lll1 = new ListNode(4);
		//l1.next = ll1;
		//ll1.next = lll1;
		ListNode l2 = new ListNode(5);
		//ListNode ll2 = new ListNode(4);
		//ListNode lll2 = new ListNode(3);
		//l2.next = ll2;
		//ll2.next = lll2;
		new LinkedListAdd().addTwoNumbers(l1, l2);
	}
	
}
