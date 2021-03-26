package arithmetic.recursion;

import java.util.HashMap;
import java.util.Map;

public class step {

    static Integer resultNum=0;
    static Map<Integer,Integer> a=new HashMap();
    public static void main(String[] args) {
        //爬楼梯
        Integer num=5;
        Integer step = getStep2(num);
        System.out.println(step);
        //桃子
//        getPeachNumber(1);
    };

    /**
     * 爬楼梯递归方式
     * @param num
     * @return
     */
    public static Integer getStep(Integer num){
        if(num==1)  {
            resultNum=1;
            a.put(num,1);
        }
        if(num==2) {
            resultNum=2;
            a.put(num,2);
        }
        if(num>=3){
            resultNum= (a.containsKey(num-1)?a.get(num-1):getStep(num-1))+(a.containsKey(num-2)?a.get(num-2):getStep(num-2));
            a.put(num,resultNum);
        }
        return resultNum;
    }

    /**
     * 爬楼梯非递归方式
     * @param num
     * @return
     */
    public static Integer getStep2(Integer num){
        if(num<=2){
            return num;
        }
        int result=0;
        int pre=0;
        int prePre=0;
        for (int i=1;i<num;i++){
            result=prePre+pre;
            pre=result;
        }
        return result;
    }

    public static int getPeachNumber(int n){
        int num;    //定义所剩桃子数
        if(n==10)
        {
            return 1;
        }
        else
        {
            num = (getPeachNumber(n+1)+1)*2;   //这里是不应该用递归呢？
            System.out.println("第"+n+"天所剩桃子"+num+"个"); //天数，所剩桃子个数
        }
        return num;
    }
}
