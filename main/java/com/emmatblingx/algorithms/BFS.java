package com.emmatblingx.algorithms;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BFS {
    //init nodes
    public final Node node1 = new Node("CAB");
    public final Node node2 = new Node("CAR");
    public final Node node3 = new Node("BAR");
    public final Node node4 = new Node("CAT");
    public final Node node5 = new Node("BAT");
    public final Node node6 = new Node("MAT");

    Hashtable<String, Node[]> graph = new Hashtable<>();// One Directional

     {
        //setup relationships between nodes
        graph.put(node1.toString(), new Node[]{node4, node2});
        graph.put(node2.toString(), new Node[]{node4, node3});
        graph.put(node3.toString(), new Node[]{node5});
        graph.put(node4.toString(), new Node[]{node6, node5});
        graph.put(node5.toString(), new Node[]{});
        graph.put(node6.toString(), new Node[]{node5});
    }

    Node search(String start, String end) {
        //setup queue
        Queue<Node> nodeQueue = new ConcurrentLinkedQueue<>();
        Set<Node> checked = new HashSet<>();

        nodeQueue.add(new Node(start));

        while(nodeQueue.peek() != null) {
            Node current = nodeQueue.poll();

            if (checked.contains(current)) {
                continue;
            }

            Node endNode = new Node(end);
            checked.add(current);

            if (current.equals(endNode)) {
                return current;
            } else {
                nodeQueue.addAll(Arrays.asList(graph.get(current.toString())));
            }
        }

        return null;
    }

    List<Node> getShortestPath(String start, String end) {
        //setup queue
        Queue<Node> nodeQueue = new ConcurrentLinkedQueue<>();
        Map<Node, Node> backTracking = new HashMap<>();
        Set<Node> checked = new HashSet<>();
        Node startNode = new Node(start);
        Node endNode = new Node(end);

        nodeQueue.add(startNode);
        backTracking.put(startNode, null);

        while(nodeQueue.peek() != null) {
            Node current = nodeQueue.poll();

            if (checked.contains(current)) {
                continue;
            }

            checked.add(current);

            if (current.equals(endNode)) {
                return buildPath(backTracking, current);
            } else {
                for (Node neighbor : graph.get(current.toString()) ) {
                    backTracking.putIfAbsent(neighbor, current);
                }

                nodeQueue.addAll(Arrays.asList(graph.get(current.toString())));
            }
        }

        return null;
    }

    private List<Node> buildPath(Map<Node, Node> backTracking, Node current) {
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

    class Node {
        String name;
        int steps = 0;

        Node(String name){
            this.name = name;
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
