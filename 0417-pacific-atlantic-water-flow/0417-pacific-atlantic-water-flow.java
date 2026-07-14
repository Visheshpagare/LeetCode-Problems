class Solution {

    private final int[][] dirs = {
    {1, 0},   // Down
    {-1, 0},  // Up
    {0, 1},   // Right
    {0, -1}   // Left
};
    public List<List<Integer>> pacificAtlantic(int[][] heigth) {
        int m = heigth.length;
        int n = heigth[0].length;
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];

        for(int i = 0; i < m; i++){
           dfs(heigth, pacific, i, 0, heigth[i][0]);
           dfs(heigth, atlantic, i, n-1, heigth[i][n-1]);
        }   

        for(int j = 0; j < n; j++){
           dfs(heigth, pacific, 0, j, heigth[0][j]);
           dfs(heigth, atlantic, m-1, j, heigth[m-1][j]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i , j));
                }
            }
        }
        return ans;
    }

    private void dfs(int heigth[][] , boolean visited[][] , int i , int j , int prev){
        int m = heigth.length;
        int n = heigth[0].length;
        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || heigth[i][j] < prev){
            return;
        }
        visited[i][j] = true;
        for(int dir[] : dirs){
            dfs(heigth , visited , i + dir[0] , j+dir[1] , heigth[i][j]);
        }
    }
}