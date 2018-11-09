package ru.sbrf.dog900.stats.dao;

import ru.sbrf.dog900.stats.model.*;

import java.util.List;

public interface StatisticsDao {
    List<BusinessMetric> getBusinessMetrics();

    List<MsgStatus> getMsgStatuses();

    List<WrongClientId> getWrongClientIds();
}
