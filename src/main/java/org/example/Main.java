package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    public static boolean isTreeComplete(Node root) {
        // Empty tree is complete Binary Tree
        if (root == null)
            return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;

        while(!queue.isEmpty()) {
            Node temp_node = queue.remove();

            if(temp_node.left != null) {
                if(flag)
                    return false;
                queue.add(temp_node.left);
            } else
                flag = true;

            if(temp_node.right != null) {
                if(flag)
                    return false;
                queue.add(temp_node.right);

            } else
                flag = true;
        }
        // If we reach here, then the tree is complete Binary Tree
        return true;

    }
    public static void main(String[] args) {

        /* Let us construct the following Binary Tree which
          is not a complete Binary Tree
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
          /
         8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);

        if(isTreeComplete(root))
            System.out.println("Complete Binary Tree");
        else
            System.out.println("NOT Complete Binary Tree");
    }
}