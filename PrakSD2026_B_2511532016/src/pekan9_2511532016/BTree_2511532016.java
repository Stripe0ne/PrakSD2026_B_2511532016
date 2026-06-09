package pekan9_2511532016;

public class BTree_2511532016 {
	private Node_2511532016 root_2016;
	private Node_2511532016 currentNode_2016;
	
	public boolean search (int data_2016) {
		return search(root_2016, data_2016);}

		private boolean search (Node_2511532016 node_2016, int data_2016) {
		if (node_2016.getData_2016() == data_2016) return true;
		if(node_2016.getLeft_2016() !=null) {
			if(search(node_2016.getLeft_2016(),data_2016)) return true;
			}
		if(node_2016.getRight_2016() !=null) {
			if(search(node_2016.getRight_2016(),data_2016)) return true;
			}
		return false;
		}
		
		
		public void printInorder_2016() {
		root_2016.printInOrder_2016(root_2016);}

		public void printPreOrder_2016() {
		root_2016.printPreorder_2016(root_2016) ;}

		public void printPostOrder_2016() {
		root_2016.printPostOrder_2016(root_2016) ;}

		public Node_2511532016 getRoot_2016() {
		return root_2016;	}
		
		public boolean isEmpty_2016() {
			return root_2016 == null;
		}
		public int countNodes_2016() {
			return countNodes_2016(root_2016);
		}
		
		private int countNodes_2016(Node_2511532016 node_2016) {
			int count_2016 =1;
			if(node_2016 == null) {
				return 0;
			}
			else {
				count_2016 += countNodes_2016(node_2016.getLeft_2016());
				count_2016 += countNodes_2016(node_2016.getRight_2016());
				return count_2016;
			}
		}
		public void print_2016() {
			root_2016.print_2016();
		}
		public Node_2511532016 getCurrent_2016() {
			return currentNode_2016;
		}
		public void setCurrent_2016(Node_2511532016 node_2016) {
			this.currentNode_2016= node_2016;
		}
		public void setRoot_2016(Node_2511532016 root_2016) {
			this.root_2016 = root_2016;
		}
		
}


