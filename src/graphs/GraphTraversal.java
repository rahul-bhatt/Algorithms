/**
 * 
 */
package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import graphs.Graph.Vertex;


/**
 * Graph (Adjency list representation) traversal using DFS and BFS
 * 
 * @author rahulbhatt
 *
 */
public class GraphTraversal {

	// Time: O(v + e)
	// Space: O(v)
	Set<String> depthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push(root);
	    
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Vertex v : graph.getAdjVertices(vertex)) {              
	                stack.push(v.label);
	            }
	        }
	    }
	    
	    return visited;
	}
	
	// Time: O(v + e)
	// Space: O(v)
	Set<String> breadthFirstTraversal(Graph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(root);
	    visited.add(root);
	    
	    while (!queue.isEmpty()) {
	        String vertex = queue.poll();
	        for (Vertex v : graph.getAdjVertices(vertex)) {
	            if (!visited.contains(v.label)) {
	                visited.add(v.label);
	                queue.add(v.label);
	            }
	        }
	    }
	    
	    return visited;
	}
}

class Graph {
	private Map<Vertex, List<Vertex>> adjVertices;

    Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void removeVertex(String label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
    
    String printGraph() {
        StringBuffer sb = new StringBuffer();
        for(Vertex v : adjVertices.keySet()) {
            sb.append(v);
            sb.append(adjVertices.get(v));
        }
        return sb.toString();
    }

    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
}

