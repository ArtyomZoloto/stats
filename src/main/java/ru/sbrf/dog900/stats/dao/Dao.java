package ru.sbrf.dog900.stats.dao;

import ru.sbrf.dog900.stats.model.*;

import java.util.List;

public interface Dao {
    List<BusinessMetric> get(String dateFrom, String DateTo);
}
