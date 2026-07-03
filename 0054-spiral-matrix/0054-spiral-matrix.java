class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int col = colStart; col<= colEnd; col++){
                list.add(matrix[rowStart][col]);
            }
            rowStart++;
            for(int row = rowStart; row<= rowEnd; row++){
                list.add(matrix[row][colEnd]);
            }
            colEnd--;
            if(rowStart<= rowEnd){
                for(int col = colEnd; col>= colStart; col--){
                  list.add(matrix[rowEnd][col]);
               }
            }
            rowEnd--;
            if(colStart <= colEnd){
            for(int row = rowEnd; row >= rowStart; row--){
                list.add(matrix[row][colStart]);
              }
            }
            colStart++;
        }
        return list;
    }
}