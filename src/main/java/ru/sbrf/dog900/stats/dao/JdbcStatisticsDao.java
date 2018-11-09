package ru.sbrf.dog900.stats.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import ru.sbrf.dog900.stats.model.*;

import java.util.Arrays;
import java.util.List;
import static ru.sbrf.dog900.stats.sql.Constants.*;

@Repository
public class JdbcStatisticsDao implements StatisticsDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcStatisticsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BusinessMetric> getBusinessMetrics() {
       return Arrays.asList(
                new BusinessMetric("11.10.2018","SNUIL","2dayReminder","PUSH", 10L),
                new BusinessMetric("12.10.2018","UCP","NewTemplate","SMS", 15L),
                new BusinessMetric("13.10.2018","SNUIL","CreditCardTemplate","PUSH", 20L),
                new BusinessMetric("14.10.2018","UCP","DebitCardTempalte","PUSH", 30L)
        );
        //return jdbcTemplate.queryForList(BUSINESS_METRICS, BusinessMetric.class);
    }

    @Override
    public List<MsgStatus> getMsgStatuses() {
        return null;
    }

    @Override
    public List<WrongClientId> getWrongClientIds() {
        return null;
    }
}
