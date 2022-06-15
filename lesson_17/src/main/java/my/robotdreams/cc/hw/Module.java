package my.robotdreams.cc.hw;

import java.util.List;
import java.util.Random;

public class Module {
    public static List<String> SUPPORTED_CURRENCIES = List.of("USD", "EUR", "JPY", "CHF");


    public String processPayment(Payment payment)
            throws InvalidPaymentCurrencyException, InvalidPaymentAmountException, BankProcessingFailedException, InvalidClientID {

        if (!SUPPORTED_CURRENCIES.contains(payment.getCurrency())) {
            throw new InvalidPaymentCurrencyException(String.format("Currency %s not supported", payment.getCurrency()));
        }

        if (payment.getPaymentAmount() <= 0) {
            throw new InvalidPaymentAmountException("Negative or zero payment amount.");
        }

        if (payment.getClientID().length() < 5) {
            throw new InvalidClientID("Wrong clientID number, must be more 5 chars long.");
        }
        return requestBankProcessing(payment.getPaymentAmount());
    }

    public String requestBankProcessing(int paymentAmount) throws BankProcessingFailedException {
        // Some bank communication magic here
        int statusCode;
        if (paymentAmount > 0) {
            Random random = new Random();
            statusCode = random.nextInt(10);
            if (statusCode > 5) {
                throw new BankProcessingFailedException(String.format("Bank returned result code %s", statusCode));
            }
            return "trx_4knfsf4gs412355";
        } else {
            statusCode = -1;
            throw new BankProcessingFailedException(String.format("Bank returned result code %s", statusCode));
        }

    }


}