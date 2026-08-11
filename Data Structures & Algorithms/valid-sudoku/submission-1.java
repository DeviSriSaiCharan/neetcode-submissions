class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        for(int i=0 ; i<n ; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            for(int j=0 ; j<n ; j++) {
                char rowVal = board[i][j];
                if(row.contains(rowVal)) return false;

                if(rowVal != '.') row.add(rowVal);

                char colVal = board[j][i];
                if(col.contains(colVal)) return false;

                if(colVal != '.') col.add(colVal);
            }
        }


        for(int i=0 ; i<3 ; i++) {
            for(int j=0 ; j<3 ; j++) {
                HashSet<Character> cell = new HashSet<>();
                for(int x=i*3 ; x<i*3 + 3 ; x++) {
                    for(int y=j*3 ; y<j*3 + 3 ; y++) {
                        char val = board[x][y];

                        if(cell.contains(val)) return false;

                        if(val != '.') cell.add(val);

                    }
                }
            }
        }

        return true;
    }
}
