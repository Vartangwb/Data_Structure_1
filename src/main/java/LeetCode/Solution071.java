

package LeetCode;

import java.util.Stack;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution071 {


    public String simplifyPath(String path) {

        String strs[] = path.split("/");
        Stack<String> stc = new Stack<>();
        Stack<String> stc1 = new Stack<>();
        for(String str : strs){
            if(str.equals(".") || str.equals("")){
                continue;
            }else if(str.equals("..")){
                if(!stc.isEmpty()){
                    stc.pop();
                }
            }else{
                stc.add(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stc.isEmpty()){
            stc1.push(stc.pop());
        }
        while(!stc1.isEmpty()){
            sb.append("/"+stc1.pop());
        }
        if(sb.length()==0){
            sb.append("/");
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        Solution071 solution402 = new Solution071();
        System.out.println(solution402.simplifyPath("/home/.././bda"));
    }


}
