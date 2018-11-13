package dao2.impl;

import dao2.interfaces.MP3dao;
import dao2.objects.MP3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQLiteMP3 implements MP3dao {
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void insert(MP3 mp3) {
        String sql = "insert into mp3 (name, author) values (:name, :author)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name",mp3.getName());
        parameterSource.addValue("author",mp3.getAuthor());
        jdbcTemplate.update(sql, parameterSource);
    }

    public void insert(List<MP3> mp3List){
        for (MP3 mp3: mp3List){
            insert(mp3);
        }
    }

    public void delete(int id) {
        String sql = "delete from mp3 where id=:id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        jdbcTemplate.update(sql, params);
    }




    public MP3 getMP3byID(int id) {
        String sql = "select * from mp3 where id=:id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return jdbcTemplate.queryForObject(sql,parameterSource,new MP3RowMapper());
    }

    public List<MP3> getMP3byName(String name) {
        return null;
    }

    public List<MP3> getMP3byAuthor(String author) {
        return null;
    }


    public static final class MP3RowMapper implements RowMapper<MP3>{
        public MP3 mapRow(ResultSet resultSet, int i) throws SQLException {
            MP3 mp3 = new MP3();
            mp3.setId(resultSet.getInt("id"));
            mp3.setName(resultSet.getString("name"));
            mp3.setName(resultSet.getString("author"));
            return mp3;
        }
    }
}
