package com.lichking.solution;

import com.lichking.entity.ListNode;

/**
 * 链表反转
 * @author LichKing
 *
 */
public class LinkedListReverse {

	public ListNode ReverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode node = ReverseList(head.next);
			head.next.next = head;
			head.next = null;
			return node;
		}
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		LinkedListReverse llr = new LinkedListReverse();
		n1.next = n2;
		//ListNode n = llr.ReverseList(n1);
		n2.next = n3;
		ListNode n = llr.ReverseList(n1);
		n3.next = n4;
		//ListNode n = llr.ReverseList(n1);
	}
	
}
