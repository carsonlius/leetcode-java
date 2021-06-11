package com.carsonlius.solution.tree;



/**
 * 打印二叉树
 * */
public class PrintTree {

    public void solution(TreeNode head){
        System.out.println("打印二叉树结构");
        printInOrder(head, 0, "H", 17);
        System.out.println("");
    }

    private void printInOrder(TreeNode node, int height, String to, int length) {
        if (node == null) {
            return ;
        }

        printInOrder(node.right, height+1, "v", length);
        String val = to + node.data + to;
        int lengthM = val.length();
        int lengthL = (length-lengthM)/2;
        int lengthR = length-lengthM-lengthL;
        val = getSpec(lengthL) + val + getSpec(lengthR);
        System.out.println(getSpec(height*length) + val);
        printInOrder(node.left, height+1, "^", length);

    }

    private String getSpec(int num){
        String spec = " ";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = num; i > 0; i--) {
            stringBuilder.append(spec);
        }

        return stringBuilder.toString();
    }
}
