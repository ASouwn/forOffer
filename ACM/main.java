package ACM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class main {

    public static void main(String[] args) {
        
    }

    public int findNumberOfLIS(int[] nums) {
        int[] cnt = new int[nums.length];
        int[] dp = new int[nums.length];
        int indexMax = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j]) {
                        cnt[i] += cnt[j];
                    }
                    if (dp[i] < dp[j]) {
                        dp[i] = dp[j];
                        cnt[i] = cnt[j];
                    }
                }
            }
            dp[i] += 1;
            if (dp[i] > dp[indexMax]) {
                indexMax = i;
                ans = cnt[i];
            }
            if (dp[i] == dp[indexMax]) {
                ans += cnt[i];
            }
        }
        return ans;
    }
}