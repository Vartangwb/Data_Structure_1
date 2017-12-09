

package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution211 {


    public class WordDictionary{
        public WordDictionary() {

        }
        public class TrieNode{
            TrieNode[] trieNodes = new TrieNode[26];
            String word = "";
        }
        private TrieNode root = new TrieNode();
        public void addWord(String word){
            TrieNode helper = root;
            for(int i = 0;i<word.length();i++){
                if(helper.trieNodes[word.charAt(i)-'a']!=null){
                }else{
                    helper.trieNodes[word.charAt(i)-'a'] = new TrieNode();
                }
                helper = helper.trieNodes[word.charAt(i)-'a'];
            }
            helper.word = word;

        }
        public boolean search(String word){
            return match(word.toCharArray(), 0, root);
        }
        public boolean match(char[] strs, int index, TrieNode root){
            if(index == strs.length){
                return !root.word.equals("");
            }
            if(strs[index] != '.'){
                if(root.trieNodes[strs[index]-'a']==null)
                    return false;
                return match(strs, index+1, root.trieNodes[strs[index]-'a']);
            }
            for(int i = 0;i<26;i++){
                if(root.trieNodes[i]!=null){
                    if(match(strs, index+1, root.trieNodes[i]))
                        return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Solution211 solution274 = new Solution211();
         }


}

