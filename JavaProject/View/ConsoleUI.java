package JavaProject.View;

import java.util.Scanner;

import JavaProject.Presenter.Presenter;

public class ConsoleUI implements View{
    private static final String inputError = "Incorrect value";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Hello");
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Bye");
        work = false;
    }

    public void FillLottery(){
        presenter.FillLottery();
    }

    public void getInfo(){
        presenter.getInfo();
    }

    public void LotteryRound(){
        presenter.LotteryRound();
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(inputError);
    }
}
