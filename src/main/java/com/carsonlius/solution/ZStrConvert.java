package com.carsonlius.solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * */

public class ZStrConvert {
    public static void main(String[] args) throws Exception {
       String s = "LEETCODEISHIRING";
       int numRows = 3;
       String exceptString = "LCIRETOESIIGEDHN";
       ZStrConvert zStrConvert = new ZStrConvert();
        System.out.println(exceptString.equals(zStrConvert.convert(s, numRows)));

        String anoString  = (new StringBuffer()).append("LCIRETOESIIGEDHN").toString();
        System.out.println(exceptString == anoString);
    }

    /**
     * @param s 字符串
     * @param numRows 转换成的函数
     *
     * */
    public String convert(String s, int numRows) throws Exception {
        // 异常的行数
        if (numRows <= 0) {
            throw new Exception("numRows不合法");
        }

        if (numRows == 1) {
            return s;
        }

        // 定义包含各行字符的列表
        List<StringBuffer> stringBufferList = new LinkedList<>();
        // 行数, 如果字符长度小于定义的行数，则选取字符长度


        for (int i = 0; i <  Math.min(s.length(), numRows); i++) {
            stringBufferList.add(new StringBuffer());
        }

        // 当前字符所在的行数
        int rowNow = 0;
        // 是否正在下行
        boolean goingDown = false;
        
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            stringBufferList.get(rowNow).append(aChar);

            // 判断是上行还是下行
            if (rowNow == 0) {
                goingDown = true;
            }

            // 到了下行的最后一步，那么下次就是上行
            if (rowNow == numRows -1) {
                goingDown = false;
            }

            // 移动行数 需要根据上行/下行来调整
            rowNow += goingDown ? 1 : -1;
        }

        // 定一个新的字符串
        StringBuffer stringBufferNew = new StringBuffer();
        stringBufferList.forEach(stringBuffer->{
            stringBufferNew.append(stringBuffer);
        });

        return stringBufferNew.toString();
    }
}
