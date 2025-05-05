package chess.piece;

import boardgame.*;
import chess.*;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()]
                [getBoard().getColumns()];
        Position p = new Position(0,0);

        // Above
        p.setValues(position.getRow() - 1, position.getColumn());
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() - 1);
        }
        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() + 1);
        }
        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() + 1);
        }
        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        // Northwest
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // North East
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // Southeast
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() + 1);
        }

        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // South-west
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        while (getBoard().positionExests(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1, p.getColumn() - 1);
        }
        if (getBoard().positionExests(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}
