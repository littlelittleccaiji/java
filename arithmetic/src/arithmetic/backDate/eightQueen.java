package arithmetic.backDate;

public class eightQueen {
    static int n=10;
    static int[] result=new int[n];
    static int resultNum=0;
    public static void main(String[] args) {
        huishu(0);
        System.out.println(resultNum);
    }
    public static void huishu(int row){
        if(row==n){
            printQueens(result);
            return;
        }
        for(int column=0;column<n;column++){
            if(isOk(row,column)){
                result[row]=column;
                huishu(row+1);
            }
        }
    }
    public static Boolean checkOk(int column,int row){
        for (int i=0;i<result.length;i++){
            if(result[i]==row){
                return false;
            }
            if(column!=i&&(row-column)==(result[i]-i)){
                return false;
            }
        }
        return true;
    }
    public static void printResult(){
        for (int row = 0;row<n;++row){
        for (int column =0;column<n;++column){
            if(result[row] ==column)System.out.print("Q");
        else System.out.print("*");
        }
        System.out.println();
    }
    System.out.println();
    }
    private static boolean isOk(int row, int column) {//判断row行column列放置是否合适
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            if (result[i] == column) return false; // 第i行的column列有棋子吗？
            if (leftup >= 0) { // 考察左上对角线：第i行leftup列有棋子吗？
                if (result[i] == leftup) return false;
            }
            if (rightup < n) { // 考察右上对角线：第i行rightup列有棋子吗？
                if (result[i] == rightup) return false;
            }
            --leftup;
            ++rightup;
        }
        return true;
    }
    private static void printQueens(int[] result) {
        resultNum++;
        // 打印出一个二维矩阵
        for (int row = 0; row < n; ++row) {
            for (int column = 0; column < n; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
