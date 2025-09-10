package capitulo5.datetime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTimeType {
    public static void main(String args[]) {
        Date date1 = new Date();
        System.out.println(date1.toString());

        Date dNow = new Date();
        SimpleDateFormat ft1 = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft1.format(dNow));

        Date date2 = new Date();
        String str = String.format("%1$s %2$tB %2$td, %2$tY", "Due date:", date2 );
        System.out.println(str);

        SimpleDateFormat ft2 = new SimpleDateFormat ("yyyy-MM-dd");
        String input = "1818-11-11";
        System.out.print(input + " Parses as ");
        Date t;
        try {
            t = ft2.parse(input);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft2);
        }
    }
}
