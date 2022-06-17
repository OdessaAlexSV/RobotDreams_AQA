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
        preparedData.add(new Payment(5, "UAH","12456"));
        preparedData.add(new Payment(5, "USD","1245"));
        preparedData.add(new Payment(10, "USD","12456"));

        Module newPayment = new Module();

        for (Payment payment : preparedData ) {
            System.out.println("\nInput data: " + payment.toString());
            try {
                System.out.println("Payment is successfully handled." +
                        "\nResult code is : " + newPayment.processPayment(payment));
            } catch (InvalidPaymentCurrencyException | InvalidPaymentAmountException | InvalidClientID e) {
                System.out.println(e.getMessage());

            } catch (BankProcessingFailedException e) {
                e.printStackTrace();
                System.out.println("Payment is failed.\n" + e.getMessage() + ".");
            }
        }
    }
}
