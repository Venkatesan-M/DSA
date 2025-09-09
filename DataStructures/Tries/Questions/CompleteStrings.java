package DataStructures.Tries.Questions;

public class CompleteStrings {
    
    // https://www.naukri.com/code360/problems/complete-string_2687860
    static class Trie{
    class Node{
      Node[] links = new Node[26]; boolean flag = false;
      Node(){}
      void set(char ch, Node node){
        int idx = (int)(ch - 'a'); links[idx] = node;
      }
      Node get(char ch){
        int idx = (int)(ch - 'a'); return links[idx];
      }
      boolean containsKey(char ch){
        int idx = (int)(ch - 'a'); return links[idx] !=null;
      }
      void setEnd(){flag = true;}
      boolean isEnd(){return flag;}
    }
    private Node root = new Node();
    Trie(){}
    void insert(String word){
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
    boolean everyPrefix(String word){
      Node node = root;
      for(int i = 0; i < word.length(); i++){
        char ch = word.charAt(i);
        if(!node.containsKey(ch)){
          return false;
        }
        node = node.get(ch);
        if(!node.isEnd()) return false;
      }
      return node.isEnd();
    }
  }

  public static String completeString(int n, String[] a) {
    // Write your code here.
      String ans = "";
      Trie trie = new Trie();
      for(String s : a){
        trie.insert(s);
      }
      for(String s : a){
        if(trie.everyPrefix(s)){
          if (s.length() > ans.length()) {
            ans = s;
          } else if (s.length() == ans.length() && s.compareTo(ans) < 0) {
            ans = s;
          }
        }
      }
      return (ans.equals("")) ? "None" : ans;
  }
}
