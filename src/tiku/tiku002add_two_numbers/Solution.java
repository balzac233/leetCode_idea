package tiku.tiku002add_two_numbers;


public class Solution {

	public static void main(String[] args) {
//		输入：l1 = [2,4,3], l2 = [5,6,4]
//				输出：[7,0,8]
//				解释：342 + 465 = 807.
//		ListNode ln = creteListNode(new int[] {1,5,6,1,25,32});
//		outList(ln);
		
//		[9,9,9,9,9,9,9]
//				[9,9,9,9]
		
//		ListNode l1 = creteListNode(new int[] {2,4,3});
//		ListNode l2 = creteListNode(new int[] {5,6,4});
//		期望值 708
		ListNode l1 = creteListNode(new int[] {9,9,9,9,9,9,9});
		ListNode l2 = creteListNode(new int[] {9,9,9,9});
//		期望值 	[8,9,9,9,0,0,0,1]
		
		ListNode l3 = addTwoNumbers(l1, l2);
		
		outList(l3);
		
	}
	
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int init = 0;
    	int flag = 0;
    	if(l1!=null) {
    		init = init + l1.val;
    		l1=l1.next;
    	}
    	if(l2!=null) {
    		init = init + l2.val;
    		l2=l2.next;
    	}
    	if(init>=10) {
    		init = init-10;
    		flag=1;
    	}
    	ListNode res = new ListNode(init);
    	ListNode tmp = res;
    	while (l1!=null || l2!=null) {
    		
    		int v = 0;
    		if (l1!=null) {
				v = v+ l1.val;
				l1=l1.next;
			}
    		if (l2!=null) {
				v = v+l2.val;
				l2=l2.next;
			}
    		v = v + flag;
    		flag=0;
    		if(v>=10) {
    			v = v - 10;
    			flag++;
    		}
    		ListNode tmp2 = new ListNode(v);
    		tmp.next = tmp2;
    		tmp = tmp2;
    
//    		tmp.next = new ListNode(v);
//    		tmp = tmp.next;
//    		flag=0;
		}
    	if (flag==1) {
			tmp.next = new ListNode(flag);
		}
    	
    	return res;
    }
	
	public static ListNode creteListNode(int[] a) {
		
		if (a.length == 0) {
			return null;
		}
		if (a.length==1) {
			return new ListNode(a[0]);
		}
		ListNode res = new ListNode(a[0]);
		ListNode tmp =res;
		for(int i=1;i<a.length;i++) {
			ListNode tmp2 = new ListNode(a[i]);
			tmp.next = tmp2;
			tmp = tmp2;
		}
		
		return res;
	}
	
	public static void outList(ListNode a) {
		
		int i=0;
		
		while (a!=null) {
			System.out.println(i+" : "+a.val+" , ");
			i++;
			a=a.next;
		}		
		
	}
	
}


