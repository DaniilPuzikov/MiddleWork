package JavaProject.View.Commands;

import JavaProject.View.ConsoleUI;

public class FillLottery extends Command{
    public FillLottery(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Fill list of toys for lottery";
    }

    public void execute(){
        consoleUI.FillLottery();
    }
}
