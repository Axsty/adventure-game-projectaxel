package se.iths.axel.adventuregame.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.axel.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;


class HealingRoomTest {
    private HealingRoom healingRoom;
    private Player player;
    private FakeUI fakeUI;

    @BeforeEach
    public void setUp(){
        healingRoom = new HealingRoom();
        fakeUI = new FakeUI();
        player = new Player.Builder()
                .name("Axel")
                .health(65)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void ifPlayerSaysNo(){
        fakeUI.setInput("nej");
        healingRoom.enterRoom(player, fakeUI);
        assertEquals(65, player.getHealth());
    }
}