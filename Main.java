import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [][] nums = new int[n][];
        for(int i = 0; i < n; i++){
            nums[i] = new int[in.nextInt()];
            for(int j = 0; j < nums[i].length; j++) nums[i][j] = in.nextInt();
        }

        fun(nums, n);
    }

    private static void fun(int[] nums, double p){
        int length = nums.length;
        int[] times = new int[Integer.MAX_VALUE];
        int maxNum = 0;
        for(int n: nums) {
            times[n] ++;
            maxNum = maxNum > n? maxNum: n;
        }
        int ans = 0;
        for(int n: nums) {
            while (ans / length < p) {
                ans += times[maxNum--];
            }
            times[n]--;
            length--;
        }
        System.out.println(maxNum);
    }

}