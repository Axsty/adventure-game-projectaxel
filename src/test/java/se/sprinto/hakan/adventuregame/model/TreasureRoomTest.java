package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;

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

        Assertions.assertTrue(player.hasFoundKey(), "Har hittat om ja");
        Assertions.assertTrue(player.hasOpenedChest(), "ja om hittat nyckeln");

    }
}