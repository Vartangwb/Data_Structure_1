package LintCode;

import java.util.List;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-11 17:03
 **/
public class Solution653 {
    List<String> res;

    public List<String> addOperators(String num, int target) {
        helper(num, target, "", 0, 0);
        return res;
    }

    private void helper(String num, int target, String tmp, long currRes, long prevNum) {
        // �������������Ŀ��ֵ�����������������ˣ�������Ч���
        if (currRes == target && num.length() == 0) {
            String exp = new String(tmp);
            System.out.println(tmp);
            System.out.println(exp);
            res.add(exp);
            System.out.println(res);
            return;
        }
        // �������п��ܵĲ�����
        for (int i = 1; i <= num.length(); i++) {
            String currStr = num.substring(0, i);
            // ����ǰ��Ϊ0���������ų�
            if (currStr.length() > 1 && currStr.charAt(0) == '0') {
                // ������return����continue
                return;
            }
            // �õ���ǰ�س�����
            long currNum = Long.parseLong(currStr);
            // ȥ����ǰ�������õ���һ�������õ��ַ���
            String next = num.substring(i);
            // ������ǵ�һ����ĸʱ�����Լ������������ֻ������
            if (tmp.length() != 0) {
                // �˷�
                helper(next, target, tmp + "*" + currNum, (currRes - prevNum) + prevNum * currNum, prevNum * currNum);
                // �ӷ�
                helper(next, target, tmp + "+" + currNum, currRes + currNum, currNum);
                // ����
                helper(next, target, tmp + "-" + currNum, currRes - currNum, -currNum);
            } else {
                // ��һ����
                helper(next, target, currStr, currNum, currNum);
            }

        }
    }
    public void solve(String ss){
        ss = ss+"asdas";
    }

    public static void main(String[] args) {
        Solution653 solution653 = new Solution653();
        String sss = "das";
        solution653.solve(sss);
        System.out.println(sss);
        System.out.println(solution653.addOperators("123", 6));

    }

}
