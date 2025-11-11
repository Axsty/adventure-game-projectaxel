package se.iths.axel.adventuregame.model;

import se.iths.axel.adventuregame.view.UI;

public class DragonRoom implements Room{
    @Override
    public void enterRoom(Player player, UI ui) {
        Dragon dragon = new Dragon("Drake", 100, 1000, 100);

        ui.showMessage("Du klättrar upp för ett berg, framför dig ligger det och sover en drake.");

        while (player.isAlive() && dragon.isAlive())  {
            String choice = ui.getInput("Väljer du att attackera draken? (ja/nej)");
            if (choice.equalsIgnoreCase("ja")){
                player.attack(dragon);
                ui.showMessage("Du attackerar draken..");
                ui.showMessage("Drakens HP: " + dragon.getHealth());
                if (dragon.isAlive()) {
                    dragon.attack(player);
                    ui.showMessage("Draken attackerar dig..");
                    ui.showMessage("Ditt liv: " + player.getHealth());
                }else {
                    ui.showMessage("Draken är död!!");
                    player.addScore(200);
                }
            } else if (choice.equalsIgnoreCase("nej")) {
                ui.showMessage("Du vänder dig om och klättrar ner igen.");
                break;
            }
        }
    }
}

