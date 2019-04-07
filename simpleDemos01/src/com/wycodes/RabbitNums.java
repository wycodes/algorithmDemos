package com.wycodes;

import java.util.ArrayList;
import java.util.List;

public class RabbitNums {

    public static void main(String[] args) {
        System.out.println(testRabbitNums(10));
    }

    /**
     * 斐波那契数列
     * a1=1;
     * a2=1
     * a3=a1+a2;
     * a(n)=a(n-1)+a(n-2)
     * @param index
     * @return
     */
    public static List<Integer> testRabbitNums(int index){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);//对a1赋值
        list.add(1);//对a2赋值
        for (int n=2;n<index;n++){
            list.add(list.get(n-1)+list.get(n-2));
        }
        return list;
    }
}
