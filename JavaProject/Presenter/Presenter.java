package JavaProject.Presenter;

import java.util.Scanner;

import JavaProject.Model.ToyLottery;
import JavaProject.View.View;

public class Presenter {
    private ToyLottery toyLottery;
    private View view;
    public Presenter(View view){
        toyLottery=new ToyLottery();
        this.view = view;
    }

    public void FillLottery(){
        if(toyLottery.getLotteryToys().isEmpty()){
            System.out.println("Enter amount of toys: ");
            toyLottery.FillLottery(new Scanner(System.in).nextInt());
        }
        else{
            System.out.println("List of toys for lottery is not empty");
        }
    }

    public void getInfo(){
        if(!toyLottery.getLotteryToys().isEmpty()){
            toyLottery.getInfo();
        }
        else{
            System.out.println("List of toys for lottery is empty");
        }
    }

    public void LotteryRound(){
        if(!toyLottery.getLotteryToys().isEmpty()){
            toyLottery.LotteryRound();
        }
        else{
            System.out.println("List of toys for lottery is empty");
        }
    }
}
