package se.iths.axel.adventuregame;

import se.iths.axel.adventuregame.dao.FileStatisticsDao;
import se.iths.axel.adventuregame.dao.StatisticsDao;
import se.iths.axel.adventuregame.model.Player;
import se.iths.axel.adventuregame.model.StartRoom;
import se.iths.axel.adventuregame.model.Statistics;
import se.iths.axel.adventuregame.util.AppInfo;
import se.iths.axel.adventuregame.service.StatisticsService;
import se.iths.axel.adventuregame.view.ScannerUI;
import se.iths.axel.adventuregame.view.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new ScannerUI();
        ui.showMessage("Välkommen till Äventyrsspelet!");
        AppInfo info = AppInfo.getInstance();
        ui.showMessage(info.getProperty("app.author"));
        ui.showMessage(info.getProperty("app.version"));
        Player player = new Player.Builder()
                .name(ui.getInput("Ange ditt namn: "))
                .health(100)
                .score(0)
                .strength(10)
                .build();

        new StartRoom().enterRoom(player, ui);

        StatisticsDao dao = new FileStatisticsDao();
        dao.save(new Statistics(player.getName(), player.getScore()));

        StatisticsService service = new StatisticsService(dao);
        ui.showMessage("\n--- Topplista ---");
        for (Statistics s : service.getSortedStatistics()) {
            ui.showMessage(s.getPlayerName() + " - " + s.getScore() + " poäng");
        }
    }
}

