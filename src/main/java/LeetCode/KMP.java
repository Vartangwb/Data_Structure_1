package LeetCode;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-10-31 20:43
 **/
public class KMP {

    /**
     * next[4] = 2;
     * arr[0-1] = arr[2-3]
     * next[9] = 4;
     * arr[0-3] = arr[5-8]
     * 即arr[2-3] = arr[7-8]
     * 则arr[0-1] = arr[7-8]
     * 则可以直接判断T[9] 与 T[2]是否相等
     */
    int[] next(String p){
        int len = p.length();
        char arr[] = p.toCharArray();
        int j = 1;//后缀的索引 //aware中j最大取到当前字符的前一个字符，所以j小于sizeChar
        int i = 0;//前缀的索引

        int[] next = new int[len];
        while(j < len - 1){
            if(arr[i] == arr[j]){
                i++;
                j++;
                next[j] = i;
            }else{
                if(i == 0){
                    j++;
                    next[j] = 0;
                }else{
                    i = next[i];
                }
            }
        }
        for(int ii:next){
            System.out.println(ii);
        }
        return next;
    }

    public int kmp(String ts, String ps){

        if(ts == null || ps == null){
            return 0;
        }
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = next(ps);
        while(i<t.length && j<p.length){
            if(t[i] == p[j]){
                i++;
                j++;
            }else{
                if(j==0){
                    i++;
                }
                j = next[j];
            }
        }
        if(j == p.length){
            return i - j;
        }else
            return -1;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        kmp.next("ababababbb");
    }


}
