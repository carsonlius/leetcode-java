package com.carsonlius.solution.tree;

public class TreeNode<T>{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data){
        this.data = data;
    }
}
