package ru.cordell.stores.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ResponseDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*public void create(String response) {
        jdbcTemplate.update("INSERT INTO responses VALUES(1, ?)", response);
    }*/

    public String show() {
        return "d";/*jdbcTemplate.query("SELECT * FROM posts WHERE (id = ? AND inThread = 0)");*/
    }

    /*public String getResponse(int id){
        return jdbcTemplate.query("SELECT * FROM posts WHERE (id = ?)", new Object[]{id}, new Mapper())
                .stream().findAny().orElse(null);
    }*/

    /*public String showResponse(int id){
        return jdbcTemplate.query("SELECT * FROM posts WHERE (id = ? AND inThread = 0)", new Object[]{id}, new PostMapper())
                .stream().findAny().orElse(null);
    }*/

}
