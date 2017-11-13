
package LeetCode;

import java.util.List;
import java.util.Stack;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-10 14:46
 **/
public class Solution385 {

    public class NestedInteger implements NestedList{

        public NestedInteger(int ss){

        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public void setInteger(int value) {

        }

        @Override
        public void add(NestedList ni) {

        }

        @Override
        public List<NestedList> getList() {
            return null;
        }
    }
    public NestedInteger deserialize(String s){
        Stack<NestedInteger> stc = new Stack<>();
        String tmpStr = "";
        for(int i = 0;i<s.length();i++){
            char tmp = s.charAt(i);
            switch (tmp){
                case '[':
                    stc.push(new NestedInteger(0));
                    break;
                case ',':
                    if(!tmpStr.equals("")){
                        stc.peek().add(new NestedInteger(Integer.parseInt(tmpStr)));
                    }
                    break;
                case ']':
                    if(!tmpStr.equals("")){
                        stc.peek().add(new NestedInteger(Integer.parseInt(tmpStr)));
                    }
                    NestedInteger ni = stc.pop();
                    tmpStr = "";
                    if(!stc.isEmpty()){
                        stc.peek().add(ni);
                    }else{
                        return ni;
                    }
                    break;
                default:
                    tmpStr+=tmp;
            }
        }
        if(tmpStr.equals("")){
            return new NestedInteger(Integer.parseInt(tmpStr));
        }
        return null;
    }

    public static void main(String[] args) {
        Solution385 solution228 = new Solution385();

    }

}
