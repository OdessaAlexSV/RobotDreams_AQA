package my.robotdreams.cc.hw;

public class BankProcessingFailedException extends Exception {
    public BankProcessingFailedException(int statusCode) {
        super(String.format("Bank returned result code %s", statusCode));
        paymentErrorCodeExplanation(statusCode);
    }

    private static void paymentErrorCodeExplanation(int statusCode) {
        switch (statusCode) {
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