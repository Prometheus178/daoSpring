package dao.impl;

import dao2.interfaces.MP3dao;
import dao.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class SQLiteMP3 implements MP3dao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(MP3 mp3) {
        String sql = "insert into mp3 (name, author) values (?, ?)";
        jdbcTemplate.update(sql, new Object[] {mp3.getName(), mp3.getAuthor()});
    }

    public void insert(List<MP3> mp3List){
        for (MP3 mp3: mp3List){
            insert(mp3);
        }
    }

    public void delete(int id) {
        String sql = "delete from mp3 where id=?";
        int result = jdbcTemplate.update(sql, id);
    }

    public MP3 getMP3byID(int id) {
       return null;
    }

    public List<MP3> getMP3byName(String name) {
        return null;
    }

    public List<MP3> getMP3byAuthor(String author) {
        return null;
    }


    public void insert(dao2.objects.MP3 mp3) {

    }

    public void delete(dao2.objects.MP3 mp3) {

    }
}
