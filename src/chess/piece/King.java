package chess.piece;

import boardgame.*;
import chess.*;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor()
                == getColor() && p.getMoveCount() == 0;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()]
                [getBoard().getColumns()];
        Position p = new Position(0, 0);

        // Above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // northWest
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // northEast
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // south of west
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // southeast
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExests(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Specialmove castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()) {
            // Specialmove castling kingside rook
            Position postT1 = new Position(position.getRow(), position.getColumn() + 3);
            if (testRookCastling(postT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            // Specialmove castling queenside rook
            Position postT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRookCastling(postT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null
                        && getBoard().piece(p3) == null) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
