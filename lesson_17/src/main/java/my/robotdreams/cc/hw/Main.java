package my.robotdreams.cc.hw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asvidersky on 6/13/2022.
 */

public class Main {
    public static void main(String[] args) {
        List<Payment> preparedData = new ArrayList<>();
        preparedData.add(new Payment(0, "USD","12456"));
        preparedData.add(new Payment(-1, "USD","12456"));
        preparedData.add(new Payment(0, "UAH","1245"));
        preparedData.add(new Payment(10, "USD","12456"));

        Module newPayment = new Module();

        for (Payment payment : preparedData ) {
            System.out.println("\nInput data: " + payment.toString());
            try {
                System.out.println("Payment is successfully handled." +
                        "\nResult code is : " + newPayment.processPayment(payment));
            } catch (InvalidPaymentCurrencyException e) {
                System.out.println(e.getMessage());

            } catch (InvalidPaymentAmountException e) {
                System.out.println(e.getMessage());

            } catch (BankProcessingFailedException e) {
                e.printStackTrace();
                System.out.println("Payment is failed.\n" + e.getMessage() + ".");
                paymentErrorCodeExplanation(e.getMessage());

            } catch (InvalidClientID e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void paymentErrorCodeExplanation(String errorMessage) {
        int numCode = Integer.parseInt(errorMessage.substring(26));
        switch (numCode) {
            case 6:
                System.out.println("Not enough sum in the account.");
                break;
            case 7:
                System.out.println("Wrong clientID.");
                break;
            case 8:
                System.out.println("Account is blocked.");
                break;
            case 9:
                System.out.println("Required item is unavailable.");
                break;
            default:
                System.out.println("Negative or zero payment amount.");
        }
    }

}
