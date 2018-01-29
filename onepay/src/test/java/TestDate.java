import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDate {

    private static Logger log = LoggerFactory.getLogger("WWW");
    @Test
    public void test() {
        log.info("begin...");

        Date now = new Date();
        log.info("now:" + now);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(df.format(now));

        Calendar calendar = Calendar.getInstance();

        Date date = calendar.getTime();
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(df.format(date));

        calendar = Calendar.getInstance();
        calendar.set(1984, 1, 23);
        Lunar lunar = new Lunar(calendar);
        log.info(lunar.toString());


        log.info("end.");
    }

    @Test
    public void seq() {
        int a = 1;
        int b = 1;
        int c = 0;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1984, 0, 23);
        Date birthday = calendar.getTime();
        log.info(df.format(birthday));
        for (int i = 0; i < 30; i++) {
            c = a + b;
            calendar.add(Calendar.DATE, b);
            log.info(df.format(calendar.getTime()) + ":" + i + ":" + c);
            a = b;
            b = c;
        }
    }
}
