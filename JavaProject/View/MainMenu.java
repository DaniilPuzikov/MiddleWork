package JavaProject.View;

import java.util.ArrayList;
import java.util.List;

import JavaProject.View.Commands.Command;
import JavaProject.View.Commands.FillLottery;
import JavaProject.View.Commands.Finish;
import JavaProject.View.Commands.GetInfo;
import JavaProject.View.Commands.LotteryRound;

public class MainMenu {
    List<Command> commands;
    public MainMenu(ConsoleUI consoleUI){
        commands = new ArrayList<>();
        commands.add(new FillLottery(consoleUI));
        commands.add(new GetInfo(consoleUI));
        commands.add(new LotteryRound(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commands.size();
    }
}
