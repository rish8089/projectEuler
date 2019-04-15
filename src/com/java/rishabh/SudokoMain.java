package com.java.rishabh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokoMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("src/resources/sudoko.txt"));

        Sudoku sudoku=new Sudoku(br);
        sudoku.processInput();
        System.out.println("sudoku = " + sudoku.solve());
    }

}
