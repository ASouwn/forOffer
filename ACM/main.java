package ACM;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class main {

    public static void main(String[] args) {

    }

    
    public int minimumTotal(List<List<Integer>> triangle) {
        Queue<Integer> queue = new LinkedList<>();
        for (List<Integer> list : triangle) {
            if (list.size() == 1) {
                queue.add(list.get(0));
                continue;
            }
            for (int num : list) {
                
            }
        }
    }
}