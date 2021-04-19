package com.ds.binarysearchtrees;

public class Tree {

    private TreeNode rootNode;

    public void insert(int value) {
        if (rootNode == null) {
            // insert into an empty tree
            rootNode = new TreeNode(value);
        } else {
            rootNode.insert(value);
        }
    }

    public void traverseInOrder() {
        if (rootNode != null) {
            rootNode.traverseInOrder();
        }
    }

    public void delete(int value) {
        rootNode.delete(rootNode, value);
    }

}
