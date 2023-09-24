package com.yangstudy;

//案例一：买飞机票
public class case1 {
    public static void main(String[] args) {
        System.out.println("当前用户机票的优惠价："+calPrice(1000, 6, "头等舱"));
        System.out.println("当前用户机票的优惠价："+calPrice(1000, 6, "经济舱"));
        System.out.println("当前用户机票的优惠价："+calPrice(100, 12, "头等舱"));
    }

    public static double calPrice(double prices,int month,String seatType){
        //如果月份处于旺季
        if(month>=5 && month<=10){
            System.out.println("当前处于旺季");
            switch (seatType){
                case "头等舱":
                    prices *= 0.9;
                    break;
                case "经济舱":
                    prices *= 0.85;
                    break;
                default:
                    System.out.println("机票类型输入错误");
            }
        }
        else{
            System.out.println("当前处于淡季");
            switch (seatType){
                case "头等舱":
                    prices *= 0.7;
                    break;
                case "经济舱":
                    prices *=0.65;
                    break;
                default:
                    System.out.println("机票类型输入错误");
            }
        }

        return prices;
    }
}
