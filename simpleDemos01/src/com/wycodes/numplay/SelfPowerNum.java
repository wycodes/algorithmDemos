package com.wycodes.numplay;

import java.util.ArrayList;

public class SelfPowerNum {
    /**
     * 自幂数求解步骤
     * 1.拆解每个数每个位置上的数
     * 2.求每个位上的数的幂次和
     * 3.在区间内按数循环
     * @param args
     */

    public static void main(String[] args) {
        allLoveSelfNum(99999,1);
    }

    private static ArrayList<Integer> arr=new ArrayList<>();

    /**
     * 对一个数进行拆解，把每一位上的数字放到ArrayList中
     * 1.如何判断一个数字的位数:转成字符串，看字符串的长度
     * 2.注意截位时，若出现类似于407这样的情况，要对迭代的下一项进行位长判断
     * 3.迭代时，由于堆栈特性，return的值会不可达，故不要使用返回值
     * @param x
     */
    private static void splitSingleNum(int x){
        int len = String.valueOf(x).length();
        if (len>1){
            StringBuffer buffer = new StringBuffer("1");
            for (int i=0;i<len-1;i++){
                buffer.append("0");
            }
            int mod = Integer.parseInt(buffer.toString());
            int posNum=x/mod;
            arr.add(posNum);
            int next=x-mod*posNum;
            int nextLen = String.valueOf(next).length();
            if (nextLen!=len-1){
                arr.add(0);
            }
            splitSingleNum(next);
        }else {
            arr.add(x);
        }
    }

    /**
     * 利用字符串的属性，更加快捷地截位
     * 若遇到低版本的jdk，可以使用原生的for循环，将char转换为int
     * (s.charAt(index)-'0')
     * 这是一个倒推码表的过程，只能这样写，不要写成(s.charAt(index)+'0')或者((int)s.charAt(index))
     * 这样均得不到想要的效果
     * 故必须要这样写：
     * for (int index=0;index<s.length();index++){
     *             arrayList.add((s.charAt(index)-'0'));
     *         }
     * @param x
     */
    private static void simpleSplitSingleNum(int x){
        StringBuffer buffer = new StringBuffer(String.valueOf(x));
        String[] split = buffer.toString().split("");
        for (String singleElement:split){
            arr.add(Integer.parseInt(singleElement));
        }
    }

    /**
     * 计算一个数字的幂次
     * 此次没有使用迭代，是因为我要拿到返回值
     * 连续乘积即可
     * @param singleNum 每一位上的数字
     * @param len 总位数
     * @return
     */
    private static int countSinglePower(int singleNum,int len){
        int singlePower=1;
        for (int i=0;i<len;i++){
            singlePower=singlePower*singleNum;
        }
        return singlePower;
    }

    /**
     * 对拆解出来的每一位求幂次和
     * @return
     */
    private static int countAllPower(){
        int allPower=0;
        for (Integer single:arr){
            allPower=allPower+countSinglePower(single,arr.size());
        }
        return allPower;
    }

    /**
     * 判断某一个数是不是自幂数
     * @param num
     * @return
     */
    public static boolean singleLoveSelfNum(int num){
        simpleSplitSingleNum(num);
        if (countAllPower()==num){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断范围内的自幂数
     * @param begin
     * @param end
     */
    public static void allLoveSelfNum(int begin,int end){
        if (begin>end){
            int temp=begin;
            begin=end;
            end=temp;
        }
        for (int index=begin;index<=end;index++){
            if (singleLoveSelfNum(index)){
                System.out.println(index+"是一个自幂数");
            }
            arr.clear();
        }
    }
}
