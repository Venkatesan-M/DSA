package DataStructures.Tries.Theory;

class PrefixTree {

    // https://leetcode.com/problems/implement-trie-prefix-tree/
    class Trie {
        private class Node{
            Node[] links;
            boolean flag;
            Node(){
                links = new Node[26]; 
                flag = false;
            }
            public void set(char ch, Node node){
                int idx = (int)(ch - 'a');
                links[idx] = node;
            }
            public Node get(char ch){
                int idx = (int)(ch - 'a');
                return links[idx];
            }
            public boolean containsKey(char ch){
                int idx = (int)(ch - 'a');
                return links[idx] != null;
            }
            public void setEnd(){
                flag = true;
            }
            public boolean isEnd(){
                return flag;
            }
        }   

        private Node root;   

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    node.set(ch, new Node());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)) return false;
                node = node.get(ch);
            }
            return node.isEnd();
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for(int i = 0; i < prefix.length(); i++){
                char ch = prefix.charAt(i);
                if(!node.containsKey(ch)) return false;
                node = node.get(ch);
            }
            return true;
        }
    }

    // https://www.naukri.com/code360/problems/implement-trie_1387095
    public class TrieII {
        class Node{
            Node[] links = new Node[26];
            int countPrefix = 0, countWord = 0;
            Node(){}
            void set(char ch, Node node){
                int idx = (int)(ch - 'a');
                links[idx] = node;
            }
            Node get(char ch){
                int idx = (int)(ch - 'a');
                return links[idx];
            }
            boolean containsKey(char ch){
                int idx = (int)(ch - 'a');
                return links[idx] != null;
            }
            int words(){
                return countWord;
            }
            int prefixes(){
                return countPrefix;
            }
            void incWord(){
                countWord++;
            }
            void incPre(){
                countPrefix++;
            }
            void decWord(){
                countWord--;
            }
            void decPre(){
                countPrefix--;
            }
        }
        private Node root = new Node();
        public TrieII() {
            // Write your code here.
        }   

        public void insert(String word) {
            // Write your code here.
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    node.set(ch, new Node());
                }
                node = node.get(ch);
                node.incPre();
            }
            node.incWord();
        }   

        public int countWordsEqualTo(String word) {
            // Write your code here.
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    return 0;
                }
                node = node.get(ch);
            }
            return node.words();
        }   

        public int countWordsStartingWith(String word) {
            // Write your code here.
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    return 0;
                }
                node = node.get(ch);
            }
            return node.prefixes();
        }   

        public void erase(String word) {
            // Write your code here.
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                char ch = word.charAt(i);
                node = node.get(ch);
                node.decPre();
            }
            node.decWord();
        }   

    }
    public static void main(String[] args) {

    }
}