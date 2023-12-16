package org.example;

import org.example.Controller.GameController;
import org.example.Models.*;
import org.example.Service.WinningStrategy.WinningStrategy;
import org.example.Service.WinningStrategy.WinningStrategyFactory;
import org.example.Service.WinningStrategy.WinningStrategyType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GameController gameController=new GameController();
        Game game;
        do{
            System.out.println("Enter the Board Size");
            int size=sc.nextInt();
            int numOfPlayers=size-1;

            System.out.println("Does Game Have a Bot(Y/N)");
            char Choice=sc.next().charAt(0);

            List<Player> playerList=new ArrayList<>();

            if(Choice=='Y' || Choice=='y')
                numOfPlayers--;

            for(int i=0;i<numOfPlayers;i++){
                System.out.println("Enter the Name of Player:"+(i+1));
                String name=sc.next();
                System.out.println("Enter the Symbol of Player:"+(i+1));
                char symbol=sc.next().charAt(0);

                Player player=new Player(i,name,symbol);

               //System.out.println("Name:"+player.getName());
               // System.out.println("Symbol:"+player.getSymbol());
                playerList.add(player);
            }
            if(Choice=='Y' || Choice=='y'){
                playerList.add(new Bot(numOfPlayers,'B', BotDifficultyLevel.Random));
            }
            List<WinningStrategy> winningStrategies=
                    Arrays.asList(WinningStrategyFactory.getWinningStrategy(WinningStrategyType.Normal,size));

            game=gameController.newGame(size,playerList,winningStrategies);
            //System.out.println("going..."+game.getCurrentPlayer());
        }while(game==null);

        while(game.getGameStatus().equals(GameStatus.PROGRESS)){
            Player player=gameController.getCurrentPlayer(game);
            Move move;
            do{
                //System.out.println("going");
                move=gameController.move(game,player);
            }while(move==null);

            if(player.getPlayerType().equals(PlayerType.Human)){
                System.out.println("Do you want to Undo your Move(Y/N)");
                char undo=sc.next().charAt(0);
                if(undo=='Y' ){
                    gameController.Undo(game,move);
                    //gameController->Game->move->undo(Cell)
                    continue;
                }
            }
            gameController.updateGameStatus(game,move);
        }

        System.out.println("Do you want the game replay? (Y/N)");
        char isReplayReq = sc.next().charAt(0);
        if(isReplayReq=='Y' || isReplayReq=='y') {
            System.out.println("========================================================");
            System.out.println();
            gameController.replay(game);
        }
    }
}