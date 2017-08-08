package com.lichking.solution;

import com.lichking.entity.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author LichKing
 *
 */
public class LinkedListLastK {

	public ListNode FindKthToTail(ListNode head,int k) {
		if(k <= 0)
			return null;
		ListNode font = head;
		for(int i=0;i<k;i++){
			if(font == null)
				return null;
			else
				font = font.next;
		}
		if(font == null)
			return null;
		ListNode result = head;
		while(font.next != null){
			font = font.next;
			result = result.next;
		}
		return result;
    }
	
}
