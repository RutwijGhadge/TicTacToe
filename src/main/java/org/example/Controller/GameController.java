package org.example.Controller;

import org.example.Models.Board;
import org.example.Models.Game;
import org.example.Models.Move;
import org.example.Models.Player;
import org.example.Service.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {
        public Game newGame(int boardSize, List<Player> players, List<WinningStrategy> winningStrategies){
            try{
                return Game.getBuilder()
                        .setPlayers(players)
                        .setSize(boardSize)
                        .setWinningStrategy(winningStrategies)
                        .Build();
            }catch (Exception e){
                System.out.println(e.getMessage());
                //System.out.println("hii..");
            }
            return null;
        }

        public Player getCurrentPlayer(Game game){
            return game.getCurrentPlayer();
        }

        public Move move(Game game,Player player){
            try{
                Move move=player.makeMove(game.getBoard());
                game.getBoard().PrintBoard();
                return move;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return null;
        }

        public void Undo(Game game,Move move){
            game.undoTheMove(move);
        }

        public void updateGameStatus(Game game,Move move){
            game.addMove(move);
            game.addBoardState();
            game.updateGameStatus();

            int nextId=(move.getPlayer().getId()+1)%game.getPlayers().size();
            game.setCurrentPlayer(game.getPlayers().get(nextId));
        }

        public void replay(Game game){
        for (Board board: game.getBoardStates()) {
            board.PrintBoard();
            System.out.println("======================================");
        }
    }
}
