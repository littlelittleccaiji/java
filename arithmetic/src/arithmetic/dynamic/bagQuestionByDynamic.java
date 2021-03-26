package arithmetic.dynamic;

public class bagQuestionByDynamic {
    static int maxW = 9;
    static int[] items = {2, 2, 4, 6, 3};
    static int currentWeight = 0;

    public static void main(String[] args) {
        int knapsack = states1(items, items.length, maxW);
        System.out.println(knapsack);
    }
    public static int states1(int[] items, int num, int maxW) {
        boolean[][] states = new boolean[num][maxW + 1];
        states[0][0] = true;
        if (items[0] <= maxW) {
            states[0][items[0]] = true;
        }
        for (int i = 1; i < items.length; i++) {
            for (int weight = 0; weight <= maxW; weight++) {
                if (states[i - 1][weight] == true) {
                    states[i][weight] = true;
                }
            }
            for (int weight = 0; weight <= maxW - items[i]; weight++) {
                if (states[i - 1][weight] == true) {
                    states[i][weight + items[i]] = true;
                }
            }
        }
        for (int i = maxW; i >= 0; i--) { // 输出结果
            if (states[num-1][i] == true) return i;
        }
        return 0;
    }
    public static int states2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值false
        states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j] == true) states[j + items[i]] = true;
            }
        }


        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }


    public static int wrongStates2(int[] items, int num, int maxW) {
        int[] states = new int[num + 1];
        if (items[0] < maxW) {
            states[0] = items[0];
        }
        for (int i = 0; i < num; i++) {
            for (int statesWeight = 0; statesWeight < i; statesWeight++) {
                if ((states[statesWeight] + items[i]) > states[i - 1] && (states[statesWeight] + items[i]) >= states[i] && states[statesWeight] + items[i] < maxW) {
                    states[i] = states[statesWeight] + items[i];
                } else {
                    states[i] = states[i - 1];
                }
            }
        }
        for (int i = states.length - 1; i > 0; i--) {
            if (states[i] > 0) {
                return states[i];
            }
        }
        return 0;
    }




}
