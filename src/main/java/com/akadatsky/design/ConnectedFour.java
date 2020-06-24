package com.akadatsky.design;

import java.util.ArrayList;

public class ConnectedFour {

    private int size;
    private int[][] board;
    private int counter;

    /**
     * https://www.mathsisfun.com/games/connect4.html
     * */
    public ConnectedFour(int n) {
        this.size = n;
        this.board = new int[n][n];
        this.counter = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                this.board[i][j] = 0;
    }

    public void move(int col) {
        if (col <0 || col >=size) {
            System.out.println("Invalid");
        }

        for (int row = 0; row < size; row++) {
            if (board[row][col] == 0) {
                counter +=1;
                int player = counter % 2;
                if (player == 0) {
                    player +=2;
                }
                board[row][col] = player;

                prettyPrintBoard();

                if (check(row, col)) {
                    System.out.println(String.format("player %d [%d, %d], win", player, row, col));
                } else {
                    if (counter == size*size) {
                        System.out.println("Draw");
                    }

                    System.out.println(String.format("player %d, [%d, %d] not yet finished", player, row, col));
                }
                return;
            }
        }

        // invalid, this column is already used
        System.out.println("Invalid");
    }

    private boolean check(int row, int col) {
        int player = board[row][col];
        return verticalScan(row, col, player) || horizonScan(row, col, player)
                || crossScanEqualSum(row, col, player) || crossScanIncTogether(row, col, player);
    }

    private boolean verticalScan(int row, int col, int player) {
        int count = 1;
        for (int i = col-1; i >= 0; i--) {
            if (board[row][i] == player) {
                count +=1;
            } else {
                break;
            }
        }
        for (int i = col + 1; i <= size-1; i++) {
            if (board[row][i] == player) {
                count +=1;
            } else {
                break;
            }
        }
        return count>= 4;
    }

    private boolean horizonScan(int row, int col, int player) {
        int count = 1;
        for (int i = row-1; i>=0; i--) {
            if (board[i][col] == player) {
                count +=1;
            } else {
                break;
            }
        }
        return count>= 4;
    }

    /**
     * 4
     * 3
     * (2,0) (2,1)
     * (1,0) (1,1) (1,2) (1,3) (1,4)
     * (0,0) (0,1) (0,2) (0,3) (0,4)
     * */
    private boolean crossScanEqualSum(int row, int col, int player) {
        int count = 1;

        int i = row-1;
        int j = col+1;
        while ( i >= 0 && j < size) {
            if (board[i][j] == player) {
                count +=1;
                i--;
                j++;
            } else {
                break;
            }
        }

        i = row+1;
        j = col-1;
        while ( i < size && j >= 0) {
            if (board[i][j] == player) {
                count +=1;
                i++;
                j--;
            } else {
                break;
            }
        }

        return count >= 4;
    }

    private boolean crossScanIncTogether(int row, int col, int player) {
        int count = 1;

        int i = row+1;
        int j = col+1;
        while ( i < size && j < size) {
            if (board[i][j] == player) {
                count +=1;
                i++;
                j++;
            } else {
                break;
            }
        }

        i = row-1;
        j = col-1;
        while ( i >= 0 && j >= 0) {
            if (board[i][j] == player) {
                count +=1;
                i--;
                j--;
            } else {
                break;
            }
        }

        return count >= 4;
    }

    public  void prettyPrintBoard() {
        System.out.println("the board after we move" + counter);

        for (int i = size-1; i>=0; i--) {
            for (int j= 0; j< size; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.println("");
        }

        System.out.println("=========================");
    }
}
