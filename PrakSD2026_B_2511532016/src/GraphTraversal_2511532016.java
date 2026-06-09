package pekan9_2511532016;
import java.util.*;

public class GraphTraversal_2511532016 {
	private Map<String, List<String>> graph_2016 = new HashMap<>();
	
	public void AddEdge(String node1_2016, String node2_2016) {
		graph_2016.putIfAbsent(node1_2016, new ArrayList<>());
		graph_2016.putIfAbsent(node2_2016, new ArrayList<>());
		graph_2016.get(node1_2016).add(node2_2016);
		graph_2016.get(node2_2016).add(node1_2016);
	}
	
	public void PrintGraph() {
		System.out.println("Graw Awal (Adjacency List) :");
		for(String node_2016 : graph_2016.keySet()) {
			System.out.print(node_2016 + " -> ");
			List<String> neighbors_2016 = graph_2016.get(node_2016);
			System.out.println(String.join(", ", neighbors_2016)); 
		}
		System.out.println();
		
	}
	
	public void DFS_2016(String start_2016) {
		Set<String> visited_2016 = new HashSet<>();
		System.out.println("Penelusuran DFS: ");
		DFSHelper_2016(start_2016, visited_2016);
		System.out.println();
	}
	
	private void DFSHelper_2016(String current_2016, Set<String> visited_2016) {
		if(visited_2016.contains(current_2016)) return;
		visited_2016.add(current_2016);
		System.out.print(current_2016 + " ");
		for(String neighbor_2016 : graph_2016.getOrDefault(current_2016, new ArrayList<>())) {
			DFSHelper_2016(neighbor_2016, visited_2016);
		}
	}
	
	public void BFS_2016(String start_2016) {
		Set<String> visited_2016 = new HashSet<>();
		Queue<String> queue_2016 = new LinkedList<>();
		queue_2016.add(start_2016);
		visited_2016.add(start_2016);
		
		System.out.println("Penelusuran BFS :");
		while(!queue_2016.isEmpty()) {
			String current_2016 = queue_2016.poll();
			System.out.print(current_2016 + " ");
			for(String neighbor_2016 : graph_2016.getOrDefault(current_2016, new ArrayList<>())) {
				if(!visited_2016.contains(neighbor_2016)) {
					queue_2016.add(neighbor_2016);
					visited_2016.add(neighbor_2016);
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		GraphTraversal_2511532016 graph_2016 = new GraphTraversal_2511532016();
		
		graph_2016.AddEdge("A", "B");
		graph_2016.AddEdge("A", "C");
		graph_2016.AddEdge("B", "D");
		graph_2016.AddEdge("B", "E");
		
		System.out.println("Graf awal adalah: ");
		graph_2016.PrintGraph();
		
		graph_2016.DFS_2016("A");
		graph_2016.BFS_2016("A");
	}
}
