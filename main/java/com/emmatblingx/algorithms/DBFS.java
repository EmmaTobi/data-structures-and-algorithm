package com.emmatblingx.algorithms;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Dijkstra Algorithm
 * Determine the fastest path to a node
 */
public class DBFS {

    Node book = new Node("book");
    Node lp = new Node("lp");
    Node poster = new Node("poster");
    Node drum = new Node("drum");
    Node piano = new Node("piano");
    Node guitar = new Node("guitar");

    Graph graph;

    {
        graph = new Graph();

        graph.addNode(book);
        graph.addNode(lp);
        graph.addNode(poster);
        graph.addNode(drum);
        graph.addNode(piano);
        graph.addNode(guitar);

        graph.addEdge("book", "poster", 0);
        graph.addEdge("book", "lp", 5);
        graph.addEdge("lp", "guitar", 15);
        graph.addEdge("lp", "drum", 20);
        graph.addEdge("poster", "guitar", 30);
        graph.addEdge("poster", "drum", 35);
        graph.addEdge("drum", "piano", 10);
        graph.addEdge("guitar", "piano", 20);
    }

    public List<Node> getFastestPath(String start, String end) {
        return graph.getFastestPath(start, end);
    }

    class Graph {
        Map<Node, Integer> costs = new HashMap<>(); // cost relative to start node;
        Map<Node, Node> parent = new HashMap<>(); // node parent during journey from start node for bactracking when fastest path us gotten
        List<Node> processed = new ArrayList<>(); //processed
        Map<String, Node> nodes = new HashMap<>(); //nodes

        void addNode(Node node) {
            nodes.put(node.name, node);
        }

        void addEdge(String from, String to, int cost){
            if(! (nodes.containsKey(from) && nodes.containsKey(to)) ) {
                throw new IllegalArgumentException("Ensure nodes exists");
            }

            Node fromNode = nodes.get(from);
            Node toNode = nodes.get(to);

            fromNode.getWeightedNeighbours().put(toNode, cost);
        }

        public List<Node> getFastestPath(String start, String end) {
            Queue<Node> nodeQueue = new ConcurrentLinkedQueue<>();

            Node startNode = nodes.get(start);
            Node endNode = nodes.get(end);
            nodeQueue.add(startNode);

            while(nodeQueue.peek() != null) {
                Node current = nodeQueue.poll();

                if(processed.contains(current)) continue;

                if(current.equals(endNode)){
                    return buildReversePath(parent, endNode);
                }

                for (Node neighbour : current.getWeightedNeighbours().keySet()) {
                    int cost = current.getWeightedNeighbours().get(neighbour); // default cost
                    int currentRelativeCost = costs.getOrDefault(current, 0); //relative cost of parent node
                    int neighbourRelativeCost = currentRelativeCost + cost; //relative cost of neighbour node

                    if (costs.get(neighbour) == null) {
                        costs.put(neighbour, cost);
                        parent.put(neighbour, current);
                    } else if (neighbourRelativeCost < costs.getOrDefault(neighbour, 0) ) {
                        costs.put(neighbour, neighbourRelativeCost);
                        parent.put(neighbour, current);
                    }

                    nodeQueue.add(neighbour);
                }

                processed.add(current);
            }

            return null;
        }

        private List<Node> buildReversePath(Map<Node, Node> backTracking, Node current) {
            List<Node> sp = new ArrayList<>();
            sp.add(current);

            Node node = current;
            while (backTracking.get(node) != null) {
                Node parent = backTracking.get(node);
                sp.add(parent);
                node = parent;
            }

            Collections.reverse(sp);

            return sp;
        }
    }
    class Node {

        public String name;
        public Map<Node, Integer> weightedNeighbours = new HashMap<>(); // default cost of neigbors relative to parent

        public Node(String name) {
            this.name = name;
        }

        public Map<Node, Integer> getWeightedNeighbours() {
            return weightedNeighbours;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;

            Node node = (Node) o;

            return name != null ? name.equals(node.name) : node.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }
}
