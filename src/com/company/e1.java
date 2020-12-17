package com.company;

import java.util.Scanner;

public class e1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingres el valor de k");
        long k = scanner.nextLong();
        long limite = (2*k) -1;
        long suma = 0;
        for (int i = 1; i <= limite ; i++) {

            if(i%2!=0){
                System.out.print(i+" ");
                suma+=i;
            }
        }
        System.out.println(suma);
    }
}
