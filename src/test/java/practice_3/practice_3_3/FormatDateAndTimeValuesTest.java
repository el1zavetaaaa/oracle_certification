package practice_3.practice_3_3;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDateAndTimeValuesTest {

    @Test
    public void localDate() {
        LocalDate today = LocalDate.now();

        System.out.println(today);
        DayOfWeek dayInOneYear = today.plusYears(1).getDayOfWeek();

        System.out.println(dayInOneYear);
    }

    @Test
    public void localTime() {
        LocalTime teaTime = LocalTime.of(17, 30);

        System.out.println(teaTime);
        Duration timeGap = Duration.between(LocalTime.now(), teaTime);

        System.out.println(timeGap);
        System.out.println(timeGap.toMinutes());
        System.out.println(timeGap.toHours());
        System.out.println(timeGap.toMinutesPart());
    }

    @Test
    public void localDateTime() {
        LocalDateTime tomorrowTeaTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(17, 30));

        System.out.println(tomorrowTeaTime);
    }

    @Test
    public void zonedDateTime() {
        LocalDateTime tomorrowTeaTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(17, 30));

        ZoneId london = ZoneId.of("Europe/London");
        ZoneId katmandu = ZoneId.of("Asia/Katmandu");

        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowTeaTime, london);
        ZonedDateTime katmanduTime = londonTime.withZoneSameInstant(katmandu);

        System.out.println(katmanduTime);
        System.out.println(katmanduTime.getOffset());
    }

    @Test
    public void formatDateAndTime() {
        Locale uk = Locale.UK;
        String datePattern = "EE' , 'd' of 'MMMM yyyy' at 'HH:mm z";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(datePattern, uk);

        String timeTxt = dateFormat.format(getKatmanduDateTime());

        System.out.println(timeTxt);

    }

    private ZonedDateTime getKatmanduDateTime() {
        LocalDateTime tomorrowTeaTime = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.of(17, 30));

        ZoneId london = ZoneId.of("Europe/London");
        ZoneId katmandu = ZoneId.of("Asia/Katmandu");

        ZonedDateTime londonTime = ZonedDateTime.of(tomorrowTeaTime, london);
        System.out.println(londonTime);

        ZonedDateTime katmanduTime = londonTime.withZoneSameInstant(katmandu);

        return katmanduTime;
    }
}
