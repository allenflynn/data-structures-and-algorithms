package com.ds.binarysearchtrees;

public class Tree {

    private TreeNode rootNode;

    public void insert(int value) {
        if (rootNode == null) {
            // empty tree
            rootNode = new TreeNode(value);
        } else {
            rootNode.insert(value);
        }
    }
}
