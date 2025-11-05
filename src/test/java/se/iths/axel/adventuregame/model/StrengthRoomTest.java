package se.iths.axel.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.axel.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class StrengthRoomTest {
    private StrengthRoom strengthRoom;
    private FakeUI fakeUI;
    private Player player;

    @BeforeEach
    public void setUp(){
        strengthRoom = new StrengthRoom();
        fakeUI = new FakeUI();
        player = new Player.Builder()
                .name("Axel")
                .health(100)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void ifPlayerDrinks() {
        fakeUI.setInput("ja");
        strengthRoom.enterRoom(player, fakeUI);
        assertEquals(100, player.getStrength());
    }

    @Test
    void ifPlayerDoesNotDrink(){
        fakeUI.setInput("nej");
        strengthRoom.enterRoom(player, fakeUI);
        assertEquals(10, player.getStrength());
    }
}