package FlightFor2020.Leetcode;

import java.util.LinkedList;

public class Leetcode_224 {
    public int calculate(String s) {
        LinkedList<Boolean> stack = new LinkedList<>();
        int result = 0, opr = 0; //result: ��ǰ�Ľ��ֵ; opr: ��ǰ�ı���/������
        Character op = null; //��ǰҪִ�е������
        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                if (op == null) {
                    //������һ�������ʱ����result��Ϊopr������һ���������ߵ����֣�
                    result = opr;
                } else {
                    //result = result +/- opr;
                    result = cal(op, result, opr);
                }
                //����ջ��Ԫ�ؾ����Ƿ�ת�����
                op = swap(stack.peek() == null ? false : stack.peek(), c);
                opr = 0;
            } else if (c == '(') {
                stack.push(op != null && op == '-');
            } else if (c == ')') {
                stack.pop();
            } else if (c != ' ') {
                opr = opr * 10 + c - '0';
            }
        }
        if (op == null) {
            //��ʽ��û�������ʱ��opr�������ս��
            return opr;
        } else {
            //����result��opr������ʽ�����ұߵ����֣�ִ��һ������
            return cal(op, result, opr);
        }
    }

    char swap(boolean swap, char c) {
        if (swap) {
            return c == '+' ? '-' : '+';
        } else {
            return c;
        }
    }

    private int cal(char op, int opr1, int opr2) {
        switch (op) {
            case '+':
                return opr1 + opr2;
            case '-':
                return opr1 - opr2;
            default:
                return 0;
        }
    }

}
