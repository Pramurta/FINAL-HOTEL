package com.company;
import java.io.Serializable;
import java.util.Date;

public class CreditCard  implements Serializable{
    public static final long serialVersionUID = 6718354633157623043L;
    private String cardHolderName;
    private String creditCardNumber;
    private Date expiryDate;
    // The name from the guest class will be used here for the name of the holder right now just using string



    public CreditCard(String cardHolderName, String creditCardNumber, Date expiryDate ) {
        this.cardHolderName = cardHolderName;
        this.creditCardNumber = creditCardNumber;
        this.expiryDate = expiryDate;

    }

    public String getCreditCardnumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber){
        this.creditCardNumber=creditCardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }



    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void displayCreditCardDetails(){
        System.out.println("Card holder name: "+cardHolderName);
        System.out.println("Credit Card number: "+creditCardNumber);
        System.out.println("Expiry date of credit card: "+expiryDate);
    }
}
