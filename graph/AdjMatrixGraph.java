package graph;

public class AdjMatrixGraph {
  private int V; // # of vertices in graph
  private int E; // # of edges in graph
  private int[][] adjMatrix;

  public AdjMatrixGraph(int nodes) {
    this.V = nodes;
    this.E = 0;
    this.adjMatrix = new int[nodes][nodes];
  }

  public void addEdge(int u, int v) {
    adjMatrix[u][v] = 1;
    adjMatrix[v][u] = 1; // it's undirected
    E++;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(V + " vertices, " + E + " edges " + "\n");

    for (int v = 0; v < V; v++) {
      sb.append(v + ": ");
      for (int w : adjMatrix[v]) {
        sb.append(w + " ");
      }

      sb.append("\n");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    AdjMatrixGraph graph = new AdjMatrixGraph(4);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 0);

    System.out.println(graph);
  }
}
