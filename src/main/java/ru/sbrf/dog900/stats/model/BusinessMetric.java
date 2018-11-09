package ru.sbrf.dog900.stats.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class BusinessMetric {
    String date, consumer, template, channel;
    long count;
}