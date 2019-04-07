package com.wycodes.numplay;

public class MulNum {
    /**
     * 输出九九乘法表
     * @param args
     */
    public static void main(String[] args) {
        //outMulNumMax(9);
        outMulNumMin(9);
    }

    /**
     * 自己控制对齐的形式
     * 从9-1输出
     * @param line
     */
    public static void outMulNumMax(int line){
        if (line==1){
            System.out.println("1=1*1");
        }else {
            for (int index=1;index<=line;index++){
                int res = line * index;
                System.out.print(line+"*"+index+"="+res);
                if (res<10){
                    System.out.print("  ");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            outMulNumMax(line-1);
        }
    }

    /**
     * 利用tab对齐
     * 从1-9的顺序
     * @param line
     */
    public static void outMulNumMin(int line){
        for (int lineIndex=1;lineIndex<=line;lineIndex++){
            for (int rowIndex=1;rowIndex<=lineIndex;rowIndex++){
                int res = lineIndex*rowIndex;
                /**
                 * 可活用tab键进行标准对齐
                 */
                System.out.print(lineIndex+"*"+rowIndex+"="+res+"\t");
            }
            System.out.println();
        }
    }
}
