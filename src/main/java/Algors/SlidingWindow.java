package Algors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-30 16:35
 **/
public class SlidingWindow {

    public String minWindowSubStr(String s, String t){
        int len1 = s.length();
        int len2 = t.length();
        Map<Character, Integer> mapt = new HashMap<>();
        Map<Character, Integer> maps = new HashMap<>();
        for(Character c :t.toCharArray()){
            if(mapt.containsKey(c)){
                mapt.put(c, mapt.get(c)+1);
            }else{
                mapt.put(c, 1);
            }
        }
        System.out.println(mapt);
        int count = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        for(int right = 0; right<len1;right++){
            char c = s.charAt(right);
            if(mapt.containsKey(c)) {
                if (maps.containsKey(c) == false) {
                    maps.put(c, 1);
                    count++;
                } else {
                    maps.put(c, maps.get(c) + 1);
                    if (maps.get(c) <= mapt.get(c)) {
                        count++;
                    }
                }
                System.out.println(maps);
                while(count==t.length()){
                    min = Math.min(min, right-left+1);
                    if(mapt.containsKey(s.charAt(left))){
                        maps.put(s.charAt(left), maps.get(s.charAt(left))-1);
                        if(maps.get(s.charAt(left))<mapt.get(s.charAt(left))){
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        System.out.println(min);
        return null;

    }
    public String minWindow(String S, String T) {
        if(S==null || S.length()==0)
            return "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<T.length();i++)
        {
            if(map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            }
            else
            {
                map.put(T.charAt(i),1);
            }
        }
        int left = 0;
        int count = 0;
        int minLen = S.length()+1;
        int minStart = 0;
        for(int right=0; right<S.length();right++)
        {
            if(map.containsKey(S.charAt(right)))
            {
                map.put(S.charAt(right),map.get(S.charAt(right))-1);
                if(map.get(S.charAt(right))>=0)
                {
                    count++;
                }
                while(count == T.length())
                {
                    if(right-left+1<minLen)
                    {
                        minLen = right-left+1;
                        minStart = left;
                    }
                    if(map.containsKey(S.charAt(left)))
                    {
                        map.put(S.charAt(left), map.get(S.charAt(left))+1);
                        if(map.get(S.charAt(left))>0)
                        {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen>S.length())
        {
            return "";
        }
        return S.substring(minStart,minStart+minLen);
    }

    public int longestSubString(String s){
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        for(right=0;right<s.length();right++){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                map.put(c, 1);
                max = Math.max(max, right-left+1);
            }else{
                while(s.charAt(left)!=c) {
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
        }
        return max;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String ,Integer> map = new HashMap<>();
        for(int i = 0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i])+1);
            }else{
                map.put(words[i], 1);
            }
        }
        for(int i = 0; i<words[0].length();i++){
            Map<String, Integer> currMap = new HashMap<>();
            int count = 0;
            int left = i;
            for(int right = i;right<=s.length()-words[0].length();right+=words[0].length()){
                System.out.println("currRight:"+right);
                String ss = s.substring(right, right+words[0].length());
                if(map.containsKey(ss)){
                    if(!currMap.containsKey(ss)){
                        currMap.put(ss, 1);
                        count++;
                    }else{
                        currMap.put(ss, currMap.get(ss)+1);
                        if(currMap.get(ss)<=map.get(ss)){
                            count++;
                        }else{

                        }
                    }
                    while(count==words.length){
                        res.add(left);
                        String tmp = s.substring(left, left+words[0].length());
                        if(currMap.get(tmp)>map.get(tmp)){
                            currMap.put(tmp, currMap.get(tmp)-1);
                        }else{
                            currMap.put(tmp, currMap.get(tmp)-1);
                            count--;
                        }
                        left+=words[0].length();
                        System.out.println("haha:"+left);
                    }
                }else{
                    currMap.clear();
                    count=0;
                    left=right+words[0].length();
                    System.out.println("left:"+left);
                    System.out.println(right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindow solution044 = new SlidingWindow();
        solution044.minWindowSubStr("ADOBECODEBANC", "ABC");
        System.out.println(solution044.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution044.longestSubString("pwwwkew"));
        System.out.println(solution044.findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}));
    }



}
