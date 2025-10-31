package se.iths.axel.adventuregame.service;

import dao.FakeFileStatisticsDao;
import org.junit.jupiter.api.Test;
import se.iths.axel.adventuregame.model.Statistics;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsServiceTest {

    @Test
    void getSortedStatistics() {
        FakeFileStatisticsDao fakeFileStatisticsDao = new FakeFileStatisticsDao();
        StatisticsService service = new StatisticsService(fakeFileStatisticsDao);

        List<Statistics> sortedList = service.getSortedStatistics();

        assertEquals("Axel", sortedList.get(0).getPlayerName());
        assertEquals("Fredrik", sortedList.get(1).getPlayerName());
        assertEquals("Johan", sortedList.get(2).getPlayerName());
        assertEquals("Peter", sortedList.get(3).getPlayerName());


    }
}