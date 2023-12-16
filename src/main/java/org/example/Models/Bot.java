package org.example.Models;

import org.example.Exception.CellOccupiedException;
import org.example.Exception.GameOverException;
import org.example.Exception.InvalidCellEntryException;
import org.example.Service.BotStrategy.BotPlayingStrategy;
import org.example.Service.BotStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "BOT" ,symbol,PlayerType.Bot);
        this.botDifficultyLevel=botDifficultyLevel;
    }

    public BotDifficultyLevel getDifficulty() {
        return botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) throws InvalidCellEntryException, CellOccupiedException, GameOverException {
        BotPlayingStrategy botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
        Cell cell=botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.Filled);
        cell.setSymbol(getSymbol());
        System.out.println(getName()+" played a move ");
        return new Move(this,cell);
    }
}
