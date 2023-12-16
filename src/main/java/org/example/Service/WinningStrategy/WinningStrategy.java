package org.example.Service.WinningStrategy;

import org.example.Models.Board;
import org.example.Models.Move;

public interface WinningStrategy {
     boolean checkWinner(Board board, Move move);
}
