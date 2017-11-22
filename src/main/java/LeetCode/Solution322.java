

package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution322 {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<strs.size();i++){
            sb.append(strs.get(i).length());
            sb.append("#");
            sb.append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str){
        List<String> ls = new ArrayList<>();
        int start = 0;
        while(start < str.length()){
            int index = str.indexOf("#", start);
            System.out.println("index:"+index);
            int num = Integer.parseInt(str.substring(start, index));
            ls.add(str.substring(index+1, index+num+1));
            System.out.println(str.substring(index+1, index+num+1));
            System.out.println(str.substring(index+1, index+num+1).length());
            start = index+num+1;
            System.out.println(start);
        }
        return ls;
    }
       public static void main(String[] args) {

            Solution322 solution322 = new Solution322();
            List<String> res = new ArrayList<>();
            res.add("123");
            res.add("456");
            String strr = solution322.encode(res);
           System.out.println(strr);
           System.out.println(solution322.decode(strr));
       }


}
