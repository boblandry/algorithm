package com.lichking.solution;

import com.lichking.entity.ListNode;

/**
 * 链表插入排序 Sort a linked list using insertion sort.
 * @author LichKing
 *
 */
public class LinkedListInsertSort {

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cursors = head;
		ListNode tempCur = null;
		ListNode temp = head;// 待排序元素的上一元素
		ListNode current = temp.next;// 待排序的元素
		while (current != null) {
			if (current.val < head.val) {
				// 排序的元素比头小 把当前元素当做头
				temp.next = current.next;
				current.next = head;
				head = current;
			} else {
				// cursors-↓ ↓-temp
				// 1 -> 3 -> 5 -> 8 -> 4-> 12 -> 2
				// tempCur-↑ current-↑
				// 插入后：
				// |-------有序---------|
				// 1 -> 3 -> 4 -> 5 -> 8-> 12 -> 2
				// 找到插入的位置 current插入到cursors的前面：temp->current->cursors
				tempCur = cursors;
				cursors = tempCur.next;
				while (cursors != current && cursors.val < current.val) {
					tempCur = cursors;
					cursors = cursors.next;
				}
				if (cursors == current) {
					temp = current;
					current = temp.next;
				} else {
					temp.next = current.next;
					tempCur.next = current;
					current.next = cursors;
				}

			}
			cursors = head;
			current = temp.next;
		}
		return head;
	}
	
}
