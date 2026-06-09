package pekan9_2511532016;

public class BTreeDriver_2511532016 {
	
	public static void main(String[] args) {
		BTree_2511532016 tree_2016 = new BTree_2511532016();
		System.out.print("Jumlah simpul awal pohon: ");
		System.out.println(tree_2016.countNodes_2016());
		
		Node_2511532016 root_2016 = new Node_2511532016(1);
		
		tree_2016.setRoot_2016(root_2016);
		System.out.println("Jumlah simpul jika hanya ada root");
		System.out.println(tree_2016.countNodes_2016());
		Node_2511532016 node2_2016 = new Node_2511532016(2);
		Node_2511532016 node3_2016 = new Node_2511532016(3);
		Node_2511532016 node4_2016 = new Node_2511532016(4);
		Node_2511532016 node5_2016 = new Node_2511532016(5);
		Node_2511532016 node6_2016 = new Node_2511532016(6);
		Node_2511532016 node7_2016 = new Node_2511532016(7);
		Node_2511532016 node8_2016 = new Node_2511532016(8);
		Node_2511532016 node9_2016 = new Node_2511532016(9);
		
		root_2016.setLeft_2016(node2_2016);
		node2_2016.setLeft_2016(node4_2016);
		node2_2016.setRight_2016(node5_2016);
		node4_2016.setRight_2016(node8_2016);
		root_2016.setRight_2016(node3_2016);
		node3_2016.setLeft_2016(node6_2016);
		node3_2016.setRight_2016(node7_2016);
		node6_2016.setLeft_2016(node9_2016);
		
		tree_2016.setCurrent_2016(tree_2016.getRoot_2016());
		System.out.println("Menampilkan simpul terakhir");
		System.out.println(tree_2016.getCurrent_2016().getData_2016());
		System.out.println("Jumlah simpul setelah simpul 7 ditambahkan");
		System.out.println(tree_2016.countNodes_2016());
		
		System.out.println("\nIn Order: ");
		tree_2016.printInorder_2016();
		System.out.println("\nPre Order: ");
		tree_2016.printPreOrder_2016();		
		System.out.println("\nPost Order: ");
		tree_2016.printInorder_2016();
		
		System.out.println("\nMenampilkan simpul dalam bentuk pohon");
		tree_2016.print_2016();

	}

}
