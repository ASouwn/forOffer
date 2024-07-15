# A:
~~~
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i< N; i++){
            nums[i] = in.nextInt();
        }
        in.close();

        for(int num: nums){
            fun(num);
        }
    }

    private static void fun(int num){
        for(int i = 0; i< num; i++){
            System.out.print(i+1 + " ");
        }
        System.out.println();

    }
}
~~~
# B:
~~~
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<int[][]> list = new ArrayList<>();
        for(int i = 0; i< N; i++){
            int l = in.nextInt();
            int w = in.nextInt();
            int[][] corner = new int[l][w];
            for(int times = 0; times < 2; times++){
                for(int j = 0; j < l; j++){
                    String nums = in.nextLine();
                    for(int k = 0; k < w; k++){
                        corner[j][k] = Integer.parseInt(nums.substring(k, k+1));
                    }
                }
                list.add(corner);
            }
        }
        in.close();
        while (!list.isEmpty()) {
            fun(list.remove(0), list.remove(1));
        }
    }

    private static void  fun(int[][] grid1, int[][] grid2){
        for(int i = 0; i < grid1.length - 1; i++){
            for(int j = 0; j < grid1[0].length - 1; j++){
                if(grid1[i][j] == grid2[i][j]) continue;
                int n = 0;
                while (grid1[i][j] != grid2[i][j]) {
                    n++;
                    grid1[i][j] += 1;
                    grid1[i][j] %= 3;
                }
                grid1[i+1][j-1] += n;
                grid1[i+1][j] += 2*n;
                grid1[i][j+1] += 2*n;
            }
        }
        for(int i = 0; i < grid1.length; i++){
            for(int j = 0; j < grid1[0].length; j++){
                if(grid1[i][j] != grid2[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }
}
~~~
# C:
~~~

~~~

