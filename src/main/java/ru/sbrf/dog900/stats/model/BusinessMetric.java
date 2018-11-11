package ru.sbrf.dog900.stats.model;

import lombok.*;

@Data
@AllArgsConstructor
public class BusinessMetric {
    String date, consumer, template, channel;
    long count;
}