# INFO6205

Program Structures & Algorithms
Spring 2022
Assignment No. 3(WQUPC)

Name: 	Vamsi Krishna Poluru
(NUID):	002924538

•Task
Step 1:
(a) Implement height-weighted Quick Union with Path Compression. For this, you will flesh out the class UF_HWQUPC. All you have to do is to fill in the sections marked with // TO BE IMPLEMENTED ... // ...END IMPLEMENTATION.
(b) Check that the unit tests for this class all work. You must show "green" test results in your submission (screenshot is OK). 
Step 2:
Using your implementation of UF_HWQUPC, develop a UF ("union-find") client that takes an integer value n from the command line to determine the number of "sites." Then generates random pairs of integers between 0 and n-1, calling connected() to determine if they are connected and union() if not. Loop until all sites are connected then print the number of connections generated. Package your program as a static method count() that takes n as the argument and returns the number of connections; and a main() that takes n from the command line, calls count() and prints the returned value. If you prefer, you can create a main program that doesn't require any input and runs the experiment for a fixed set of n values. Show evidence of your run(s).
Step 3:
Determine the relationship between the number of objects (n) and the number of pairs (m) generated to accomplish this (i.e. to reduce the number of components from n to 1). Justify your conclusion in terms of your observations and what you think might be going on.





Solution file code:
 HWQUPC_SOLUTION.Java

package edu.neu.coe.info6205.union_find;

import java.util.*;

public class HWQUPC_Solution {

    public static void main(String[] args)
    {
        int[] testdata=new int[50];
        int numberOfRuns=200,out=0;
        
        Random random = new Random();
        
        for(int i=0; i<testdata.length;i++) testdata[i]=random.nextInt(20,200);
        
        for(int i=0;i<testdata.length;i++) 
        {
            out=0;
            for (int j = 0; j < numberOfRuns; j++) 
            {
                out += count(testdata[i]);
            }
            
            System.out.println(testdata[i]+" "+out / numberOfRuns);
        }
    }
   
   
    public static int count(int i)
    {
        int randomPairsGenerated=0;
        UF_HWQUPC unionfind=new UF_HWQUPC(i,true);
        Random random= new Random();
        while(unionfind.components()>1)
        {
            int a= random.nextInt(0,i);
            int b= random.nextInt(0,i);
            randomPairsGenerated++;
            if(!unionfind.isConnected(a,b)){
                unionfind.union(a,b);
            }
        }
        //System.out.println("number of connects"+unions);
        return randomPairsGenerated;
    }
}


UF_HWQUPC.Java
Methods to be filled are filled and present below.


public int find(int p) {
    validate(p);
    int root = p;
    while(root!=parent[root]){
        if(pathCompression)doPathCompression(root);
        root=parent[root];
    }

    return root;
}

private void mergeComponents(int i, int j) {
    if(height[i]<height[j]) {
        updateParent(i,j);
        updateHeight(j, i);
    }
    else {
        updateParent(j,i);
        updateHeight(i, j);
    }
}

private void doPathCompression(int i) {
    parent[i]=parent[parent[i]];
}
 





•Relationship Conclusion 
Have filled the methods and created a main method and static count method to execute the test scenarios mentioned in the problem statement on UF_HWQUPC.Java. Have created an array of size 50 with random numbers ranging from 50 to 5000 if you get a home and each of the 50 random numbers are ran for 200 times and mean is calculated for all the runs. By plotting the mean vs number of random elements needed to make the whole set connected we will be seeing that the graph plotted below looks somewhere between  Linear and Linearithmic. As the number of elements increase so does the number of a random elements required is increasing proportionally.

The values of the number of randomly generated sets are almost equal to half of the number of elements times the logarithmic of number of elements.
M= C*N logN 		where C is constant and most probably its ½
So, 
M= (1/2)* N*log N

 


•Unit tests result
Unit test output
 



Test data generated
1310	5140
2381	9978
2704	11493
838	3075
612	2119
2645	11282
2852	12498
3776	16654
4160	18635
1412	5516
2296	9746
2645	11110
1396	5434
322	1010
4688	21489
1479	5761
940	3509
2904	12336
4714	20910
1717	6852
2780	11693
2504	10583
1470	5832
576	1957
3775	16716
3253	14325
4327	19081
1899	7769
1187	4632
2773	11930
2786	12004
80	203
1741	7080
2217	8987
3395	14839
2816	12032
533	1812
3586	15542
1539	6084
80	198
2245	9231
1829	7295
4776	21693
3416	14913
3440	14845
737	2598
1290	4991
2085	8605
493	1675
3756	16219

