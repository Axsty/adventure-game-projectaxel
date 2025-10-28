package se.sprinto.hakan.adventuregame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void attack() {
        Player player = new Player.Builder()
                .name("Axel")
                .health(100)
                .score(0)
                .strength(10)
                .build();

        Enemy enemy = new Enemy("Vätte", 100, 10, 5);

        player.attack(enemy);

        assertEquals(90, enemy.getHealth());
    }
}