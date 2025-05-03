package chess.piece;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()]
                [getBoard().getColumns()];
        Position p = new Position(0,0);

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
        return mat;
    }
}
