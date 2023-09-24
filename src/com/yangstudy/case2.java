package com.yangstudy;

import java.util.Random;

//开发验证码
public class case2 {
    public static void main(String[] args) {
        System.out.println("随机生成的验证码是:" + createCode(10));
        System.out.println("随机生成的验证码是:" + createCode(5));
    }

    public static String createCode(int n){

        Random random = new Random();
        String code ="";
        for(int i = 0;i < n;i++){
            //思路：每位随机生成的字符，可以是数字、大小写字母，随机判断应该生成哪一种字符
            int type = random.nextInt(3);// 0 1 2
            switch (type){
                case 0:
                    // 随机生成数字
                    code += random.nextInt(10);
                    break;
                case 1:
                    //随机生成大写字母 A 65 -Z 65+25
                    //数据类型转换
                    char c1 = (char) (random.nextInt(26) + 65);
                    code += c1;
                    break;
                case 2:
                    //随机生成小写字母 a 97 - z 97+25
                    char c2 = (char) (random.nextInt(26) + 97);//数据类型转换
                    code += c2;
                    break;
            }
        }
        return code;
    }
}
