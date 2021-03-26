package arithmetic.dynamic;

public class bagValueQuestion {
    static private int maxW = 9; // 结果放到maxV中
    static private int[] weight = {2, 2, 4, 6, 3}; // 物品的重量
    static private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    static private int n = 5; // 物品个数
    static private int w = 9; // 背包承受的最大重量
    static private int currentWeight = 0;

    public static void main(String[] args) {
//        f(0, 0, 0);
        System.out.println(state3(weight,value,n,w));
    }


    public static void f(int i, int cw, int cv) { // 调用f(0, 0, 0)
        if (cw == w || i == n) { // cw==w表示装满了,i==n表示物品都考察完了
            System.out.println("weight:" + cw);
            System.out.println("value:" + cv);
            return;
        }
        f(i + 1, cw, cv); // 选择不装第i个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], cv + value[i]); // 选择装第i个物品
        }
    }

    public static void getMaxValue(int index) {
        if (currentWeight == maxW || index == n) {
            System.out.println();
            return;
        }
    }

    public static int state3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第i个物品
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }


}
