package com.yangstudy;

import java.util.Random;
import java.util.Scanner;

// 模拟双色球
public class case10mock {

    // 投注号码：6个红色球号码  1个蓝色球号码
    // 红色球号码：1-33  蓝色球号码：1-16
    // 判断命中了几个 红球 蓝球 号码
    public static void main(String[] args) {
        System.out.println(check(UserN(), nNumber()));
//        System.out.println(check(UserN(), nNumber()) ? "恭喜,您投注的号码已中奖！" : "很遗憾，您投注的号码未中奖");
    }

    // 随机生成一组中奖号码，并返回这组数字，
    // 随机生成的红球号码依旧不能重复
    public static int[] nNumber() {
        int[] number = new int[7];
        Random random = new Random();
        for (int i = 0; i < number.length - 1; i++) {
            while (true) {
                int code = random.nextInt(33) + 1;
                // 如果生成的红球重复，则继续死循环
                if (!exist(code, number, 6)) {
                    number[i] = code;
                    break;
                }
                System.out.println("很抱歉，生成的红球数字重复，需要重新生成");
            }
        }
        number[6] = random.nextInt(16) + 1;
        System.out.print("中奖号码为:");
        printArray(number);
        return number;
    }

    // 让用户投注一组号码，并返回这组数字
    public static int[] UserN() {
        int[] userN = new int[7];
        Scanner scanner = new Scanner(System.in);
        System.out.println("——————————请用户输入选择的投注号码————————");

        // 1、输入的号码不能越界
        // 2、输入的红球号码不能重复
        for (int i = 0; i < userN.length - 1; i++) {

            out:
// 给while循环起别名
            while (true) {
                System.out.print("\n请输入第" + (i + 1) + "位红球号码，范围在[1-33]:");
                int num = scanner.nextInt();
                // 输入红球的投注号码
                if (num <= 0 || num > 33) {
                    System.out.println("抱歉，您输入的红球号码不在[1-33]之间，请重新输入");
                    continue;
                }
                if (exist(num, userN, i)) {
                    System.out.println("很抱歉，您输入的红球号码已经重复，请重新输入");
                    // continue 是跳出当前循环的当次执行，开始循环的下一次执行
                    continue;// 结束while 死循环的当次 后，继续下一次死循环
                }
                // 将判断重复的代码封装成一个单独的方法
                    /*// 如何在结束for 循环后 继续死循环呢？
                    for (int j = 0; j < i; j++) {
                        if(num == userN[j]){
                            System.out.println("很抱歉，您输入的红球号码已经重复，请重新输入");
                            // continue 是跳出当前循环的当次执行，开始循环的下一次执行
                            continue out;// 结束while 死循环的当次 后，继续下一次死循环
                        }
                    }*/
                userN[i] = num;
                break;//跳出并结束当前所在循环的执行
            }
        }
        // 输入蓝球的投注号码
        while (true) {
            System.out.print("\n请输入投注的蓝球号码,范围在[1-16]:");
            int num = scanner.nextInt();
            if (num <= 0 || num > 16) {
                System.out.println("抱歉，您输入的蓝球号码不在[1-16]之间，请重新输入");
                continue;
            }
            userN[6] = num;
            break;
        }

        System.out.print("用户投注号码为:");
        printArray(userN);
        return userN;
    }

    // 判断用户是否中奖
    public static String check(int[] userN, int[] nNumber) {
        int red = 0;
        boolean blue = false;
        String check = "";
        // 判断红球的中奖情况
        for (int i = 0; i < userN.length - 1; i++) {
            if (userN[i] == nNumber[i])
                red++;
        }
        if(userN[6] == nNumber[6]){
            blue = true;
        }

        System.out.println("红球数量命中"+red+"个");
        System.out.println(blue?"蓝球命中1个":"蓝球未命中");
        switch (red){
            case 6:
                if(blue)
                    check= "恭喜您！中奖10000万元！";
                else
                    check= "恭喜您！中奖500万元！";
                break;
            case 5:
                if(blue)
                    check= "恭喜您！中奖3000元！";
                else
                    check= "恭喜您！中奖200元！";
                break;
            case 4:
                if (blue)
                    check= "恭喜您！中奖200元！";
                else
                    check= "恭喜您！中奖10元！";
                break;
            case 3:
                if (blue) {
                    check = "恭喜您！中奖10元";
                    break;
                }
            case 2:
            case 1:
            case 0:
                if (blue) {
                    check = "恭喜您！中奖10元";
                    break;
                }
            default:
                check ="很遗憾！您此次投注并未中奖！请下次再来！";

        }
        return check;

    }

    // 输入数组的方法
    private static void printArray(int[] aryy) {
        System.out.print("[");
        for (int i = 0; i < aryy.length; i++) {
            System.out.print(i == aryy.length - 1 ? aryy[i] : aryy[i] + ",");

        }
        System.out.println("]");
    }

    // 判断输入的数字是否已经存在
    public static boolean exist(int number, int[] allnumber, int index) {
        for (int i = 0; i < index; i++) {
            if (allnumber[i] == number) {
                return true;
            }
        }
        return false;
    }
}
