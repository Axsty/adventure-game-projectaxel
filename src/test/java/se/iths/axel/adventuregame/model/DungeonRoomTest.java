package se.iths.axel.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.iths.axel.adventuregame.view.FakeUI;

class DungeonRoomTest {

    @Test
    void enterRoom() {

        DungeonRoom dungeonRoom = new DungeonRoom();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("a");

        Player player = new Player.Builder()
                .name("Axel")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        dungeonRoom.enterRoom(player, fakeUI);

        Assertions.assertTrue(player.hasDefeatedEnemy(), "Ska döda om a");

    }
}