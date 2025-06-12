package DataStructures.Graphs.Learning;

import java.util.*;
class GraphStringProblems {


   // https://leetcode.com/problems/word-ladder/description/
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> wordSet = new HashSet<>(wordList);
      if (!wordSet.contains(endWord)) return 0;

      Queue<String> q = new LinkedList<>();
      q.offer(beginWord);
      Set<String> visited = new HashSet<>();
      visited.add(beginWord);

      int steps = 1;

      while (!q.isEmpty()) {
          int size = q.size();
          for (int i = 0; i < size; i++) {
              String word = q.poll();

              for (int j = 0; j < word.length(); j++) {
                  char[] chars = word.toCharArray();
                  for (char c = 'a'; c <= 'z'; c++) {
                      chars[j] = c;
                      String newWord = new String(chars);

                      if (newWord.equals(endWord)) return steps + 1;

                      if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                          visited.add(newWord);
                          q.offer(newWord);
                      }
                  }
              }
          }
          steps++;
      }

      return 0;
  }


  // https://leetcode.com/problems/word-ladder-ii/description/
  public List<List<String>> findLaddersTLE(String beginWord, String endWord, List<String> wordList) {
      List<List<String>> result = new ArrayList<>();
      Set<String> wordSet = new HashSet<>(wordList);
      if (!wordSet.contains(endWord)) return result;

      Queue<List<String>> queue = new LinkedList<>();
      queue.offer(Arrays.asList(beginWord));
      Set<String> visited = new HashSet<>();
      boolean found = false;

      while (!queue.isEmpty() && !found) {
          int size = queue.size();
          Set<String> localVisited = new HashSet<>();

          for (int i = 0; i < size; i++) {
              List<String> path = queue.poll();
              String lastWord = path.get(path.size() - 1);

              for (int j = 0; j < lastWord.length(); j++) {
                  char[] chars = lastWord.toCharArray();
                  for (char c = 'a'; c <= 'z'; c++) {
                      if (chars[j] == c) continue;
                      chars[j] = c;
                      String newWord = new String(chars);

                      if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                          List<String> newPath = new ArrayList<>(path);
                          newPath.add(newWord);

                          if (newWord.equals(endWord)) {
                              result.add(newPath);
                              found = true;
                          } else {
                              queue.offer(newPath);
                          }

                          localVisited.add(newWord);
                      }
                  }
              }
          }
          visited.addAll(localVisited);
      }

      return result;
  }


  // actual solution
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    Set<String> wordSet = new HashSet<>(wordList);
    if (!wordSet.contains(endWord)) return res;

    Map<String, List<String>> parentMap = new HashMap<>();
    Set<String> currentLevel = new HashSet<>();
    currentLevel.add(beginWord);

    boolean found = false;

    while (!currentLevel.isEmpty() && !found) {
        Set<String> nextLevel = new HashSet<>();
        for (String word : currentLevel) wordSet.remove(word); // prune visited

        for (String word : currentLevel) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue;
                    chars[i] = c;
                    String next = new String(chars);
                    if (!wordSet.contains(next)) continue;

                    nextLevel.add(next);
                    parentMap.computeIfAbsent(next, k -> new ArrayList<>()).add(word);

                    if (next.equals(endWord)) found = true;
                }
                chars[i] = original;
            }
        }
        currentLevel = nextLevel;
    }

    if (!found) return res;

    // Phase 2: backtrack to build paths
    LinkedList<String> path = new LinkedList<>();
    path.add(endWord);
    backtrack(endWord, beginWord, parentMap, path, res);
    return res;
  }

  private void backtrack(String word, String beginWord, Map<String, List<String>> parentMap,
                       LinkedList<String> path, List<List<String>> res) {
    if (word.equals(beginWord)) {
        LinkedList<String> validPath = new LinkedList<>(path);
        Collections.reverse(validPath);
        res.add(validPath);
        return;
    }

    if (!parentMap.containsKey(word)) return;

    for (String parent : parentMap.get(word)) {
        path.add(parent);
        backtrack(parent, beginWord, parentMap, path, res);
        path.removeLast();
    }
  }
}