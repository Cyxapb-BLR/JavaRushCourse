package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[ip.length];    // размер массива адреса сети = размеру ip массива
        for (int i = 0; i < netAddress.length; i++) {
            //System.out.println(ip[i] + " " + mask[i]);
            netAddress[i] = (byte) (ip[i] & mask[i]);
            //System.out.println(netAddress[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {for(int i=0;i<bytes.length;i++){
        System.out.print(Integer.toBinaryString(bytes[i] & 255 | 256).substring(1) + " ");
    }
        System.out.println();
    }
}
