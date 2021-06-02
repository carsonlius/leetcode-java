package com.carsonlius.solution.tree;


/**
 * 根据根节点算出二叉树的最小深度
 * */
public class MinDepth {

    public int solution(TreeNode head){
        if (head == null) {
            return 0;
        }

        // 选取各个深度中最小的那个
        return getDepth(head, 0);
    }

    private int getDepth(TreeNode node, int depth){
        // 此为叶节点
        if (node.left == null && node.right == null) {
            return depth;
        }

        int minDepth = Integer.MAX_VALUE;
        if (node.left != null) {
            int leftDepth = getDepth(node.left, depth+1);
            minDepth = Math.min(minDepth, leftDepth);
        }

        if (node.right != null) {
            minDepth = Math.min(minDepth, getDepth(node.right, depth+1));
        }

        return minDepth;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(12);
        TreeNode left = new TreeNode(3);
        head.left = left;
        MinDepth minDepth = new MinDepth();
        System.out.println(minDepth.solution(head));
    }
}
