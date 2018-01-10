package Jan_10th;

public class copy_list_with_random_pointer {
	class RandomListNode{
		int label;
		RandomListNode next,random;
		public RandomListNode(int label) {
			this.label = label;
		}
	}
	public RandomListNode copyRandomList(RandomListNode head){
		if(head == null)
			return null;
		for(RandomListNode temp = head; temp!=null; temp=temp.next.next){
			RandomListNode newNode = new RandomListNode(temp.label);
			newNode.next = temp.next;
			temp.next = newNode;
		}
		for(RandomListNode temp = head; temp!=null; temp=temp.next.next){
			RandomListNode tempNode = temp.next;
			tempNode.random = temp.random==null?null:temp.random.next;
		}
		RandomListNode res = head.next;
		for(RandomListNode temp = res; temp.next!=null; temp = temp.next){
			temp.next = temp.next.next;
		}
		return res;
	}
}
