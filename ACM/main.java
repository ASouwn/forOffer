package ACM;

import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class main {

    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isHappy(int n) {
        Set<Integer> ansSet = new HashSet<>();
        ansSet.add(n);
        while (n != 1) {
            String nString = String.format("%d", n);
            int ans = 0;
            for (int i = 0; i < nString.length(); i++) {
                ans += Math.pow(nString.charAt(i) - '0', 2);
            }
            if (ansSet.contains(ans)) return false;
            ansSet.add(ans);
            n = ans;
        }
        return true;
    }
}