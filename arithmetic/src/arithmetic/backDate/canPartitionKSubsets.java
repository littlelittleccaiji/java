package arithmetic.backDate;

import java.lang.reflect.Array;
import java.util.Arrays;

public class canPartitionKSubsets {

    static boolean can = false;
    static int[] nums = {3, 1, 1, 2, 4, 4};
    static int k = 3;
    static int num=0;
    static enum Result { TRUE, FALSE }
    public static void main(String[] args) {

        System.out.println(canPartitionKSubsets5(nums, k));
        System.out.println(100&10);
        System.out.println(32|8);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        // 注意nums[i] > 0
        int sum = 0, maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (maxNum < nums[i]) maxNum = nums[i];
        }
        if (sum % k != 0 || maxNum > sum / k) return false;
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, sum / k, 0, 0, used);
    }

    private static boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {
        // 返回条件
        if (k == 0) {
            return true;
        }
        if (cur == target) {
            // 构建下一个集合
            return backtracking(nums, k - 1, target, 0, 0, used);
        }
        for (int i = start; i < nums.length; i++) {
            if (!used[i] && cur + nums[i] <= target) {
                used[i] = true;
                if (backtracking(nums, k, target, cur + nums[i], i + 1, used)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        // memo 数组用来记录某个元素是否被使用过.
        boolean[] memo = new boolean[nums.length];
        return dfs(nums, k, sum / k, sum / k, 0, memo);
    }

    // dfs 思路: 顺着数组从前向后找, 先找到一组子集, 此时标记此子集的元素 memo[i] 为 true 表示被使用过, 然后再从前向后找下一组,
    // 如果子集组合方式不正确, 则开始回溯, 直到找到全部的子集, 或者不能成功的分成 k 个子集, 返回 false.
    // group 当前正在搜寻的组, rest 当前子集还需累加的余量, avg 每个子集元素的和, idx 从 nums 的第几个元素开始遍历, memo 记忆数组.
    public static boolean dfs(int[] nums, int group, int rest, int avg, int idx, boolean[] memo) {
        if (group == 0) return true;
        for (int i = idx; i < nums.length; i++) {
            if (!memo[i]) {
                memo[i] = true;
                // 当第 i 个元素小于余量 rest, 就更新余量, 并继续找本子集中其他的元素
                // 当第 i 个元素等于余量 rest, 就将余量置为 avg, 开始寻找下一个子集.
                if (nums[i] < rest && dfs(nums, group, rest - nums[i], avg, i + 1, memo) || nums[i] == rest && dfs(nums, group - 1, avg, avg, 0, memo)) {
                    return true;
                }
                memo[i] = false;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets4(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) return false;
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search2(new int[k], row, nums, target);
    }
    public boolean search2(int[] groups, int row, int[] nums, int target) {
        if (row < 0) return true;
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search2(groups, row, nums, target)) return true;
                groups[i] -= v;
            }
            if (groups[i] == 0) break;
        }
        return false;
    }
    //动态规划解法
    public boolean canPartitionKSubsets3(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) return false;

        Result[] memo = new Result[1 << nums.length];
        memo[(1 << nums.length) - 1] = Result.TRUE;
        return search(0, sum, memo, nums, sum / k);
    }

    boolean search(int used, int todo, Result[] memo, int[] nums, int target) {
        if (memo[used] == null) {
            memo[used] = Result.FALSE;
            int targ = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if ((((used >> i) & 1) == 0) && nums[i] <= targ) {
                    if (search(used | (1<<i), todo - nums[i], memo, nums, target)) {
                        memo[used] = Result.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Result.TRUE;
    }
    public static boolean canPartitionKSubsets5(int[]nums, int k) {
        int a=0;
        int n=nums.length;
        int sum=15;
        Arrays.sort(nums);
        int target=sum/k;
        boolean[] dp=new boolean[1<<n];
        dp[0]=true;
        int[] cur_sum=new int[1<<n];
        for(int state=0;state<(1<<n);++state){
            if(!dp[state])continue;
            for(int i=0;i<n;++i){
                if((state&(1<<i))>0){
                    continue;
                }
                int next=state|1<<i;
                if(dp[next]){
                    continue;
                }
                if(nums[i]+cur_sum[state]%target<=target){
                    dp[next]=true;
                    cur_sum[next]=cur_sum[state]+nums[i];
                    System.out.println(state+"  "+i+"  "+next);
                }
                else break;
            }
        }
        return dp[(1<<n)-1];
    }


}
