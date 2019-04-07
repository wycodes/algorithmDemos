package com.wycodes;

public class PirmeNum {
    /**
     * 求区间内质数
     * @param args
     */
    public static void main(String[] args) {
        allPrimeNums(100,0);
    }

    /**
     * 判断单个数是不是质数
     * @param single
     * @return
     */
    public static boolean singlePireNum(int single){
        int mark=0;
        for (int i=1;i<=single;i++){
            if (single%i==0){
                mark++;
            }
        }
        if (mark>2){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 判断区间内的质数
     * @param begin
     * @param end
     */
    public static void allPrimeNums(int begin,int end){
        if (begin>end){
            int temp=begin;
            begin=end;
            end=temp;
        }
        for (int index=begin;index<=end;index++){
            if (singlePireNum(index)){
                System.out.println(index+"是一个质数");
            }
        }
    }
}
