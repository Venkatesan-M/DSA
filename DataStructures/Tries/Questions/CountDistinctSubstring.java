package DataStructures.Tries.Questions;

public class CountDistinctSubstring {
    // https://www.naukri.com/code360/problems/count-distinct-substrings_985292
  
  // https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1

  static class Node{
      Node[] links = new Node[26];
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
    }
    public static int countDistinctSubstring(String st) {
        int cnt = 1;
        Node root = new Node();
        for(int i = 0; i < st.length(); i++){
            Node node = root;
            for(int j = i; j < st.length(); j++){
                char ch = st.charAt(j);
                if(!node.containsKey(ch)){
                    cnt++;
                    node.set(ch, new Node());
                }
                node = node.get(ch);
            }
        }
        return cnt;
    }

    // https://www.geeksforgeeks.org/problems/bits-basic-operations/1
    public int XOR(int n, int m) {
        return n ^ m;
    }

    public int check(int a, int b) {
        // Assuming 1-based indexing for bit position
        return (b & (1 << (a - 1))) != 0 ? 1 : 0;
    }

    public int setBit(int c, int d) {
        return d | (1 << c);
    }
}
