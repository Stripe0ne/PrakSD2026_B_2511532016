package pekan9_2511532016;

public class Node_2511532016 {
	int data_2016;
	Node_2511532016 left_2016;
	Node_2511532016 right_2016;
	
	public Node_2511532016(int data_2016) {
		this.data_2016 = data_2016;
		left_2016= null;
		right_2016 = null;
	}
	
	public void setLeft_2016(Node_2511532016 node_2016) {
		if(left_2016==null) {
			left_2016=node_2016;
		}
	}
	public void setRight_2016(Node_2511532016 node_2016) {
		if(right_2016==null) {
			right_2016=node_2016;
		}
	}
	public Node_2511532016 getLeft_2016() {
		return left_2016;
	}
	public Node_2511532016 getRight_2016() {
		return right_2016;
	}
	public int getData_2016() {
		return data_2016;
	}
	public void setData_2016(int data_2016) {
		this.data_2016=data_2016;
	}
	
	void printPreorder_2016(Node_2511532016 node_2016) {
		if(node_2016 == null) return;
		System.out.print(node_2016.data_2016 + " ");
		printPreorder_2016(node_2016.left_2016);
		printPreorder_2016(node_2016.right_2016);
	}

	void printPostOrder_2016(Node_2511532016 node_2016) {
		if(node_2016==null) return;
		printPostOrder_2016(node_2016.left_2016);
		printPostOrder_2016(node_2016.right_2016);
		System.out.print(node_2016.data_2016 + " ");
	}
	void printInOrder_2016(Node_2511532016 node_2016) {
		if(node_2016==null) return;
		printInOrder_2016(node_2016.left_2016);
		System.out.print(node_2016.data_2016 + " ");
		printInOrder_2016(node_2016.right_2016);
	}
	
	public String print_2016() {
		return this.print_2016("",true,"");
	}
	
	public String print_2016(String prefix_2016, boolean isTail_2016, String sb_2016) {
		if(right_2016 != null) {
			right_2016.print_2016(prefix_2016 + (isTail_2016 ? " |   " : "    "),false,sb_2016 );
		}
		System.out.println(prefix_2016 + (isTail_2016 ? "\\-- " : "/--" ) + data_2016);
		if(left_2016!=null) {
			left_2016.print_2016(prefix_2016 + (isTail_2016 ? "   " : " |   "), true, sb_2016);
		}
		return sb_2016;
	}
	

}
