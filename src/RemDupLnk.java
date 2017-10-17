/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 *	For example,
 *	Given 1->1->2, return 1->2.
 *	Given 1->1->2->3->3->3, return 1->2->3.
 * @author entrpn
 *
 */
public class RemDupLnk {

	private static ListNode deleteDuplicates(ListNode a) {
		ListNode retval = a;
		while (a != null) {
			if (a.next != null && a.val == a.next.val) {
				a.next = a.next.next;
				continue;
			}
			a = a.next;
		}
		return retval;
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(1);
		a.next.next = new ListNode(2);
		a.next.next.next = new ListNode(3);
		a.next.next.next.next = new ListNode(3);
		a.next.next.next.next.next = new ListNode(3);
		a = deleteDuplicates(a);
		while (a != null) {
			System.out.print(a.val);
			a = a.next;
			if (a != null) {
				System.out.print("->");
			}
		}
	}

	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}
