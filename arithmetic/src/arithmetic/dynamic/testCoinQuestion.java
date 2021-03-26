package arithmetic.dynamic;

public class testCoinQuestion {

    static int num=9;
    static int[]coins={1,2,5};
    static int time=9;
    public static void main(String[] args) {
        getMin(0,num);
    }
    public static void getMin(int time,int num){
        int currentNum=0;
        if(currentNum>=num){
            System.out.println(time);
            return ;
        }
        for (int i=0;i<coins.length;i++){
            if(coins[time%3]<=(num-currentNum)){
                currentNum+=coins[i];
                getMin(i+1,num);
            }
        }
    }
}
