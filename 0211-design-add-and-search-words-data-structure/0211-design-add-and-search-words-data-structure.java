class WordDictionary {

    class TrieNode {
        TrieNode[] children;
        boolean isLast;

        TrieNode() {
            children = new TrieNode[26];
            isLast = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }

        node.isLast = true;
    }

    public boolean search(String word) {
        return find(0, word, root);
    }

    private boolean find(int index, String word, TrieNode node) {

        if (index == word.length()) {
            return node.isLast;
        }

        char ch = word.charAt(index);

        // Wildcard character
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null &&
                    find(index + 1, word, node.children[i])) {
                    return true;
                }
            }
            return false;
        }

        // Normal character
        if (node.children[ch - 'a'] == null) {
            return false;
        }

        return find(index + 1, word, node.children[ch - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */