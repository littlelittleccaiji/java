package arithmetic.dynamic;

public class testBagQuestion {
    static int weights[]={2,2,4,6,3};
    static int maxW=9;
    static int[]indexs=new int[5];
    public static void main(String[] args) {
//        backDate(0,0,indexs);
//        System.out.println(states());
        System.out.println(states2());
    }


    public static void backDate(int index,int currentWeight,int[] idnexs){
        if(currentWeight==maxW||index==weights.length){
            if(currentWeight==maxW){
                for (int i=0;i<indexs.length;i++){
                    System.out.print(indexs[i]);
                }
                System.out.println(" ");
            }
            return;
        }
        indexs[index]=0;
        backDate(index+1,currentWeight,indexs);
        if(currentWeight+weights[index]<=maxW){
//            System.out.println(currentWeight);
            indexs[index]=1;
            backDate(index+1,currentWeight+weights[index],indexs);
        }
    }
    public static int states(){
       boolean[][] states=new boolean[weights.length][maxW+1];
        states[0][0]=true;
        states[0][weights[0]]=true;
       for (int i=1;i< weights.length;i++){
            for(int weight=1;weight<maxW+1;weight++){
                if(states[i-1][weight]==true){
                    states[i][weight]=true;
                }
                if(states[i-1][weight]==true&&weights[i]<=maxW-weight){
                    states[i][weight+weights[i]]=true;
                }
            }
       }
       for (int i=0;i<states.length;i++){
            if(states[i][maxW]){
                return maxW;
            }
       }
       return -1;
    }
    public static int states2(){
        int[]states=new int[maxW+1];
        states[0]=1;
        states[weights[0]]=1;
        for (int i=1;i<weights.length;i++){
            for (int state=states.length;state>0;state--){
                if(weights[i]+state<=maxW&&states[state]==1){
                    states[state+weights[i]]=1;
                }
            }
        }
        for (int state=states.length-1;state>0;state--){
                if(states[state]==1){
                    return state;
                }
        }
        return -1;
    }
}
