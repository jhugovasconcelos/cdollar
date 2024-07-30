package dev.jhugo.cdollar.data;

import java.util.List;

public record DollarRecord(String context, List<ValueRecord> value) {}
