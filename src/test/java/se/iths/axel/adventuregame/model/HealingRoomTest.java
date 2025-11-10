package se.iths.axel.adventuregame.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
                .health(60)
                .score(0)
                .strength(10)
                .build();
    }

    @Test
    void ifPlayerSaysYes(){
        fakeUI.setInput("ja");
        healingRoom.enterRoom(player, fakeUI);
        assertEquals(100, player.getHealth());
    }

    @Test
    void ifPlayerSaysNo() {
        fakeUI.setInput("nej");
        healingRoom.enterRoom(player, fakeUI);
        assertEquals(40, player.getHealth());
    }
}