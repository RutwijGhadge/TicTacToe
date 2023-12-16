package org.example.Service.WinningStrategy;

import org.example.Models.Board;
import org.example.Models.Move;
import org.example.Models.Player;

import java.util.HashMap;
import java.util.Map;

public class CornerWinningStrategy implements WinningStrategy{
    int dimension;
    private Map<Character,Integer> cornerMap;

    public CornerWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.cornerMap = new HashMap<>();
    }
    private boolean checkIfCornerWin(Character Symbol,int row,int col){
        if((row==0 || row==dimension-1) && (col==0 || col==dimension-1))
            cornerMap.put(Symbol, cornerMap.getOrDefault(Symbol,0)+1);
        return cornerMap.getOrDefault(Symbol,0)==4;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        Player player=move.getPlayer();
        Character Symbol=player.getSymbol();
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        return checkIfCornerWin(Symbol,row,col);
    }
}
