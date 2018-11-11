package ru.sbrf.dog900.stats.service;

import ru.sbrf.dog900.stats.model.BusinessMetric;

import java.util.List;

public interface StatsService {
    List<BusinessMetric> get(String dateFrom, String dateTo);
}
