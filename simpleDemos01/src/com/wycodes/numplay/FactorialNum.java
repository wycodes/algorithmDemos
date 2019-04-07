package com.wycodes.numplay;

public class FactorialNum {
    /**
     * 求阶乘
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(testFactorNum03(4));
    }

    /**
     * 写法一：利用递归
     * @param i
     * @param s
     * @return
     */
    public static int testFactorialNum(int i,int s){
        int sum=s;
        if (i>1){
            sum=sum*i;
            return testFactorialNum(i-1,sum);
        }else {
            return sum;
        }
    }

    /**
     * 写法二：利用普通循环
     * @param n
     * @return
     */
    public static int testFactorNum02(int n){
        int sum=1;
        for (int i=0;i<=n;i++,n--){
            sum=sum*n;
        }
        return sum;
    }

    /**
     * 最简洁写法
     * @param i
     * @return
     */
    public static int testFactorNum03(Integer i){
        if(i == 0){
            return 1;
        }
        return i*testFactorNum03(i-1);
    }
}
