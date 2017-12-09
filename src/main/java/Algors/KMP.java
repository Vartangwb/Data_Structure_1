package Algors;

/**
 * DESCRIPTION TODO
 *
 * @author tangwenbo
 * @create 2017-11-28 19:01
 **/
public class KMP {

    public int[] getNext(String s){
        int[] next = new int[s.length()];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j<s.length()-1){
            if(k==-1 || s.charAt(j) == s.charAt(k)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        return next;
    }

    public int[] getNext1(String s){
        int[] next = new int[s.length()+1];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j<s.length()){
            if(k==-1 || s.charAt(j) == s.charAt(k)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        for(int ii:next){
            System.out.println(ii);
        }
        return next;
    }
    public String shortestPar(String s){
        if(s == "")
            return s;
        StringBuilder sb = new StringBuilder(s).reverse();
        String newS = s+sb.toString();
        int [] next = getNext1(newS);
        if(next[newS.length()] > s.length()){
            next[newS.length()] = next[newS.length()] + 1 - s.length();
        }
        StringBuilder pres = new StringBuilder(s.substring(next[newS.length()]));
        pres = pres.reverse();
        return pres.toString()+s;
    }

    public String kmp(String s, String p){
        if(s == null || p == null)
            return s;
        int[]next = getNext(s);
        int i = 0;
        int j = 0;
        while(i<s.length() && j<p.length()){
            if(j==-1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == p.length()){
            return s.substring(i-j, i);
        }
        return null;
    }

    public static void main(String[] args) {
        KMP kmp  = new KMP();
        kmp.getNext1("aaaaaa");
        System.out.println(kmp.kmp("abadefg", "aba"));
    }

}
