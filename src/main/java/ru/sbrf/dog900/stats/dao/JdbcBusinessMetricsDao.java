package ru.sbrf.dog900.stats.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.sbrf.dog900.stats.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Repository
public class JdbcBusinessMetricsDao implements Dao {

    @Value("query.metrics")
    private String sql;

    private JdbcTemplate jdbcTemplate;

    public JdbcBusinessMetricsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BusinessMetric> get(String dateFrom, String dateTo) {
/*        return jdbcTemplate.query(
                sql,
                new Object[]{dateFrom,dateTo},
                new BusinessMetricsRowMapper());*/
        return Arrays.asList(
                new BusinessMetric("11.10.2018", "SNUIL", "2dayReminder", "PUSH", 10L),
                new BusinessMetric("12.10.2018", "UCP", "NewTemplate", "SMS", 15L),
                new BusinessMetric("13.10.2018", "SNUIL", "CreditCardTemplate", "PUSH", 20L),
                new BusinessMetric("14.10.2018", "UCP", "DebitCardTempalte", "PUSH", 30L),
                new BusinessMetric("11.10.2018", "SNUIL", "2dayReminder", "PUSH", 10L),
                new BusinessMetric("12.10.2018", "UCP", "NewTemplate", "SMS", 15L),
                new BusinessMetric("13.10.2018", "SNUIL", "CreditCardTemplate", "PUSH", 20L),
                new BusinessMetric("14.10.2018", "UCP", "DebitCardTempalte", "PUSH", 30L));
    }

    private static final class BusinessMetricsRowMapper implements RowMapper<BusinessMetric> {
        public BusinessMetric mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new BusinessMetric(
                    rs.getString("date"),
                    rs.getString("consumer"),
                    rs.getString("template"),
                    rs.getString("channel"),
                    rs.getLong("count"));
        }
    }
}
