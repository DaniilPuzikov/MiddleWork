package JavaProject.View.Commands;

import JavaProject.View.ConsoleUI;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Get Info";
    }

    public void execute(){
        consoleUI.getInfo();
    }
}
