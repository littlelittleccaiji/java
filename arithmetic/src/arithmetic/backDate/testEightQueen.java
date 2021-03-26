package arithmetic.backDate;

public class testEightQueen {
   static int[]rows = new int[8];
    static int  answerNum=0;
    public static void main(String[] args) {
        getResult(0,rows);
        System.out.println(answerNum);
    }

    public static void getResult(int currentRow, int[]rows) {
        if (currentRow == rows.length) {
            printAll();
            return;
        }
        for (int columu = 0; columu <8; columu++) {
            if (check(currentRow, columu)) {
                rows[currentRow] = columu;
                getResult(currentRow + 1,rows);
            }
        }
    }

    public static boolean check(int row, int column) {
        for (int i = 0; i < row; i++) {
                if(Math.abs(row-i)==Math.abs(column-rows[i])){
                    return false;
                }
                if(rows[i]==column){
                    return false;
                }
        }
        return true;
    }

    public static void printAll() {
        answerNum++;
        for (int i=0;i<rows.length;i++){
            for (int j=0;j<8;j++){
                if(rows[i]==j){
                    System.out.print("Q  ");
                }else {
                    System.out.print("*  ");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
