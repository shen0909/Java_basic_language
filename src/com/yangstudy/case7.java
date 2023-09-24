package com.yangstudy;

//找素数的三种做法
public class case7 {
    public static void main(String[] args) {
//        System.out.println("101-200之间的素数个数为:" + Seartch(101, 200));
//        System.out.println("101-200之间的素数个数为:" + preSeartch1(101, 200));
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            if (checkTF(i)) {
                count++;
                System.out.println(i + "是素数");
            }
        }
        System.out.println("当前素数个数为:" + count);
    }

    public static int Seartch(int start, int end) {
        int count = 0;

        // 如果 2-i/2 之间有取余 = 0 (有数据能够整除它)，则说明不是素数
        for (int i = start; i <= end; i++) {

            // 怎么记录素数呢？
            // 信号位思想---假设当前的数是素数，如果不是则假设失败
            boolean flag = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            // 如果当前i和 [2,i/2] 之间的所有数都进行取余之后，flage依旧= true，则说明当前i 就是素数
            if (flag) {
                System.out.println(i + "是素数");
                count++;
            }
        }
        return count;
    }

    // 关键在于，如果在内部循环发现该数不是素数时，直接结束外部的循环
    public static int preSeartch1(int start, int end) {
        int count = 0;

        //在外部循环添加一个标签
        out:
        for (int i = start; i <= end; i++) {
            for (int j = 2; j <= i / 2; j++) {
                // 此时说明i不是素数——————————关键在于如何直接结束外部循环( i 的此次循环)？
                if (i % j == 0) {
                    continue out;//结束外部循环的当次执行,开始out循环的下一次执行，这是一种跳过当前迭代继续下一次迭代的方法
                }
            }
            System.out.println(i + "是素数");
            count++;
        }
        return count;
    }

    // 方法三：遍历每个数据时将它作为参数，传递给判断素数与否的方法——————————是则返回true，否则返回false
    public static boolean checkTF(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
