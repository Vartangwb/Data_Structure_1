package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution_ShortWordDis {

    int shortestDis(String[] words, String word1, String word2){
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < words.length; i++){
            if(word1.equals(words[i])){
                p1 = i;
            }else if(word2.equals(words[i])){
                p2 = i;
            }
            if(p1!=-1 && p2!=-1){
                res = Math.min(p1 - p2, res);
            }

        }
        return res;
    }


    int shortestDis1(String[] words, String word1, String word2){
        int p1 = -1;
        int p2 = -1;
        int res = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            for(int i = 0;i < words.length; i++){
                if(word1.equals(words[i])){
                    p2 = p1;
                    p1 = i;
                }
                if(p1!=-1 && p2!=-1){
                    res = Math.min(p1 - p2, res);
                }

            }
        }
        else
        for(int i = 0;i < words.length; i++){
            if(word1.equals(words[i])){
                p1 = i;
            }else if(word2.equals(words[i])){
                p2 = i;
            }
            if(p1!=-1 && p2!=-1){
                res = Math.min(p1 - p2, res);
            }

        }
        return res;
    }


}
