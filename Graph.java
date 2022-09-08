import java.io.*;
import java.util.*;
public class Graph<E>
{
    private static class Node<E> {
        private E       value;
        private boolean visited;
        private LinkedList<Integer> adj;
        private Node(E dataItem, int id) {
            value   =   dataItem;
            node_id =   id;
            visited =   false;
            adj     =   new LinkedList<Integer>();
        }
    }
    private int num_nodes = 0;
    private ArrayList<Node<E>> nodes = new ArrayList<Node<E>>();
    public Graph() {}
    public void addVertex(E dataItem) {
        Node<E> newNode = new Node<E>(dataItem, num_nodes);
        nodes.add(newNode);
        num_nodes ++;
    }
    public void addEdge(E v, E w) {
        int vid = num_nodes;
        int wid = num_nodes;
        for (int i = 0; i < num_nodes; i ++) {
            if (nodes.get(i).value.equals(v)) vid = nodes.get(i).node_id;
            if (nodes.get(i).value.equals(w)) wid = nodes.get(i).node_id;
        }
        if (vid == num_nodes || wid == num_nodes) return;
        nodes.get(vid).adj.add(wid);
        nodes.get(wid).adj.add(vid);
    }
    public String toString() {
StringBuilder result   =  new StringBuilder();
        for (int i = 0; i < num_nodes; i ++) {
            result.append(nodes.get(i).value + " -> ");
            Iterator<Integer> it = nodes.get(i).adj.iterator();
            while (it.hasNext()) {
                int id = it.next();
                result.append(nodes.get(id).value + ", ");
            }
            result.append("\n");
        }
return result.toString();
}
public void findVerticesWithNoAdjacentVertices(){
    bool notfound = true;
    for(int i = 0; i< nodes.size(); i++){
        if (nodes.get(i).adj.size() == 0){
            notfound = false;
            System.out.println(nodes.get(i).node_id);
        
        }
    }
    if (notfound){
        System.out.println("Not Found");
    }
}
}