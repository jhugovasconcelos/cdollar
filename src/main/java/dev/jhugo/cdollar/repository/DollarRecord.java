package dev.jhugo.cdollar.repository;

import java.util.List;

public record DollarRecord(String context, List<ValueRecord> value) {}
