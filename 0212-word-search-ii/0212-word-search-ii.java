class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // Build Trie
        for (String w : words) {
            TrieNode cur = root;
            for (char c : w.toCharArray()) {
                if (cur.child[c - 'a'] == null)
                    cur.child[c - 'a'] = new TrieNode();
                cur = cur.child[c - 'a'];
            }
            cur.word = w;
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, ans);

        return ans;
    }

    void dfs(char[][] b, int i, int j, TrieNode node, List<String> ans) {
        if (i < 0 || j < 0 || i == b.length || j == b[0].length || b[i][j] == '#')
            return;

        char c = b[i][j];
        node = node.child[c - 'a'];
        if (node == null) return;

        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        b[i][j] = '#';
        dfs(b, i + 1, j, node, ans);
        dfs(b, i - 1, j, node, ans);
        dfs(b, i, j + 1, node, ans);
        dfs(b, i, j - 1, node, ans);
        b[i][j] = c;
    }
}