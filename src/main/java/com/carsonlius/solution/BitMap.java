package com.carsonlius.solution;

import java.util.Arrays;

public class BitMap {
    long[] words;
    private int size;

    public BitMap(int size){
        this.size = size;
        this.words = new long[getWordIndex(size-1) + 1];
        System.out.println(words.length);
    }

    private int getWordIndex(int bitIndex){
        return bitIndex >> 6;
    }

    private void setBit(int bitIndex){
        if (bitIndex < 0 || bitIndex > size-1) {
            throw new IndexOutOfBoundsException("超过bitmap有效范围");
        }

        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }
    private boolean getBit(int bitIndex){
        if (bitIndex < 0 || bitIndex > size-1) {
            throw new IndexOutOfBoundsException("超过bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }


    public static void main(String[] args) {
        BitMap bitMap = new BitMap(12700);

//        bitMap.setBit(126);
        bitMap.setBit(3333);
        bitMap.setBit(75);
//         100000000000000000000000000000000000000000000000000100000000000
        //                                                    100000000000
        // 100000000000000000000000000000000000000000000000000100000000000
        // 100000
        System.out.println(Arrays.toString(bitMap.words));
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(75));
        System.out.println(bitMap.getBit(3333));
        int zero = 0;
        System.out.println(( (1L << 3331)));
        // 100000
    }
}
