package se.iths.axel.adventuregame.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.axel.adventuregame.dao.FileStatisticsDao;
import se.iths.axel.adventuregame.model.Statistics;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MockStatisticsServiceTest {
    @Mock
    private FileStatisticsDao fileStatisticsDao;
    @InjectMocks
    private StatisticsService statisticsService;

    @Test
    void getSortedStatistics() {

        List<Statistics> unsortedList = new ArrayList<>();
                unsortedList.add(0, new Statistics("Axel", 1000));
                unsortedList.add(1, new Statistics("Johan", 200));
                unsortedList.add(2, new Statistics("Fredrik", 700));
                unsortedList.add(3, new Statistics("Peter", 100));

        Mockito.when(fileStatisticsDao.loadAll()).thenReturn(unsortedList);
        List<Statistics> sortedList = statisticsService.getSortedStatistics();

        assertEquals("Axel", sortedList.get(0).getPlayerName());
        assertEquals("Fredrik", sortedList.get(1).getPlayerName());
        assertEquals("Johan", sortedList.get(2).getPlayerName());
        assertEquals("Peter", sortedList.get(3).getPlayerName());
    }
}
