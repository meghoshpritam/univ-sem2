package Thread.MultiThread;

import java.util.ArrayList;

public class Matrix {
  ArrayList<ArrayList<Integer>> matrix;

  public Matrix(int row, int col) {
    this.matrix = new ArrayList<>();

    for (int idx = 0; idx < row; idx++) {
      ArrayList<Integer> rows = new ArrayList<>();
      for (int idx2 = 0; idx2 < col; idx2++)
        rows.add((int) (Math.random() * 1000));
      this.matrix.add(rows);
    }
  }

  public void showMatrix() {
    for (ArrayList<Integer> row : matrix) {
      for (Integer col : row)
        System.out.print(col + "\t");
      System.out.println("");
    }
  }

  public int getRow() {
    return this.matrix.size();
  }

  public int getCol() {
    return this.matrix.get(0).size();
  }

  public void setRow(int index, ArrayList<Integer> row) {
    this.matrix.set(index, row);
  }

  public int getCell(int row, int col) {
    return this.matrix.get(row).get(col);
  }

  public void setCell(int row, int col, int value) {
    this.matrix.get(row).set(col, value);
  }

  public static Matrix multiplicationWithThread(Matrix matrix1, Matrix matrix2) {
    Matrix matrixMul = new Matrix(matrix1.getRow(), matrix2.getCol());

    for (int i = 0; i < matrix1.getRow(); i++) {
      int finalI = i;
      (new Thread(() -> {
        for (int j = 0; j < matrix2.getCol(); j++) {
          int cell = 0;
          for (int k = 0; k < matrix2.getRow(); k++)
            cell += matrix1.getCell(finalI, k) * matrix2.getCell(k, j);
          matrixMul.setCell(finalI, j, cell);
        }
      })).start();
    }

    return matrixMul;
  }

  public static Matrix multiplication(Matrix matrix1, Matrix matrix2) {
    Matrix matrixMul = new Matrix(matrix1.getRow(), matrix2.getCol());

    for (int i = 0; i < matrix1.getRow(); i++) {
      for (int j = 0; j < matrix2.getCol(); j++) {
        int cell = 0;
        for (int k = 0; k < matrix2.getRow(); k++)
          cell += matrix1.getCell(i, k) * matrix2.getCell(k, j);
        matrixMul.setCell(i, j, cell);
      }
    }

    return matrixMul;
  }
}
