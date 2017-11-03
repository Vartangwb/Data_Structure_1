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
     * ��arr[2-3] = arr[7-8]
     * ��arr[0-1] = arr[7-8]
     * �����ֱ���ж�T[9] �� T[2]�Ƿ����
     */
    int[] next(String p){
        int len = p.length();
        char arr[] = p.toCharArray();
        int j = 1;//��׺������ //aware��j���ȡ����ǰ�ַ���ǰһ���ַ�������jС��sizeChar
        int i = 0;//ǰ׺������

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
