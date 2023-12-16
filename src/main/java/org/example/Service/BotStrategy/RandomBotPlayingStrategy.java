package org.example.Service.BotStrategy;

import org.example.Exception.GameOverException;
import org.example.Models.Board;
import org.example.Models.Cell;
import org.example.Models.CellState;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    public int getRandomNumber(int size){
        Random random = new Random();
        return random.nextInt(size);
    }

    @Override
    public Cell makeMove(Board board) throws GameOverException {
        List<Cell> emptyCells=new ArrayList<>();
        for(List<Cell>cells:board.getCells()){
            for(Cell cell:cells){
                if(cell.getCellState().equals(CellState.Empty)){
                    emptyCells.add(cell);
                }
            }
        }
        if(emptyCells.size()==0)
            throw new GameOverException("Cannot play A move : All Cells are filled");

        int randomNumber=getRandomNumber(emptyCells.size());
        return emptyCells.get(randomNumber);
    }
}
