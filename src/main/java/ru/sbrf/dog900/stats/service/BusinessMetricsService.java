package ru.sbrf.dog900.stats.service;

import org.springframework.stereotype.Component;
import ru.sbrf.dog900.stats.dao.Dao;
import ru.sbrf.dog900.stats.model.BusinessMetric;

import java.util.List;

@Component
public class BusinessMetricsService implements StatsService {
    private Dao dao;

    public BusinessMetricsService(Dao dao) {
        this.dao = dao;
    }

    @Override
    public List<BusinessMetric> get(String dateFrom, String dateTo) {
        return dao.get(dateFrom, dateTo);
    }
}
