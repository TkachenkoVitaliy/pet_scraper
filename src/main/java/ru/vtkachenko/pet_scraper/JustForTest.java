package ru.vtkachenko.pet_scraper;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JustForTest {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.now(clock);

        System.out.println("Date");
        System.out.println(date);
        System.out.println("LocalDateTime");
        System.out.println(localDateTime);

        LocalDateTime newLDT = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        Date newDate = new Date(Timestamp.valueOf(localDateTime).getTime());

        System.out.println();
        System.out.println(newLDT);
        System.out.println(newDate);
    }
}
