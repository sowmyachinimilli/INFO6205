package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_Client {

    public static UF uf;
    public static int conn=0;
    public static int count(int x){
        conn=0;

        Random rn = new Random();

        while(uf.components()>1) {
            for(int i=0;i<x;i++) {
                int p = rn.nextInt(x);
                int q = rn.nextInt(x);
                conn++;
                if (!(uf.isConnected(p, q))) {
                    uf.union(p, q);
                }
            }
        }

        return conn;
    }
    public static void main(String args[]){
        Random rn=new Random();
        int n=rn.nextInt(10000);
        uf = new UF_HWQUPC(n);
        conn=count(n);
        System.out.println("Number of components: "+uf.components());
        System.out.println("Number of connections for size "+n+": "+conn);
        System.out.println("Number of pairs generated: "+(0.5)*n*Math.log(n));
    }
}
