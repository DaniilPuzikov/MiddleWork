package JavaProject.View.Commands;

import JavaProject.View.ConsoleUI;

public class LotteryRound extends Command{
    public LotteryRound(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Lottery round";
    }

    public void execute(){
        consoleUI.LotteryRound();
    }
}
