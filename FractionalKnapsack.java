import java.util.*;

class Item{
    int profit=0,weight=0;
    Item(int profit, int weight){
        this.profit=profit;
        this.weight=weight;
    }
}

public class FractionalKnapsack{

    public static void main(String[] args){
        Item[] arr={new Item(30,5), new Item(40 ,10),new Item(45,15),new Item(77,22),new Item(90,25)};
        int capacity=60;
        double ans=getMaxProfit(arr,capacity);
        System.out.println(ans);
    }

    public static double getMaxProfit(Item[] arr, int capacity){

        Arrays.sort(arr,(item1,item2)->
            Double.compare((double)item2.profit/item2.weight,(double)item1.profit/item1.weight)
        );

        double maxProfit=0;

        for(Item i:arr){
            int currW=i.weight;
            int currP=i.profit;
            if(capacity-currW>=0){
                capacity-=currW;
                maxProfit+=currP;
            }
            else{
                double fraction=(double)capacity/currW;
                maxProfit+=fraction*currP;
                break;
            }
        }
        return maxProfit;
    }
}