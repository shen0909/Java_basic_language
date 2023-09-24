package com.yangstudy;

//数组拷贝
public class case5 {
    public static void main(String[] args) {
        int[] arry = {11, 22, 33, 44};
        printF(arrayCopy(arry));
    }

    public static void printF(int[] nu) {
        System.out.print("[");
        for (int i = 0; i < nu.length; i++) {
            System.out.print(i == nu.length - 1 ? nu[i] : nu[i] + ",");
        }
        System.out.print("]");
    }

    public static int[] arrayCopy(int[] arry) {
        // 这不是拷贝数组，只是把数组变量赋值给另一个数组变量
//        int[] num = arry;
        int[] num = new int[arry.length];
        for (int i = 0; i < arry.length; i++) {
            num[i] = arry[i];
        }
        return num;
    }

}
