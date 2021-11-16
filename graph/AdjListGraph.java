package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjListGraph {

  private LinkedList<Integer>[] adj;
  private int V;
  private int E;

  public AdjListGraph(int nodes) {
    this.V = nodes;
    this.E = 0;
    this.adj = new LinkedList[nodes];

    for (int v = 0; v < V; v++) {
      adj[v] = new LinkedList<>();
    }
  }

  public void addEdge(int u, int v) {
    adj[u].add(v);
    adj[v].add(u);
    E++;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(V + " vertices, " + E + " edges " + "\n");
    for (int v = 0; v < V; v++) {
      sb.append(v + ": ");
      for (int w : adj[v]) {
        sb.append(w + " ");
      }
      sb.append("\n");
    }

    return sb.toString();
  }

  // bfs uses a queue!
  public void bfs(int node) {
    boolean[] visited = new boolean[V];

    Queue<Integer> queue = new LinkedList<>();
    visited[node] = true;
    queue.offer(node);

    while (!queue.isEmpty()) {
      int u = queue.poll();
      System.out.print(u + " ");

      for (int v : adj[u]) {
        if (!visited[v]) {
          visited[v] = true;
          queue.offer(v);
        }
      }
    }
  }

  // dfs iterative with a stack
  public void dfs(int node) {
    boolean[] visited = new boolean[V];
    Stack<Integer> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      int u = stack.pop();
      if (!visited[u]) {
        visited[u] = true;
        System.out.print(u + " ");

        for (int v : adj[u]) {
          if (!visited[v]) {
            stack.push(v);
          }
        }
      }
    }
  }

  public void recursiveDfs() {
    boolean[] visited = new boolean[V];
    for (int v = 0; v < V; v++) {
      if (!visited[v]) {
        recursiveDfs(v, visited);
      }
    }
  }

  public void recursiveDfs(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");

    for (int w : adj[v]) {
      if (!visited[w]) {
        recursiveDfs(w, visited);
      }
    }
  }

  public static void main(String[] args) {
    AdjListGraph graph = new AdjListGraph(5);
    graph.addEdge(0, 1);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);
    graph.addEdge(3, 0);
    graph.addEdge(2, 4);

    // graph.bfs(0);
    // graph.dfs(0);
    // graph.recursiveDfs();
  }
}
