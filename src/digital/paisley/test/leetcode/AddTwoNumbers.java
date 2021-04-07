package digital.paisley.test.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var l1i = calcInt(l1);
        var l2i = calcInt(l2);
        var sum = l1i.add(l2i);
        ListNode l3 = new ListNode();
        var temp = l3;
        String sum_str = sum.toString();
        for (int i = 0; i < sum_str.length(); i++) {
            temp.val = Character.getNumericValue(sum_str.charAt(sum_str.length() - i - 1));
            if (i < sum_str.length() - 1) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return l3;
    }

    private BigInteger calcInt(ListNode l1) {
        StringBuilder builder = new StringBuilder();
        var pointer = l1;
        while (pointer != null) {
            builder.append(pointer.val);
            pointer = pointer.next;
        }
        return new BigInteger(builder.reverse().toString());
    }

    @Test
    void test() {
        var l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        var l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Assertions.assertEquals("[7, 0, 8]", addTwoNumbers(l1, l2).toString());

        l1 = new ListNode(9);

        l2 = new ListNode(1);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);

        Assertions.assertEquals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1]", addTwoNumbers(l1, l2).toString());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        var temp = this;
        while (temp != null) {
            builder.append(temp.val);
            builder.append(", ");
            temp = temp.next;
        }
        int i = builder.lastIndexOf(", ");
        if (i != -1)
            builder.replace(i, i + 2, "");
        builder.append(']');
        return builder.toString();
    }
}
