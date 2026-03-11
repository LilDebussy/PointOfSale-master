package pos_creditcard;

public class GreedyChange extends ChangeMaker {
    //falta mirar QUAN posem els diners que ens donen a la cashBox, si en aquesta classe, en la abstracta o en PaymentInCash
    @Override
    public BagOfMoney change(double bill, BagOfMoney amountHanded, BagOfMoney cashBox) {
        //afegir addCash de amountHanded nigga

        cashBox.addCash(amountHanded);

        if(!amountHanded.isEnoughToPay(bill)){
            System.out.println("El client no ha pagat suficient");
            return null;
        }
        double totalPaid = 0;
        double[] keys = {0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0};
        for (double key : keys) {
            totalPaid += key * amountHanded.getAmount().get(key);
        }
        double changeAmount = totalPaid - bill;
        if (changeAmount == 0){
            System.out.println("Pagament exacte. Res a tornar!");
        }

        System.out.println("Canvi a tornar: " + changeAmount);

        int[] changeNeeded = new int[keys.length];
        for(int i = keys.length - 1; i >= 0; i--){//we will look for each coin(key) if it is needed and how much of it is actually needed.
            int available = cashBox.getAmount().get(keys[i]);
            int needed = 0;
            while(changeAmount >= keys[i] && available > 0){
                needed++;
                available--;
                changeAmount -= keys[i];
            }
            changeNeeded[i] = needed;
        }
        BagOfMoney change = new BagOfMoney(changeNeeded);

        if(!change.isEnoughCash(cashBox)){
            System.out.println("No hi ha suficients diners a la caixa.");
            return null;
        }
        cashBox.substractCash(change);
        return change;
    }
}
