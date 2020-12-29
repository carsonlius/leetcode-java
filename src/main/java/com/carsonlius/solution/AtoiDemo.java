package com.carsonlius.solution;


import java.util.HashMap;
import java.util.Map;

public class AtoiDemo {
    public static void main(String[] args) {
        AtoiDemo atoiDemo = new AtoiDemo();
        String str = "-42";

        System.out.println(atoiDemo.myAtoi(str));

    }

    /**
     * 确定有限状态机
     *
     * */
    public int myAtoi(String s) {
        String sTrim= s.trim();
        char[] sChar = sTrim.toCharArray();
        Atoi atoi = new Atoi();
        for (char c : sChar) {
            atoi.get(c);
        }

        return atoi.getNumber();
    }
}


/**
 * 确定有限自动机
 * */
class Atoi{
    /**
     * 非空有限的状态集合
     *  start 开始
     *  signed  找到符号
     *  in_number 寻找number数字的阶段
     *  end 结束
     *  状态表在状态迁移函数中需要用到
     *  0,1,2,3 '' +/ number other
     * */
    private Map<String, String[]> table = new HashMap<String, String[]>(){{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};


    /**
     * 开始状态
     * */
    private String state = "start";

    // 只是借助状态机的状态转移机制，不需要考虑一个接受状态的集合，不过非要说的话就是end
    // 一个输入的字母表是确定的，String str

    /**
     * 获取当前转换后的数字, int可能溢出
     * */
    private long number;

    /**
     * 是否是负数
     * */
    private boolean negative = false;

    public int getNumber(){
        return negative ? -(int)number : (int)number;
    }

    /**
     * 定义状态迁移函数
     */
    public void get(char c){
        state = table.get(state)[getCharOffset(c)];
        if (state == "end") {
            return;
        } else if ("in_number".equals(state)) {
            number = number * 10 + c - '0';
            // 检测防止溢出
            number = negative ? Math.min(-(long)Integer.MIN_VALUE, number) : Math.min((long)Integer.MAX_VALUE, number);
        } else if ("signed".equals(state)) {
            negative = c == '-' ? true : false;
        }

    }

    /**
     * 获取字符在当前状态机器的偏移量
     * */
    private int getCharOffset(char c)
    {
        // 字符
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (Character.isDigit(c)) {
            return 2;
        } else {
            return 3;
        }
    }
}
