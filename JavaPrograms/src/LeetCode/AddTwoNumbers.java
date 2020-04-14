package LeetCode;

import util.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode tail = null;		
		int carry = 0;
		
		 while(l1 != null || l2 != null){
			
			int l1Value = 0;			
			if(l1 != null){
				l1Value = l1.val;
				l1 = l1.next;
			}
			
			int l2Value = 0;
			if(l2 != null){
				l2Value = l2.val;
				l2 = l2.next;
			}
			
			int sum = l1Value + l2Value + carry;
			carry = sum / 10;
			sum = sum % 10;
			
			ListNode node = new ListNode(sum);
			node.next = null;
			
			if(head == null){
				head =  tail = node;
			}else{				
				tail.next = node;
				tail = node;
			}	
			
		}
		
		if(carry != 0){
			
			ListNode node = new ListNode(carry);
			node.next = null;
			
			tail.next = node;
		}
		
		return head;
	}
}
