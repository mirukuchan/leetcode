package questions;
import java.util.*;


class word_squares{

    // use trie
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        List<Integer> wordList = new ArrayList<>();
        TrieNode(){
            isEnd = false;
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }
        }
    }

    String words[];
    int N = 0;
    
    public List<List<String>> wordSquaresWithTrie(String[] words){
        this.N = words[0].length();
        this.words = words;
        List<List<String>> res = new ArrayList<List<String>>();
        TrieNode root = this.buildTrie(words);
        for(String word: words){
            LinkedList<String> wordSquare = new LinkedList<>();
            wordSquare.add(word);
            this.backTrackWithTrie(1, root, wordSquare, res);
        }
        return res;
    }

    public void insert(String key, int index, TrieNode root){
        int level;
        int len = key.length();
        int idx;
        TrieNode pNode = root;
        for(level = 0; level < len; level++){
            idx = key.charAt(level) - 'a';
            if(pNode.children[idx] == null){
                pNode.children[idx] = new TrieNode();
            }
            pNode = pNode.children[idx];
            pNode.wordList.add(index);
        }
        pNode.isEnd = true;
    }

    public TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++){
            insert(words[i], i, root);
        }
        return root;
    }

    public List<Integer> getPrefixByTrie(String prefix, TrieNode root){
        int level, len = prefix.length(), idx;
        TrieNode pNode = root;
        List<Integer> ans = new ArrayList<>();
        for(level = 0; level < len; level++){
            idx = prefix.charAt(level) - 'a';
            if(pNode.children[idx] == null){
                return new ArrayList<>();
            } else {
                pNode = pNode.children[idx];
                ans = pNode.wordList;
            }
        }
        return ans;
    }

    public void backTrackWithTrie(int step,TrieNode root, LinkedList<String> wordSquares, List<List<String>> res){
        if(step == N){
            res.add((List<String>)wordSquares.clone());
            return;
        }
        StringBuffer prefix = new StringBuffer();
        for(String word: wordSquares){
            prefix.append(word.charAt(step));
        }
        for(Integer i: this.getPrefixByTrie(prefix.toString(), root)){
            wordSquares.add(this.words[i]);
            this.backTrackWithTrie(step + 1, root, wordSquares, res);
            wordSquares.removeLast();
        }
    }

    // use hashmap

    HashMap<String, List<String>> map;
    
    public List<List<String>> wordSquares(String[] words){
        this.N = words[0].length();
        List<List<String>> res = new ArrayList<List<String>>();
        this.buildHashMap(words);
        for(String word: words){
            LinkedList<String> wordSquare = new LinkedList<>();
            wordSquare.add(word);
            this.backTrack(1, wordSquare, res);
        }
        return res;
    }

    public void backTrack(int step, LinkedList<String> wordSquares, List<List<String>> res){
        if(step == N){
            res.add((List<String>)wordSquares.clone());
            return;
        }
        StringBuffer prefix = new StringBuffer();
        for(String word: wordSquares){
            prefix.append(word.charAt(step));
        }
        for(String s: this.getPrefixWords(prefix.toString())){
            wordSquares.add(s);
            this.backTrack(step + 1, wordSquares, res);
            wordSquares.removeLast();
        }
    }

    public void buildHashMap(String words[]){
        this.map = new HashMap<>();
        for(String word: words){
            for(int i = 1; i < this.N; i++){
                String prefix = word.substring(0,i);
                List<String> wordList = this.getPrefixWords(prefix);
                map.put(prefix, wordList);
                wordList.add(word);
            }
        }
    }
    
    public List<String> getPrefixWords(String prefix){
        List<String> list = this.map.get(prefix);
        return list == null ? null : list;
    }
}