package practice_3.practice_3_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigDecimalClassAndFormatNumericValuesTest {
    double price = 1.85;
    double rate = 0.065;

    double numCustomers = 100000;

    private static Stream<Arguments> localeArgs() {
        return Stream.of(
                Arguments.of(Locale.FRANCE, "1,85\u00A0€", "6,5\u00A0%", "100\u00A0k"),
                Arguments.of(Locale.UK, "£1.85", "6.5%", "100K")
        );
    }

    @Test
    public void comparingBigDecimalOperationWithThePrimitivesOperations() {
        price -= price * rate;
        price = Math.round(price * 100) / 100.0;

        assertEquals(1.73, price);


        BigDecimal priceBD = new BigDecimal(1.85);
        BigDecimal rateBD = new BigDecimal(rate);
        priceBD = priceBD.subtract(priceBD.multiply(rateBD))
                .setScale(2, RoundingMode.HALF_UP);

        assertEquals(new BigDecimal(1.73)
                .setScale(2, RoundingMode.HALF_UP), priceBD);
    }

    @ParameterizedTest
    @MethodSource("localeArgs")
    public void localeNumericValuesFormatting(Locale country, String priceResult, String rateResult, String compactResult) {

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(country);
        NumberFormat percentFormat = NumberFormat.getPercentInstance(country);
        percentFormat.setMaximumFractionDigits(2);
        NumberFormat compactFormat = NumberFormat.getCompactNumberInstance(country, NumberFormat.Style.SHORT);

        String priceText = currencyFormat.format(price);
        String rateText = percentFormat.format(rate);
        String compactText = compactFormat.format(numCustomers);

        assertEquals(priceResult, priceText);
        assertEquals(rateResult, rateText);
        assertEquals(compactResult, compactText);
    }

}
