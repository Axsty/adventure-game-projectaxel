package se.sprinto.hakan.adventuregame.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.sprinto.hakan.adventuregame.view.FakeUI;


class ForestRoomTest {

    @Test
    void enterRoom() {

        ForestRoom forestRoom = new ForestRoom();

        FakeUI fakeUI = new FakeUI();
        fakeUI.setInput("nej");

        Player player = new Player.Builder()
                .name("Axel")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        forestRoom.enterRoom(player, fakeUI);

        Assertions.assertTrue(player.hasFoundKey(), "Ska hitta nyckel om ja");
    }
}