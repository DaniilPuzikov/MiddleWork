package JavaProject.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import JavaProject.Model.Toys.Car;
import JavaProject.Model.Toys.Doll;
import JavaProject.Model.Toys.Lego;
import JavaProject.Model.Toys.Puzzle;
import JavaProject.Model.Toys.Robot;
import JavaProject.Model.Toys.Toy;

public class ToyLottery {
    private List<Toy>lotteryToys;
    private List<Toy>assortment;

    public ToyLottery(){
        lotteryToys = new ArrayList<>();
        assortment = new ArrayList<>();
        assortment.add(new Car());
        assortment.add(new Doll());
        assortment.add(new Lego());
        assortment.add(new Puzzle());
        assortment.add(new Robot());
    }

    public void FillLottery(int amount){
        Random r = new Random();
        for(int i = 0;i<amount;i++){
            int a = r.nextInt(0,5);
            for(Toy item: assortment){
                if(item.getId()==a){
                    lotteryToys.add(item);
                }
            }
        }
    }

    public void getInfo(){
        StringBuilder sb = new StringBuilder();
        for(Toy item:lotteryToys){
            sb.append(item.getName());
            sb.append(" ");
        }
        sb.append("\n");
        sb.append(getChances());
        System.out.println(sb.toString());
    }

    public void LotteryRound(){
        int i = new Random().nextInt(0,lotteryToys.size());
        System.out.println("You won "+lotteryToys.get(i).getName());
        lotteryToys.remove(i);
    }

    public List<Toy> getLotteryToys(){
        return lotteryToys;
    }

    private String getChances(){
        double carCounter=0;
        double dollCounter=0;
        double legoCounter=0;
        double puzzleCounter=0;
        double robotCounter=0;
        StringBuilder sb = new StringBuilder();
        for(Toy item:lotteryToys){
            if(item.getName().equals("Car")){
                carCounter++;
            }
            if(item.getName().equals("Doll")){
                dollCounter++;
            }
            if(item.getName().equals("Puzzle")){
                puzzleCounter++;
            }
            if(item.getName().equals("Lego")){
                legoCounter++;
            }
            if(item.getName().equals("Robot")){
                robotCounter++;
            }
        }
        double carChance = Math.round((carCounter/lotteryToys.size())*100);
        double dollChance = Math.round((dollCounter/lotteryToys.size())*100);
        double legoChance = Math.round((legoCounter/lotteryToys.size())*100);
        double puzzleChance = Math.round((puzzleCounter/lotteryToys.size())*100);
        double robotChance = Math.round((robotCounter/lotteryToys.size())*100);
        sb.append("Chances: ");
        sb.append("\n");
        sb.append("Car - "+carChance+"%");
        sb.append("\n");
        sb.append("Doll - "+dollChance+"%");
        sb.append("\n");
        sb.append("Lego - "+legoChance+"%");
        sb.append("\n");
        sb.append("Puzzle - "+puzzleChance+"%");
        sb.append("\n");
        sb.append("Robot - "+robotChance+"%");
        sb.append("\n");
        return sb.toString();
    }
}
