package com.ds.binarysearchtrees;

public class TreeNode {

    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            // ignore duplicate values
            return;
        }

        if (value < data) {
            if (leftNode == null) {
                // if left node position of the current node is available, insert the value into it
                leftNode = new TreeNode(value);
            } else {
                // recursively compare the value against the left node to find the insertion point
                leftNode.insert(value);
            }
        } else {
            if (rightNode == null) {
                // if right node position of the current node is available, insert the value into it
                rightNode = new TreeNode(value);
            } else {
                // recursively compare the value against the right node to find the insertion point
                rightNode.insert(value);
            }
        }
    }

    // Travers in order (left node -> sub root node -> right node)
    public void traverseInOrder() {
        // recursively traverse the left subtree
        if (leftNode != null) {
            leftNode.traverseInOrder();
        }

        // print current node (sub root node)
        System.out.println("Data = " + data);

        // recursively traverse the right subtree
        if (rightNode != null) {
            rightNode.traverseInOrder();
        }

    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
