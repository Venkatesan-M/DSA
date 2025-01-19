
public class Main{
    public static void main(String[] args) {
        int n = 5;
        isoscelesTriangle(n);
        System.out.println();
        invertedRightTriangle(n);
    }

    static void rightTriangle(int n){
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                System.out.print('*');
            }
            System.out.println();
        }

    }

    static void isoscelesTriangle(int n){
        for(int i = 1; i <= n; i++){
            StringBuilder s = new StringBuilder();
            s.append((n));
            System.out.println();
        }

    }


    static void invertedRightTriangle(int n){
        for(int i = 1; i <= n; i++){
            for(int j = i; j <= n; j++){
                System.out.print('*');
            }
            System.out.println();
        }

    }
}