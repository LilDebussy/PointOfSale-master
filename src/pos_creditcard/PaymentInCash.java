package pos_creditcard;

public class PaymentInCash extends Payment {
  BagOfMoney amountHanded;
  ChangeMaker changeType;
  BagOfMoney cashBox;

  public PaymentInCash(BagOfMoney amountHanded, double amountToPay, ChangeMaker ct, BagOfMoney cashBox) {
    super(amountToPay);
    this.amountHanded = amountHanded;
    this.changeType = ct;
    this.cashBox = cashBox;
  }

  private double change() {
      cashBox.addCash(amountHanded);
  }


  @Override
  public void print() {
    System.out.printf("\nAmount handed : %.2f\nChange : %.2f\n", amountHanded, change());
  }
}
