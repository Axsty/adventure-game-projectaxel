package se.iths.axel.adventuregame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.axel.adventuregame.view.FakeUI;

import static org.junit.jupiter.api.Assertions.*;

class DragonRoomTest {
    DragonRoom dragonRoom;
    FakeUI fakeUI;
    Player player;
    Dragon dragon;

    @BeforeEach
    public void setUp(){
        dragonRoom = new DragonRoom();
        fakeUI = new FakeUI();
        player = new Player.Builder()
                .name("Axel")
                .health(100)
                .score(0)
                .strength(100)
                .build();
        dragon = new Dragon("Drake", 100, 1000, 100);
    }

    @Test
    void ifPlayerAttacksDragonWithBuff(){
        fakeUI.setInput("ja");
        dragonRoom.enterRoom(player, fakeUI);
        assertEquals(100, player.getHealth());
    }

    @Test
    void ifPlayerDoesNotAttack(){
        fakeUI.setInput("nej");
        dragonRoom.enterRoom(player, fakeUI);
        assertEquals(100, player.getHealth());
    }
}