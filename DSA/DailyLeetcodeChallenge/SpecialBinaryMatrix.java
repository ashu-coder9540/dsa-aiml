public class SpecialBinaryMatrix {
    public static int numSpecial(int[][] mat) {
        int res = 0;
        int m = mat.length;
        int n = mat[0].length;

        // BruteForce Approach
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(mat[row][col] == 0) continue;
                boolean special = true;
                // check col
                for(int r = 0; r < m; r++){
                    if(r != row && mat[r][col] == 1){
                        special = false;
                        break;
                    }
                }
                // check row
                for(int c = 0; c < n; c++){
                    if(c != col && mat[row][c] == 1){
                        special = false;
                        break;
                    }
                }
                if(special == true){
                    res++;
                }
            }
        } 
        return res;
    }
    public static void main(String[] args) {
        int[][] mat1 = {{1,0,0},{0,0,1},{1,0,0}};
        int[][] mat2 = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] mat3 = {{0,0,0},{0,0,0},{0,0,0}};

        System.out.println(numSpecial(mat1)); // Expected output: 1
        System.out.println(numSpecial(mat2)); // Expected output: 3
        System.out.println(numSpecial(mat3)); // Expected output: 0
    }
}
