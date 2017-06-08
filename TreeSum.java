//       4
//      / \
//     2   2
//        / \
//       4   1

// 42 + 424 + 421
//trees can have 0 or 2 children.

public class TreeSum {
	private static class Node {
		Node left;
		Node right;
		int val;
		Node (int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(2);
		root.right.left = new Node(4);
		root.right.right = new Node(1);

		System.out.println(treeSum(root, 0));
	}
	public static int treeSum(Node root, int curPath) {
		curPath = curPath * 10 + root.val;
		if (root.left == null) {
			return curPath;
		}
		return treeSum(root.left, curPath) + treeSum(root.right, curPath);
	}
}
