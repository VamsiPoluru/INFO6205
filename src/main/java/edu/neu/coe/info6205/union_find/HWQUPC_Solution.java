package edu.neu.coe.info6205.union_find;

import java.util.*;

public class HWQUPC_Solution {

    static int randomPairsGenerated=0;
    public static void main(String[] args)
    {
        int[] testdata=new int[50];
        int numberOfRuns=200,out=0;

        for(int i=0;i<testdata.length;i++)
            testdata[i]=i*10000;

        System.out.println("Number of Elements\t"+"Number of Randomly Generated Pairs");
        for(int i=1;i<testdata.length;i++)
        {
            randomPairsGenerated=0;
            for (int j = 0; j < numberOfRuns; j++)
            {
                out = count(testdata[i]);
            }

            System.out.println("Number of elements: "+testdata[i]+", Number of Connections needed are "+out + " and Number of the pairs: "+(randomPairsGenerated / numberOfRuns));
        }
    }


    public static int count(int i)
    {
        int connectionCount=0;
        UF_HWQUPC unionfind=new UF_HWQUPC(i,true);
        Random random= new Random();
        while(unionfind.components()>1)
        {
            int a= random.nextInt(0,i);
            int b= random.nextInt(0,i);
            randomPairsGenerated++;
            if(!unionfind.isConnected(a,b)){
                unionfind.union(a,b);
                connectionCount++;
            }
        }
        return connectionCount;
    }
}



