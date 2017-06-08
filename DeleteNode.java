public class DeleteNode {

	private static class Node {
		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}

		public String toString() {
			String str = String.valueOf(val);
			Node nextNode = next;
			while (nextNode != null) {
				str += " " + nextNode.val;
				nextNode = nextNode.next;
			}
			return str;
		}
	}

	public static void main(String[] args) {
		Node lst = new Node(1);
		Node head = lst;
		for (int i = 1; i < 10; i++) {
			lst.next = new Node(i);
			lst = lst.next;
		}
		System.out.println(head.toString());
		System.out.println(delete(-10, head).toString());


	}

	public static Node delete(int i, Node head) {
      if (i < 0 || head == null) {
        throw new IndexOutOfBoundsException();
      }
		if (i == 0) {
			return head.next;
		}
		Node prev = head;
		for (int x = 0; x < i - 1; x++) {
          if (prev.next == null) {
            throw new IndexOutOfBoundsException();
          }
			prev = prev.next;
		}
		Node toDelete = prev.next;
      	if (toDelete == null) {
            throw new IndexOutOfBoundsException();
        }
		prev.next = toDelete.next;

		return head;
	}
}
