package org.example.Service.WinningStrategy;


public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategyType winningStrategyType,int dimension){

        switch (winningStrategyType){
            case Corner : return new CornerWinningStrategy(dimension);
            case Normal : return new NormalWinningStrategy(dimension);
        }
        return null;
    }
}
