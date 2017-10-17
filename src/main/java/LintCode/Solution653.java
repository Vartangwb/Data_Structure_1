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
        // 如果计算结果等于目标值，且所有数都用完了，则是有效结果
        if (currRes == target && num.length() == 0) {
            String exp = new String(tmp);
            System.out.println(tmp);
            System.out.println(exp);
            res.add(exp);
            System.out.println(res);
            return;
        }
        // 搜索所有可能的拆分情况
        for (int i = 1; i <= num.length(); i++) {
            String currStr = num.substring(0, i);
            // 对于前导为0的数予以排除
            if (currStr.length() > 1 && currStr.charAt(0) == '0') {
                // 这里是return不是continue
                return;
            }
            // 得到当前截出的数
            long currNum = Long.parseLong(currStr);
            // 去掉当前的数，得到下一轮搜索用的字符串
            String next = num.substring(i);
            // 如果不是第一个字母时，可以加运算符，否则只加数字
            if (tmp.length() != 0) {
                // 乘法
                helper(next, target, tmp + "*" + currNum, (currRes - prevNum) + prevNum * currNum, prevNum * currNum);
                // 加法
                helper(next, target, tmp + "+" + currNum, currRes + currNum, currNum);
                // 减法
                helper(next, target, tmp + "-" + currNum, currRes - currNum, -currNum);
            } else {
                // 第一个数
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
