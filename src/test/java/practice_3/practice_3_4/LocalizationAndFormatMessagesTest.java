package practice_3.practice_3_4;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationAndFormatMessagesTest {

    @Test
    public void localResourceBundleAndFormatMessages() {
        Locale uk = Locale.UK;

        ResourceBundle msg = ResourceBundle.getBundle("messages", uk);
        String offerPattern = msg.getString("offer");
        String datePattern = msg.getString("dateFormat");

        String offerTxt = MessageFormat.format(offerPattern, "Tea",
                NumberFormat.getCurrencyInstance(uk).format(1.85),
                NumberFormat.getPercentInstance(uk).format(0.06),
                DateTimeFormatter.ofPattern(datePattern, uk).format(ZonedDateTime.of(LocalDateTime.now(),
                        ZoneId.of("Europe/London"))));

        System.out.println(offerTxt);
    }

    @Test
    public void translatedVersionOfResourceBundle() {
        Locale es = Locale.of("es", "MX");

        ResourceBundle msgEs = ResourceBundle.getBundle("messages", es);
        String offerPatternEs = msgEs.getString("offer");


        String offerTxt = MessageFormat.format(offerPatternEs, "Tea",
                NumberFormat.getCurrencyInstance(es).format(1.85),
                NumberFormat.getPercentInstance(es).format(0.06),
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM).localizedBy(es)
                        .format(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Madrid"))));

        System.out.println(offerTxt);
    }

}
