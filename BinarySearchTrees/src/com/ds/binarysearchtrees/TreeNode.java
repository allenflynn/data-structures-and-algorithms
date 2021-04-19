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

    // Traverse in order (left node -> sub root node -> right node)
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

    public TreeNode delete(TreeNode subRootNode, int value) {
        if (value < data) {
            subRootNode.setLeftNode(leftNode.delete(leftNode, value));
        } else if (value > data) {
            subRootNode.setRightNode(rightNode.delete(rightNode, value));
        } else {
            // node to delete has 0 or 1 child node
            if (leftNode == null) {
                return rightNode;
            }
            if (rightNode == null) {
                return leftNode;
            }

            // Node to delete has 2 children
            // replace the value in the subRootNode with the biggest value from the left subtree
            data = leftNode.max();
            // delete the node that has the biggest value in the left subtree
            setLeftNode(leftNode.delete(leftNode, data));
        }

        return subRootNode;
    }

    // Start at the current node, traverse down to the right edges to find the max value
    public int max() {
        if (rightNode == null) {
            return data;
        } else {
            return rightNode.max();
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
