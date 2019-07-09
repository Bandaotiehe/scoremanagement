package main;

import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //int Wifi=123456;
        //for(int i=0; ;i++){
        //    System.out.println("破解中"+i);
        //    if(i==Wifi){
        //        System.out.println("破解成功");
        //        break;
        //    }
        //}
        //Runtime.getRuntime().exec("msg/server:localhost * "+"helloword");



        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        System.out.println("使用下列工具包:");
        System.out.println("工具包提示:1.打开记事本   2.关机   3.延迟关机   4.打开计算器");
        int a=sc.nextInt();
        if(a==1){
            Runtime.getRuntime().exec("notepad");
        }
        if(a==2){
            Runtime.getRuntime().exec("shutdown -s");
        }
        if(a==3){
            Runtime.getRuntime().exec("shutdown -s -t 60");
        }
        if(a==4){
            Runtime.getRuntime().exec("calc");
        }


    }



}
