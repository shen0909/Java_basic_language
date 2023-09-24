package com.yangstudy;

import java.util.Scanner;

//评委打分
public class case3 {
    public static void main(String[] args) {
//        int[] score = {90,87,89,100,67};
        System.out.println("当前选手的平均分为:"+getScore(5));
        //优化后的代码
        System.out.println("优化后，选手得分为:"+previewGetScore(5));
    }

    // 评委人数，分数
    public static double getScore(int n){
        Scanner scanner = new Scanner(System.in);
        double code = 0;
        int[] score = new int[n];
        int max = 0,min =100;

        int i =0;
        System.out.println("————————————————————————————请输入评分————————————————————————————");
        while (true){
            System.out.print("请输入第" + (i + 1) + "位评委的评分：");
            int num = scanner.nextInt();
            // 判断分数越界
            if(num >100 || num < 0){
                System.out.println("评分范围错误，请重新输入");
                continue;
            }
            else{
                score[i] = num;
                System.out.print("第" + (i + 1) + "位评委的评分为:"+score[i]+"\n");
                if(max <= score[i]){
                    max = score[i];
                }
                if(min >= score[i]){
                    min = score[i];
                }
                i++;
                if(i == n){
                    break;
                }
            }
        }
        /*for(int i =0;i<n;i++){
            System.out.println("请"+(i+1)+"号评委评分");
            if(scanner.nextInt() >100 || scanner.nextInt() < 0){
                scanner.nextInt();
            }
            score[i] = scanner.nextInt();
            if(max <= score[i]){
                max = score[i];
            }
            if(min >= score[i]){
                min = score[i];
            }
            System.out.println(score[i]);
        }*/
        System.out.println("最大值："+max+"\t" +"最小值:"+min);
        for(int j =0;j<n;j++){
            code +=score[j];
        }
        code =(code - max - min)/n;
        return code;
    }

    //评委打分-优化
    public  static double previewGetScore(int peopleNum){
        double avgScore = 0;
        Scanner s = new Scanner(System.in);
        int max = 0,min =100;

        for(int i = 0;i < peopleNum;i++){
            int num = s.nextInt();
            if( num < 0 || num >100){
                System.out.println("评分范围错误，请重新输入");
                i--;
                continue;
            }
            System.out.print("第" + (i + 1) + "位评委的评分为:"+num+"\n");
            avgScore += num;

            if(max <= num){
                max = num;
            }
            if(min >= num){
                min = num;
            }
        }
        System.out.println("最大值："+max+"\t" +"最小值:"+min);

        return (avgScore-max-min)/(peopleNum-2);
    }
}
