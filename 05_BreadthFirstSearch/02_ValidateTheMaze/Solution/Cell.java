public class Cell {
    int row;
    int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean equals(Cell cell) {
        if (this.getRow() == cell.getRow() && this.getColumn() == cell.getColumn()) {
            return true;
        }
        return false;
    }

    public static boolean isValid(int row, int maxRow, int col, int maxCol) {
        if (row >= 0 && row < maxRow && col >= 0 && col < maxCol) {
            return true;
        }
        return false;
    }
}