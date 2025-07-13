package DynamicProgramming.Others;


public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] p = {30, 35, 15, 5, 10, 20, 25}; // Example dimensions
        int n = p.length;
    
        int minCost = matrixChainMultiplication(p, n);
        System.out.println("Minimum number of multiplications: " + minCost);
    }

    public static void printPara(int[][] s, int i, int j){
        if(i==j){
            System.out.print("A"+i);
        }
        else{
            System.out.print("(");
            printPara(s, i, s[i][j]);
            printPara(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static int matrixChainMultiplication(int[] p, int n){
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];
        for(int l = 2; l < n; l++){
            for(int i = 1; i < n-l+1; i++){
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int q = m[i][k] + m[k+1][j] + p[i-1]*p[j]*p[k];
                    if(q<m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println("Optimal Parenthesization: ");
        printPara(s, 1, n-1);
        System.out.println();
        return m[1][n-1];
    }
}
