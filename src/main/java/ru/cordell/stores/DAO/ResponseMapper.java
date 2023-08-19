package ru.cordell.stores.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.cordell.stores.models.Response;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponseMapper implements RowMapper<Response> {
    @Override
    public Response mapRow(ResultSet resultSet, int i) throws SQLException {
        Response response = new Response();
        //response.setId(resultSet.getInt("id"));
        response.setText(resultSet.getString("text"));
        return response;
    }
}
