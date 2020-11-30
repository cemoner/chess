package com.company;

public class Generator {
    int randomrow = (int) (Math.random() * (8));
    int randomcolumn = (int) (Math.random() * (8));
    boolean isOkay = true;
    String[][] board;
    int tried = 0;

    public void createBoard() {
        String[][] board = new String[8][8];
        for (int i = 0; i <= 7; i++) {
            for (int l = 0; l <= 7; l++) {
                board[i][l] = "_";
            }
        }
        this.board = board;
    }

    public void board() {
        for (int i = 0; i <= 7; i++) {
            for (int n = 0; n <= 7; n++) {
                System.out.print(board[i][n] + "|");
            }
            System.out.println();
        }
    }

    public void generator() {
        for (int i = 0; i <= 7 && tried <=5000; ) {
            if(board[randomrow][randomcolumn].equals("_")){
                allInOne();
                if (isOkay) {
                    board[randomrow][randomcolumn] = "X";
                    randomrow = (int) (Math.random() * (8));
                    randomcolumn = (int) (Math.random() * (8));
                    isOkay = true;
                    tried++;
                    i += 1;
                } else {
                    randomrow = (int) (Math.random() * (8));
                    randomcolumn = (int) (Math.random() * (8));
                    isOkay = true;
                    tried++;
                }
            }else{
                randomrow = (int) (Math.random() * (8));
                randomcolumn = (int) (Math.random() * (8));

            }
        }
    }

    public void controllerRow() {
        for (int i = 0; i <= 7; i++) {
            if (board[randomrow][i].equals("X")) {
                isOkay = false;
                break;
            }
        }
    }

    public void controllerColumn() {
        for (int i = 0; i <= 7; i++) {
            if (board[i][randomcolumn].equals("X")) {
                isOkay  = false;
                break;
            }
        }
    }

    public void rightDiagon() {
        if (randomcolumn + randomrow > 7) {
            for (int i = randomcolumn + randomrow - 7; i <= 7; i++) {
                if (board[i][randomcolumn + randomrow - i].equals("X")) {
                    isOkay = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i <= randomrow + randomcolumn; i++) {
                if (board[i][randomcolumn + randomrow - i].equals("X")) {
                    isOkay = false;
                    break;
                }
            }

        }
    }

    public void leftDiagon() {
        int row = randomrow;
        int column = randomcolumn;
        while (row >= 0 && column >= 0) {
            if(board[row][column].equals("X")){
                isOkay = false;
                break;
            }
            row--;
            column--;
        }
        row = randomrow;
        column = randomcolumn;
        while(row<=7 && column <=7){
            if(board[row][column].equals("X")){
                isOkay = false;
                break;
            }
            row++;
            column++;
        }
    }

    public void allInOne() {
        controllerRow();
        controllerColumn();
        leftDiagon();
        rightDiagon();
    }

}
