package se.iths.axel.adventuregame.model;


import org.junit.jupiter.api.Test;
import se.iths.axel.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TreasureRoomTest {

    @Test
    void enterRoom(){

        TreasureRoom treasureRoom = new TreasureRoom();
        ForestRoom forestRoom = new ForestRoom();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("ja");

        Player player = new Player.Builder()
                .name("Axel")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        forestRoom.enterRoom(player, fakeUI);
        treasureRoom.enterRoom(player, fakeUI);

        assertTrue(player.hasFoundKey(), "Ska vara true om input är ja");
        assertTrue(player.hasOpenedChest(), "Ska vara true om spelaren har hittat nyckeln och input är ja");

    }
}