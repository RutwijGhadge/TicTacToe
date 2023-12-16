package org.example.Service.BotStrategy;

import org.example.Models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel == BotDifficultyLevel.Random)
            return new RandomBotPlayingStrategy();

        return null;
    }
}
