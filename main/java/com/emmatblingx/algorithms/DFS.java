package com.emmatblingx.algorithms;

import java.util.*;

public class DFS {
    //init nodes
    public final Node node1 = new Node("book");
    public final Node node2 = new Node("lp");
    public final Node node3 = new Node("poster");
    public final Node node4 = new Node("guitar");
    public final Node node5 = new Node("piano");
    public final Node node6 = new Node("drum");

    Hashtable<String, Node[]> graph = new Hashtable<>();// One Directional

    {
        //setup relationships between nodes sample 1
        graph.put(node1.toString(), new Node[]{node2, node3});
        graph.put(node2.toString(), new Node[]{node4});
        graph.put(node3.toString(), new Node[]{node2, node6 });
        graph.put(node4.toString(), new Node[]{node5});
        graph.put(node5.toString(), new Node[]{});
        graph.put(node6.toString(), new Node[]{node5});

        //sample 2
//        graph.put(node1.toString(), new Node[]{node3, node2});
//        graph.put(node3.toString(), new Node[]{node5, node4 });
//        graph.put(node5.toString(), new Node[]{});
//        graph.put(node4.toString(), new Node[]{});
//        graph.put(node2.toString(), new Node[]{});

//        graph.put(node1.toString(), new Node[]{node3, node2});
//        graph.put(node3.toString(), new Node[]{node5, node4 });
//        graph.put(node5.toString(), new Node[]{});
//        graph.put(node4.toString(), new Node[]{});
//        graph.put(node2.toString(), new Node[]{node3});
    }

    Stack<Node> nodeStack = new Stack<>();
    Map<Node, Node> backTracking = new HashMap<>();
    Set<Node> checked = new HashSet<>();

    List<Node> getLongestPath(String start, String end) {
        //setup queue
        Node startNode = new Node(start);
        Node endNode = new Node(end);

        if(startNode.equals(endNode)){
            return buildPath(backTracking, endNode);
        }

        nodeStack.push(startNode);
        backTracking.putIfAbsent(startNode, null);

        while(nodeStack.peek() != null) {
            Node current = nodeStack.peek();

            if(checked.contains(current)) {
                continue;
            }

            checked.add(current);
            /**
             * if current node has neighbours we traverse the neighbours depth first
             */
            if (graph.get(current.toString()).length != 0) {
                for (Node neighbor : graph.get(current.toString()) ) {
                    backTracking.putIfAbsent(neighbor, current);
                    List<Node> path = getLongestPath(neighbor.toString(), end);
                    if(path != null) return path;
                }
            } else {
                nodeStack.pop(); //if current has no neighbours
                return null;
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

        @Override
        public String toString() {
            return name;
        }
    }
}
