package my.robotdreams.cc.hw;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by asvidersky on 6/13/2022.
 */

@Getter
@Setter
@AllArgsConstructor
public class Payment {
    private int paymentAmount;
    private String currency;
    private String clientID;

    @Override
    public String toString() {
        return "Payment{" +
                "paymentAmount=" + paymentAmount +
                ", currency='" + currency + '\'' +
                ", clientID='" + clientID + '\'' +
                '}';
    }
}
