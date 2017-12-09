package Algors;

import java.util.Stack;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-12-07 16:17
 **/
public class BasicCal {

    public int basicCal(String s){
        Stack<Integer> stc = new Stack<>();
        s.replaceAll(" ", "");
        int sign = 1;
        int res = 0;
        int i = 0;
        int len = s.length();
        while(i < s.length()){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                int num = c-'0';
                i++;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    num = num*10+(s.charAt(i)-'0');
                    i++;
                }
                res += num*sign;
            }else if(c == '+'){
                sign = 1;
                i++;
            }else if(c == '-'){
                sign = -1;
                i++;
            }else if(c == '('){
                stc.push(res);
                res = 0;
                stc.push(sign);
                sign = 1;
                i++;
            }else if(c == ')'){
                res = stc.pop()*res+stc.pop();
                sign = 1;
                i++;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        BasicCal basicCal = new BasicCal();
        System.out.println(basicCal.basicCal("(1+(4+5+2)-3)+(6+8)"));
    }
}
