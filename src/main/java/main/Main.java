package main;

import dao.impl.SQLiteMP3;
import dao.objects.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        MP3 mp3 = new MP3();
        mp3.setName("Walking on a dream");
        mp3.setAuthor("Empire of the Sun");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SQLiteMP3 sqLiteMP3 = (SQLiteMP3) context.getBean("sqlite");
        //sqLiteMP3.insert(mp3);
        //sqLiteMP3.delete(4);

        System.out.println(sqLiteMP3.getMP3byID(4));

    }
}
