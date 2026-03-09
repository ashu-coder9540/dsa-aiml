public class ChampagneTower {
    static double t[][] = new double[101][101];
    private static double solve(int poured, int i, int j) {
        if (i < 0 || j < 0 || i < j) {
            return 0.0;
        }
        if (i == 0 && j == 0) { // we reached the top glass
            return poured;
        }
        if (t[i][j] != -1.0)
            return t[i][j];
        double up_left = Math.max(0.0, (solve(poured, i - 1, j - 1) - 1)) / 2.0;
        double up_right = Math.max(0.0, (solve(poured, i - 1, j) - 1)) / 2.0;

        return t[i][j] = up_left + up_right;
    }
    public static double champagneTower(int poured, int query_row, int query_glass) {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                t[i][j] = -1;
            }
        }
        return Math.min(1.0, solve(poured, query_row, query_glass));
    }

     public static double champagneTower2(int poured, int query_row, int query_glass) {
        double t[][] = new double[101][101];
        t[0][0] = (double)poured;
        for(int i=0; i<=query_row; i++){
            for(int j=0; j<=query_glass; j++){
                double excess = (t[i][j] - 1.0)/2.0;
                if(excess > 0){
                    t[i+1][j] += excess;
                    t[i+1][j+1] += excess;
                }
            }
        }
        return Math.min(1.0, t[query_row][query_glass]);
    }
    public static void main(String[] args) {
        int poured = 2;
        int query_row = 1;
        int query_glass = 1;
        double result = champagneTower(poured, query_row, query_glass);
        System.out.println(result); // Output: 0.50000

        double result2 = champagneTower2(poured, query_row, query_glass);
        System.out.println(result2); // Output: 0.50000
    }
}
