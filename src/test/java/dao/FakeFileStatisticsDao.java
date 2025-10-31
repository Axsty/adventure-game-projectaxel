package dao;

import se.iths.axel.adventuregame.dao.StatisticsDao;
import se.iths.axel.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;

public class FakeFileStatisticsDao implements StatisticsDao {

    @Override
    public void save(Statistics stat) {

    }

    @Override
    public List<Statistics> loadAll() {
        return new ArrayList<>(List.of(
                new Statistics("Axel", 1000),
                new Statistics("Johan", 200),
                new Statistics("Fredrik", 700),
                new Statistics("Peter", 100)
        ));
    }
}
