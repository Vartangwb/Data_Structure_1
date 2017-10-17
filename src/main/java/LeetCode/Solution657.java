package LeetCode;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-16 20:59
 **/
public class Solution657 {

    boolean judgeCircle(String moves) {
        int v = 0;
        int h = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U' : v++; break;
                case 'D' : v--; break;
                case 'R' : h++; break;
                case 'L' : h--; break;
            }
        }
        return v == 0 && h == 0;
    }



}
