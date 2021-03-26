package arithmetic.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class hanNuo {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList();
        List<Integer> B = new ArrayList();
        List<Integer> C = new ArrayList();
        for (int i = 0; i < 6; i++) {
            A.add(i);
        }
        hanota2(A, B, C);
        System.out.println(C.toString());
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    private static void movePlate(int num, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (num == 1) {    // 只剩一个盘子时，直接移动即可
            C.add(A.remove(A.size() - 1));
            return;
        }
        movePlate(num - 1, A, C, B);   // 将 size-1 个盘子，从 original 移动到 auxiliary
        C.add(A.remove(A.size() - 1));   // 将 第size个盘子，从 original 移动到 target
        movePlate(num - 1, B, A, C);   // 将 size-1 个盘子，从 auxiliary 移动到 target
    }

    public static void hanota2(List<Integer> from, List<Integer> tmp, List<Integer> to) {
        Stack<Record> stack = new Stack<Record>();
        Record r = new Record(from, tmp, to, from.size());
        stack.push(r);

        while (!stack.isEmpty()) {
            Record peek = stack.pop();
            // peek.print();
            if (peek.canDo()) {
                peek.to.add(peek.getFromTopAndRemove());
                if (!stack.isEmpty()) {
                    stack.peek().isStepOneDone = true;
                }
            } else {
                if (peek.isStepOneDone) {
                    //把from上的顶转移到to
                    peek.to.add(peek.getFromTopAndRemove());
                    stack.push(new Record(peek.tmp, peek.from, peek.to, peek.height - 1));
                } else {
                    stack.push(peek);
                    stack.push(new Record(peek.from, peek.to, peek.tmp, peek.height - 1));
                }
            }
        }
    }

    ;

    static class Record {
        boolean isStepOneDone = false;
        int height = 0;
        List<Integer> from;
        List<Integer> to;
        List<Integer> tmp;

        public Record(List<Integer> from, List<Integer> tmp, List<Integer> to, int height) {
            this.height = height;
            this.from = from;
            this.tmp = tmp;
            this.to = to;
        }

        boolean canDo() {
            return this.height == 1;
        }

        Integer getFromTopAndRemove() {
            return this.from.remove(this.from.size() - 1);
        }

        void print() {
            System.out.println("from = " + from);
            System.out.println("to = " + to);
            System.out.println("tmp = " + tmp);
            System.out.println(this.isStepOneDone + "-----------" + this.height);
        }
    }


}
