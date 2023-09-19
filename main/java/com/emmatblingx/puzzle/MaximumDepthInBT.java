package com.emmatblingx.puzzle;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumDepthInBT {
//    Object[] treeItems = {3, 9, 20, null, null, 15, 7, 5, 88, null, null};
    Tree tree = new Tree();
    Node rootNode = new Node(3);
    Node secondNode = new Node(9);
    Node thirdNode = new Node(20);
    Node fourthNode = new Node(15);
    Node fifthNode = new Node(7);
    Node SixthNode = new Node(5);
    Node SeventhNode = new Node(88);

    {
        tree.addNode(rootNode);
        tree.addNode(secondNode);
        tree.addNode(thirdNode);
        tree.addNode(fourthNode);
        tree.addNode(fifthNode);
        tree.addNode(SixthNode);
        tree.addNode(SeventhNode);

        tree.addEdge(rootNode, secondNode, 0);
        tree.addEdge(rootNode, thirdNode, 1);

        tree.addEdge(thirdNode, fourthNode, 0);
        tree.addEdge(thirdNode, fifthNode, 1);

        tree.addEdge(fourthNode, SixthNode, 0);
        tree.addEdge(fourthNode, SeventhNode, 1);
    }

    public int getMaxDepth() {
        Stack<Node> path = new Stack<>();
        ArrayList<Node> processed = new ArrayList<>();
        path.add(rootNode);

        int maxDepth = 0;

        while (! path.empty()) {
            Node currentNode = path.pop();

            if (processed.contains(currentNode)) continue;

            processed.add(currentNode);

            for (Node child: currentNode.children) {
                if (child != null) {
                    child.depth = currentNode.depth + 1;
                    path.add(child);
                    if( child.depth > maxDepth) maxDepth =  child.depth;
                }
            }
        }

        return maxDepth;
    }

    class Node {
        int value;
        int depth = 1;
        Node[] children = new Node[2];

        public Node(int i) {
            value = i;
        }
    }

    class Tree {
        ArrayList<Node> items = new ArrayList<>();

        void addEdge(Node from, Node to, int position) {
            if(!items.contains(from) || !items.contains(to)) {
                throw new RuntimeException("Cannot add duplicate nodes");
            }

            if(position > 1 || position < 0) {
                throw new RuntimeException("Binary Tree has max of two children");
            }

            from.children[position] = to;
        }

        void addNode(Node node) {
            if(items.contains(node)) {
                throw new RuntimeException("Cannot add duplicate nodes");
            }

            items.add(node);
        }
    }
}
