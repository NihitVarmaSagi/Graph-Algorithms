package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBfs {
	
	int vertices;
	int [][] adjacency_matrix;
	
	GraphBfs(int vertices){
		this.vertices = vertices;
		adjacency_matrix = new int[vertices][vertices];
		for(int i=0;i<vertices;i++){
			for(int j=0;j<vertices;j++){
				adjacency_matrix[i][j]=0;
			}
		}
	}
	
	void addEdge(int x, int y){
		adjacency_matrix[x][y] = 1;
		adjacency_matrix[y][x] = 1;
	}
	
	static void BFS(GraphBfs graph, int x){
		boolean visited[] = new boolean[graph.vertices];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		while(queue.isEmpty()!=true){
			int u = queue.remove();
			System.out.print(u +" ");
			for(int i=0;i<graph.vertices;i++){
				if(graph.adjacency_matrix[u][i]==1){
					if(visited[i]==false && queue.contains(i)==false){
						queue.add(i);
					}
				}
			}
			visited[u] = true;
		}
	}
	
	public static void main(String[] args) {
		GraphBfs graph = new GraphBfs(12);
		graph.addEdge(0,3); graph.addEdge(0,1); graph.addEdge(0,4); graph.addEdge(1,2);
		graph.addEdge(1,5); graph.addEdge(2,5);graph.addEdge(3,11);graph.addEdge(4,5); 
		graph.addEdge(4,6); graph.addEdge(4,7); graph.addEdge(6,11); graph.addEdge(6,7);
		graph.addEdge(7,8); graph.addEdge(7,9); graph.addEdge(8,9); graph.addEdge(8,10);
		
		System.out.println("BFS Traversal of the graph is:");
		BFS(graph,0); //Breadth first Search starting with vertex 0.
	}

}
