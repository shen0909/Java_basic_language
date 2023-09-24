package com.yangstudy;

//数字加密
public class case4 {
    public static void main(String[] args) {
        System.out.println("加密后的结果是:"+encrypt(8346));
    }

//    既是加密、也是解密
    public static String encrypt(int numbers) {
        //将接收到的密码拆分成一个一个数字
        //1、直接对密码进行拆分
        //2、将拆分密码的代码封装成一个单独的方法   建议使用第二种方法
        int[] number = split(numbers);

        // 计算每个数字
        for (int i = 0; i < 4; i++) {
            number[i] = (number[i] + 5) % 10;
        }
        //反转数组
        return reverse(number);
    }

    public static String reverse(int[] number) {
        String code = "";
        /*for(int i = 0;i< (number.length/2); i++){
            int temp = number[i];
            number[i] = number[(number.length -1) -i ];
            number[(number.length -1) -i ] = temp;
        }*/
        // 另一种循环方法
        for( int i = 0,j = number.length -1; i < j ; i++,j--){
            int temp = number[i];
            number[i] = number[j];
            number[j] = temp;
        }
        // 怎么将整型数组转换成 字符串呢？
        for( int i = 0 ;i < number.length; i++){
            code += number[i];
        }

        return code;
    }

    //将整型数字拆分成一个一个数字放到int的数组中
    public static int[] split(int numbers) {

        //numbers = 1234
        int[] num = new int[4];
        //如何得到1？——————>1是千位
        num[0] = numbers / 1000;
        num[1] = ((numbers / 100)) % 10;
        num[2] = ((numbers / 10)) % 10;
        num[3] = numbers % 10;
        return num;
    }
}
