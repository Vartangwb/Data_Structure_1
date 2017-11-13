
package LeetCode;

/**
 * bit
 *
 * @author tangwenbo
 * @create 2017-10-16 20:54
 **/
public class Solution208 {
    class Solution {
        class TrieNode {
            char data;
            boolean isWord;
            TrieNode[] trieNodes = new TrieNode[26];
        }

        TrieNode root;

        public Solution(){
            root = new TrieNode();
        }
        public void insert(String s) {
            TrieNode helper = root;
            int i = 0;
            while(i<s.length()){
                char c = s.charAt(i);
                if(helper.trieNodes[c - 'a'] == null){
                    helper.trieNodes[c-'a'] = new TrieNode();
                }
                helper = helper.trieNodes[c-'a'];
                i++;
            }
            helper.isWord = true;
        }
        public boolean search(String s){
            TrieNode helper = root;
            int i = 0;
            while(i<s.length()){
                char c = s.charAt(i);
                if(helper.trieNodes[c - 'a'] == null){
                    return false;
                }else{
                    helper = helper.trieNodes[c-'a'];
                }
                i++;
            }
            return helper.isWord;
        }

        public boolean startWith(String prefix){
            TrieNode helper = root;
            int i = 0;
            while(i<prefix.length()){
                char c = prefix.charAt(i);
                if(helper.trieNodes[c-'a']==null)
                    return false;
                else{
                    helper = helper.trieNodes[c-'a'];
                }
                i++;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Solution208 solution216 = new Solution208();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);

    }


}
