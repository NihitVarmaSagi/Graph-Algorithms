package strongConnected;

import java.util.Queue;
import java.util.LinkedList;

public class StrongGraph {
	int vertices;
	int adjacency_matrix[][];
	
	StrongGraph(int vertices){
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
	}
	
	static boolean[] BFS(StrongGraph graph, int x){
		boolean visited[] = new boolean[graph.vertices];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		while(queue.isEmpty()!=true){
			int u = queue.remove();
			for(int i=0;i<graph.vertices;i++){
				if(graph.adjacency_matrix[u][i]==1){
					if(visited[i]==false && queue.contains(i)==false){
						queue.add(i);
					}
				}
			}
			visited[u] = true;
		}
		return visited;
	}
	
	static boolean isStronglyConnected(StrongGraph graph){
		boolean[] visited = BFS(graph, 0);
		for(int i=0;i<graph.vertices;i++){
			if(visited[i]==false){
				return false;
			}
		}
		
		int [][] temp = new int[graph.vertices][graph.vertices];
		for(int i=0;i<graph.vertices;i++){
			for(int j=0;j<graph.vertices;j++){
				temp[j][i] = graph.adjacency_matrix[i][j]; 
			}
		}
		
		graph.adjacency_matrix = temp;
		
		boolean[] visited1 = BFS(graph,0);
		for(int i=0;i<graph.vertices;i++){
			if(visited1[i]==false){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		StrongGraph g1 = new StrongGraph(10);
		g1.addEdge(0, 1);g1.addEdge(1, 0); g1.addEdge(1, 2); g1.addEdge(2, 3);g1.addEdge(2, 4); 
		g1.addEdge(3,4);g1.addEdge(4,5);g1.addEdge(5, 6);g1.addEdge(6, 3); g1.addEdge(6, 7);
		g1.addEdge(7, 8); g1.addEdge(8, 9); g1.addEdge(8, 5); g1.addEdge(9, 1);g1.addEdge(9, 0);
		
		System.out.println(isStronglyConnected(g1));
		
		StrongGraph g2 = new StrongGraph(10);
		g2.addEdge(0, 1);g2.addEdge(1, 0); g2.addEdge(1, 2); g2.addEdge(2, 3);g2.addEdge(2, 4); 
		g2.addEdge(3,4);g2.addEdge(4,5);g2.addEdge(5, 6);g2.addEdge(6, 3); g2.addEdge(6, 7);
		g2.addEdge(7, 8); g2.addEdge(8, 9); g2.addEdge(8, 5);g2.addEdge(9, 2); g2.addEdge(9, 6);
		
		System.out.println(isStronglyConnected(g2));
		

	}

}
