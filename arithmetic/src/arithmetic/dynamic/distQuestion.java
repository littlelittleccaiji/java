package arithmetic.dynamic;

import com.sun.xml.internal.xsom.XSTerm;

import java.util.HashMap;
import java.util.Map;

public class distQuestion {

    static private int[][] matrix =
            {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};
    static int minDist=0;
    static int[][] baseData=new int[4][4];
    public static void main(String[] args) {
//       backDate(0,0,0);
//       System.out.println(minDist);
        System.out.println(states());
//        baseData[0][0]=1;
//        System.out.println(equation(3,3));
    }

    public static void backDate(int rightIndex,int downIndex,int dist){
        dist+=matrix[rightIndex][downIndex];
        if(rightIndex==matrix.length-1&&downIndex==matrix.length-1){
            if(minDist==0){
                minDist=dist;
            }
            if(dist<minDist&&minDist>0){
                minDist=dist;
            }
            return;
        }
        if(rightIndex< matrix.length-1){
            backDate(rightIndex+1,downIndex,dist);
        }
        if(downIndex< matrix.length-1){
            backDate(rightIndex,downIndex+1,dist);
        }
    }

    public static int states(){
        int[][]states=new int[matrix.length][matrix.length];
        states[0][0]=matrix[0][0];
        for (int rightIndex=1;rightIndex< matrix.length;rightIndex++){
            states[rightIndex][0]=states[rightIndex-1][0]+matrix[rightIndex][0];
        }
        for (int dowmIndex=1;dowmIndex< matrix.length;dowmIndex++){
            states[0][dowmIndex]=states[0][dowmIndex-1]+matrix[0][dowmIndex];
        }
        for (int i=1;i< matrix.length;i++){
            for (int j=1;j< matrix.length;j++){
                states[i][j]=matrix[i][j]+Math.min(states[i-1][j],states[i][j-1]);
            }
        }
       return states[matrix.length-1][matrix.length-1];
    }

    public static int equation(int rightIndex,int downIndex){
        if(baseData[rightIndex][downIndex]>0){
            return baseData[rightIndex][downIndex];
        }
        if(rightIndex>1&&downIndex>1){
           return matrix[rightIndex][downIndex]+Math.min(equation(rightIndex-1,downIndex),equation(rightIndex,downIndex-1));
        }
        int minRight=0;
        if(rightIndex>=1){
            minRight=equation(rightIndex-1,downIndex);
        }else {
            for(int i=0;i<downIndex;i++){
                minRight+=matrix[0][i];
            }
        }
        int minDown=0;
        if(downIndex>=1){
            minDown=equation(rightIndex,downIndex-1);
        }else {
            for(int i=0;i<rightIndex;i++){
                minDown+=matrix[i][0];
            }
        }
        baseData[rightIndex][downIndex]=matrix[rightIndex][downIndex]+Math.min(minRight,minDown);

        return baseData[rightIndex][downIndex];
    }
}
