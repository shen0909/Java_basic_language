package com.yangstudy;

// 打印三角
/*
 *
 ***
 * */
public class case9 {
    public static void main(String[] args) {
        printX(10);
        printYY(4);
/**
 i = 行          j = 列  先打空格      再打*
 1                       3           1
 2                       2           3
 3                       1           5
 4                       0           7

 n                   n-i ~ 0       n+n-1 = 2*n -1
 */
    }

    public static void printX(int n) {
        for (int i = 1; i <= n; i++) {
            // 怎么打空格！！！！
            // 先打空格
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 每一行只打行数的星星
    public static void printYY(int n) {
        for (int i = 1; i <= n; i++) {
            // 怎么打空格！！！！
            // 先打空格
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                // 每一列 在偶数时不打星星
                System.out.print(j % 2 == 0 ? " " : "*");
            }
            System.out.println();
        }
    }
}
