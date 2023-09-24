package com.yangstudy;

// 打印乘法表
public class case8 {
    public static void main(String[] args) {
        // i 行 j 列
        // 计算机只能按照行打
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }
}
