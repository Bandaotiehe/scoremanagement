package main;

import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        //int Wifi=123456;
        //for(int i=0; ;i++){
        //    System.out.println("�ƽ���"+i);
        //    if(i==Wifi){
        //        System.out.println("�ƽ�ɹ�");
        //        break;
        //    }
        //}
        //Runtime.getRuntime().exec("msg/server:localhost * "+"helloword");



        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        System.out.println("ʹ�����й��߰�:");
        System.out.println("���߰���ʾ:1.�򿪼��±�   2.�ػ�   3.�ӳٹػ�   4.�򿪼�����");
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
