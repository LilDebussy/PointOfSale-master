package pos_creditcard;

public abstract class ChangeMaker {

    public abstract BagOfMoney change(double amountToPay, BagOfMoney amountHanded, BagOfMoney cashBox);
}

