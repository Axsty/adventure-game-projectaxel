package se.iths.axel.adventuregame.dao;

import se.iths.axel.adventuregame.model.Statistics;

import java.util.List;

public interface StatisticsDao {
    void save(Statistics stat);

    List<Statistics> loadAll();
}

