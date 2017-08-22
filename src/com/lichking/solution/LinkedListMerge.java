package com.lichking.solution;

import com.lichking.entity.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * @author LichKing
 *
 */
public class LinkedListMerge {

	public ListNode Merge(ListNode list1, ListNode list2) {
		
		if(list1 != null && list2 == null)
			return list1;
		else if(list1 == null && list2 != null)
			return list2;
		else if(list1 == null && list2 == null)
			return null;
		ListNode head,cursor;
		if(list1.val < list2.val){
			cursor = head = list1;
			list1 = list1.next;
		}else{
			cursor = head = list2;
			list2 = list2.next;
		}
			
		while(list1 != null || list2 != null){
			if(list1 != null && list2 == null){
				cursor.next = list1;
				break;
			}else if(list2 != null  && list1 == null){
				cursor.next = list2;
				break;
			}else{
				if(list1.val < list2.val){
					cursor.next = list1;
					list1 = list1.next;
				}else{
					cursor.next = list2;
					list2 = list2.next;
				}
				cursor = cursor.next;
			}
		}
		return head;
	}

}
 