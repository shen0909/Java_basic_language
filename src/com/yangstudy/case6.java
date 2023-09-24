package com.yangstudy;

import java.util.Random;
import java.util.Scanner;

//抢红包
public class case6 {
    public static void main(String[] args) {
        // 中奖次数 = 红包个数
        int[] redpack = {9,666,188,520,99999};
//        getRed(redpack);
        preGetRed(redpack);
        // 随机抽取，生成 0- 红包长度-1的随机数？
    }
//    这种方法会出现性能问题：进行最后一个红包抽取时，会有多次抽空的情况。
    public static void getRed (int[] redpack){
        Random re = new Random();
        Scanner sca = new Scanner(System.in);
// 法一， i++
        for( int i = 0; i< redpack.length ; i++){
            System.out.print("请随机输入一个数字开始抽取红包:");
            sca.nextInt();
            int index = re.nextInt(redpack.length) ;
            // 此时没有抽中
            // i-- 结束此次循环
            if(redpack[index] == 0){
                System.out.println("\n很抱歉您没有抽中，请重新抽取！");
                i--;
                continue;
            }
            // 此时抽中了
            // 打印中奖语句，并将此处的红包金额修改为0元
            else {
                System.out.println("你抽到的红包为:"+redpack[index]+"元");
                redpack[index] = 0;
            }

        }
// 法二 ：在 for循环中添加死循环

        for( int i = 0; i< redpack.length ; i++){

            while(true){
                System.out.print("请随机输入一个数字开始抽取红包:");
                sca.nextInt();
                int index = re.nextInt(redpack.length) ;
                // 此时红包金额≠0，说明抽中红包
                // 结束当前死循环,并将红包金额修改为 0
                if( redpack[index] !=0){
                    System.out.println("你抽到的红包为:"+redpack[index]+"元");
                    redpack[index] = 0;
                    break;
                }
                // 此时没有抽中,继续死循环
                System.out.println("\n很抱歉您没有抽中，请重新抽取！");
            }
        }
    }

//    优化方法:将这五个红包的索引顺序打乱，然后依次抽取打乱后的红包
    public static void preGetRed(int[] redpack){
        // 如何打乱顺序？
        //按照顺序遍历的同时随机生成索引值，将这两个数据进行交换
        Random ran = new Random();
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i< redpack.length; i++){
            int temp = redpack[i];
            int index = ran.nextInt(redpack.length);
            redpack[i] = redpack[index];
            redpack[index] = temp;
        }
        for(int i = 0; i< redpack.length; i++){
            System.out.print("请随机输入一个数字开始抽取红包:");
            scanner.nextInt();
            System.out.println("恭喜您！你抽中的红包金额为"+redpack[i]+"元\n");
        }
    }
}
