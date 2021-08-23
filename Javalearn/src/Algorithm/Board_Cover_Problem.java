package Algorithm;

public class Board_Cover_Problem {
    static int t = 1;

    public static void main(String[] args) {
        int[][] board = new int[8][8];
        ChessBoard(board, 0, 0, 0, 1, board.length);
        mArr.PrintArray(board);
    }

    public static void ChessBoard(int[][] board, int tr, int tc, int dr, int dc, int size) {
        if (size == 1) {
            return;
        }

        int s = size / 2;
        int color = t++;
        

        // 如果是左上角
        if (dr < tr + s && dc < tc + s) {
            ChessBoard(board, tr, tc, dr, dc, s);
        } else {
            int colorTr = tr + s - 1;
            int colorTc = tc + s - 1;
            board[colorTr][colorTc] = color;
            ChessBoard(board, tr, tc, colorTr, colorTc, s);
        }

        // 如果是右上角
        if (dr < tr + s && dc >= tc + s) {
            ChessBoard(board, tr, tc + s, dr, dc, s);
        } else {
            int colorTr = tr + s - 1;
            int colorTc = tc + s;
            board[colorTr][colorTc] = color;
            ChessBoard(board, tr, tc + s, colorTr, colorTc, s);
        }

        // 如果是左下角
        if (dr >= tr + s && dc < tc + s) {
            ChessBoard(board, tr + s, tc, dr, dc, s);
        } else {
            int colorTr = tr + s;
            int colorTc = tc + s - 1;
            board[colorTr][colorTc] = color;
            ChessBoard(board, tr + s, tc, colorTr, colorTc, s);
        }

        // 如果是右下角
        if (dr >= tr + s && dc >= tc + s) {
            ChessBoard(board, tr + s, tc + s, dr, dc, s);
        } else {
            int colorTr = tr + s;
            int colorTc = tc + s;
            board[colorTr][colorTc] = color;
            ChessBoard(board, tr + s, tc + s, colorTr, colorTc, s);
        }
    }

    public static void PrintBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.err.println();
    }
}