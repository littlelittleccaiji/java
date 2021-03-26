package arithmetic.dynamic;

public class testBagValueQuestion {

    static int weights[]={2,2,4,6,3};
    static int maxW=9;
    static private int[] values = {3, 4, 8, 9, 6};
    static int maxValue=0;
    public static void main(String[] args) {
        System.out.println(states());
    }
    public  static int states(){
        int[][]states=new int[weights.length][maxW+1];

        states[0][0]=0;
        if (weights[0] <= maxW) {
            states[0][weights[0]] = values[0];
        }
        for (int i=1;i<weights.length;i++){
            for (int j=0;j<=maxW;j++){
                states[i][j]=states[i-1][j];
            }
            for (int j=0;j<=maxW-weights[i];j++){
//                if(states[i-1][j]+values[i]>=states[i][j+weights[i]]){
//                    states[i][j+weights[i]]=states[i-1][j]+values[i];
//                    if( states[i][j+weights[i]]>maxValue){
//                        maxValue=states[i][j+weights[i]];
//                    }
//                }
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + values[i];
                    if (v > states[i][j + weights[i]]) {
                        states[i][j + weights[i]] = v;
                    }
                }
            }
        }
        for (int j = 0; j <= maxW; ++j) {
            if (states[weights.length - 1][j] > maxValue) maxValue = states[weights.length  - 1][j];
        }
        return maxValue;
    }
}
