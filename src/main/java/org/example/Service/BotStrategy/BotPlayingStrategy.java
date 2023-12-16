package org.example.Service.BotStrategy;

import org.example.Exception.GameOverException;
import org.example.Models.Board;
import org.example.Models.Cell;

public interface BotPlayingStrategy {
    Cell makeMove(Board board) throws GameOverException;
}
