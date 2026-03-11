package pos_creditcard;

import java.util.HashMap;
import java.util.Map;

public class BagOfMoney {
    private final Map<Double, Integer> bag = new HashMap<>();
    private final double[] keys = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0};

    /*
    public BagOfMoney(){
        bagOfMoney.put(0.01, 0);
        bagOfMoney.put(0.02, 0);
        bagOfMoney.put(0.05, 0);
        bagOfMoney.put(0.1, 0);
        bagOfMoney.put(0.2, 0);
        bagOfMoney.put(0.5, 0);
        bagOfMoney.put(1.0, 0);
        bagOfMoney.put(2.0, 0);
        bagOfMoney.put(5.0, 0);
        bagOfMoney.put(10.0, 0);
        bagOfMoney.put(20.0, 0);
    }*/

    public BagOfMoney(int[] values){
        for (int i = 0; i < keys.length; i++) {
            bag.put(keys[i], values[i]);
        }
    }

    public Map<Double, Integer> getAmount(){
        return bag;
    }

    public void printAmount(){
        System.out.println("Contingut de la caixa");
        bag.forEach((k, v) -> System.out.println("Key: " + k + ": Value: " + v));
    }
    
    public void addCash(BagOfMoney payment){
        payment.bag.forEach((key, value)->this.bag.merge(key, value, Integer::sum));
    }
    
    public void substractCash(BagOfMoney change){
        if (change == null) return;
        change.bag.forEach((coin, quantity)->this.bag.merge(coin, -quantity, Integer::sum));
    }

    public boolean isEnoughToPay(double bill){ //metodo que sirve para saber si nos pagan lo suficiente parar cubrir la cuenta :)
        double totalPayment = 0;
        for (double key : keys) {
            totalPayment += key * this.getValue(key);
        }
        return totalPayment >= bill;
    }

    public boolean isEnoughCash(BagOfMoney cashBox) {
        for (double key : keys) {
            if (cashBox.getValue(key) < this.getValue(key)){
                return false;
            }
        }
        return true;
    }

    public double getKey(int index){
        return bag.get(keys[index]);
    }

    public int getValue(double key){
        return bag.get(key);
    }





}
