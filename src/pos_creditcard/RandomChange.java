package pos_creditcard;

public class RandomChange extends ChangeMaker {

    @Override
    public BagOfMoney change(double bill, BagOfMoney amountHanded, BagOfMoney cashBox) {
        cashBox.addCash(amountHanded);

        if(amountHanded.isEnoughToPay(bill))
        {

        }

        Math.random();

    }
}
