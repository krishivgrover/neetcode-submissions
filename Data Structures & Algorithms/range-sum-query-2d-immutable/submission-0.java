class NumMatrix {
    private int[][] prefix;
    public NumMatrix(int[][] matrix) {
    if(matrix == null ||matrix.length ==0 || matrix[0].length==0){ 
        return;  
    }
    int m=matrix.length;
    int n=matrix[0].length;
    prefix= new int[m][n];
    
    for(int r=0;r<m;r++){
        for(int c=0;c<n;c++){
            int top=(r>0) ?prefix[r-1][c]:0;
            int left=(c>0)?prefix[r][c-1]:0;
            int topLeft=(r>0 && c>0)?prefix[r-1][c-1]:0;
            prefix[r][c]= matrix[r][c]-topLeft +top+left;
        }
    }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
     int total = prefix[row2][col2];
         int top=(row1>0) ?prefix[row1-1][col2]:0;
            int left=(col1>0)?prefix[row2][col1-1]:0;
            int topLeft=(row1>0 && col1>0)?prefix[row1-1][col1-1]:0;
    return total-top-left+topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */