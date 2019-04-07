package com.wycodes.numplay;

import java.util.ArrayList;

public class SplitElsofNum {

    /**
     * 拆解因式，形如 18 = 2 * 3 * 3 ，那么把业务拆分成两个逻辑单元（一步就是一个逻辑单元）
     * 1.对数进行拆解，将因子放入list中
     * 2.遍历list，拼串
     */

    public static void main(String[] args) {
        for(int index=20;index<=35;index++){
            System.out.println(seeSplit(index));
        }
    }

    private static ArrayList<Integer> arr =new ArrayList<>();

    /**
     * 对一个数字进行因式拆分
     * 方法要满足单一职责，就是说我们的方法，调用一次只做一个逻辑单元，只做一步
     * @param num
     */
    private static void splitNum(int num){
        if (num>1){//输入的数字为1时，停止处理
            int next=1;
            /**
             * for循环的目的：找到第一个适配因子，比如拆18的时候，拆到2，发现2可以拆下来，我们就立即跳出
             */
            for (int index=2;index<=num;index++){//从2开始进行试商，一旦能够除尽，立刻跳出循环
                if (num%index==0){
                    arr.add(index);
                    next=num/index;
                    break;
                }
            }
            splitNum(next);//将下一个值进行迭代
        }else {
            return;
        }
    }

    /**
     * 拼装因式
     * @param num
     * @return
     */
    public static String seeSplit(int num){
        splitNum(num);
        StringBuffer buffer = new StringBuffer();
        buffer.append(num);
        buffer.append("=");
        for (int elment:arr){
            buffer.append(elment);
            buffer.append("*");
        }
        buffer.deleteCharAt(buffer.length()-1);
        arr.clear();//此时arr的使命已经完成，把里面的数据清空，方便多次循环时使用
        return buffer.toString();
    }


}
