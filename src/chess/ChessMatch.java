package chess;

import boardgame.Board;
import chess.piece.King;
import chess.piece.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat =
                new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    private void placceNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(
                piece, new ChessPosition(column, row).toPosition()
        );
    }

    private void initialSetup() {
        placceNewPiece('c', 1, new Rook(board, Color.WHITE));
        placceNewPiece('c', 2, new Rook(board, Color.WHITE));
        placceNewPiece('d', 2, new Rook(board, Color.WHITE));
        placceNewPiece('e', 2, new Rook(board, Color.WHITE));
        placceNewPiece('e', 1, new Rook(board, Color.WHITE));
        placceNewPiece('d', 1, new King(board, Color.WHITE));

        placceNewPiece('c', 7, new Rook(board, Color.BLACK));
        placceNewPiece('c', 8, new Rook(board, Color.BLACK));
        placceNewPiece('d', 7, new Rook(board, Color.BLACK));
        placceNewPiece('e', 7, new Rook(board, Color.BLACK));
        placceNewPiece('e', 8, new Rook(board, Color.BLACK));
        placceNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
