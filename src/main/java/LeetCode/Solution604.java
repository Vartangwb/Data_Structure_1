package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution604 {

    public class StringIterator {
        char[] chs;
        int index;
        int num;
        char ch;

        public StringIterator(String compressedString) {
            chs = compressedString.toCharArray();
            index = 0;
            num = 0;
        }
        public char next(){
            if(hasNext()){
                if(num<=0){
                    ch = chs[index++];
                    while(index<chs.length && chs[index]>='0' && chs[index]<='9'){
                        num = num*10+chs[index]-'0';
                        index++;
                    }
                    num--;
                    return ch;
                }else{
                    num--;
                    return ch;
                }
            }
            return ' ';

        }

        public boolean hasNext(){
            return (num > 0) || (index < chs.length) ? true : false;
        }


    }

    }
