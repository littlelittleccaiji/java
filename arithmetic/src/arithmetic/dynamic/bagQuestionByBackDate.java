package arithmetic.dynamic;

import java.util.ArrayList;
import java.util.List;

public class bagQuestionByBackDate {

    static int maxW = 9;
    static int[] items = {2, 2, 4, 6, 3};
    static int currentWeight = 0;
    static List<Integer> a=new ArrayList<>();
    public static void main(String[] args) {
//        f(0,currentWeight,items,items.length,maxW);
        getWeigths(0,currentWeight);
    }

    public static void f(int i, int currentWeight, int[] items, int n, int maxW) {
        if (currentWeight == maxW || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
//            if (currentWeight > maxW) maxW = currentWeight;
            System.out.println(currentWeight);
            return;
        }
        f(i + 1, currentWeight, items, n, maxW);
        if (currentWeight + items[i] <= maxW) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f(i + 1, currentWeight + items[i], items, n, maxW);
        }
    }

    public static void getWeigths(int i,int currentWeight){
        if(currentWeight>=maxW||i==items.length){
            System.out.println(currentWeight);
            return;
        }
        getWeigths(i+1,currentWeight);
        if(currentWeight+items[i]<=maxW){
            getWeigths(i+1,currentWeight+items[i]);
        }
    }
}
