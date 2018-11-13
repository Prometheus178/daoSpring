package dao.interfaces;

import dao.objects.MP3;

import java.util.List;

public interface MP3dao {
    public void insert(MP3 mp3);
    public void delete(int id);
    void delete(MP3 mp3);
    MP3 getMP3byID(int id);
    List <MP3> getMP3byName(String name);
    List <MP3> getMP3byAuthor(String author);




}
