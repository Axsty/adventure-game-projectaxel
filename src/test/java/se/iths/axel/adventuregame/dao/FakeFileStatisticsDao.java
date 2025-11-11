package se.iths.axel.adventuregame.dao;

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
        List<Statistics> unsortedList = new ArrayList<>();
        unsortedList.add(new Statistics("Axel", 1000));
        unsortedList.add(new Statistics("Johan", 200));
        unsortedList.add(new Statistics("Fredrik", 700));
        unsortedList.add( new Statistics("Peter", 100));
        return unsortedList;
    }
}
