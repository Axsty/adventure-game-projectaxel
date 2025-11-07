package se.iths.axel.adventuregame.model;

import se.iths.axel.adventuregame.view.UI;

public class HealingRoom implements Room{

    @Override
    public void enterRoom(Player player, UI ui) {
        Wizard wizard = new Wizard("Trollkarl", 1000, 0, 20);
        ui.showMessage("Du klättrar upp en lång stege som tar dig högst upp i ett torn där du stöter på en trollkarl.");
        String choice = ui.getInput("Trollkarlen: Vill du att jag healar dig till fullt HP? (ja/nej/usch)");

        if (choice.equalsIgnoreCase("ja")){
            ui.showMessage("-HEAL-");
            player.setHealth(100);
            ui.showMessage("Ditt HP: " + player.getHealth());
        }else if (choice.equalsIgnoreCase("nej")) {
            ui.showMessage("Trollkarlen: Stick härifrån!");
        } else if (choice.equalsIgnoreCase("usch")) {
            wizard.attack(player);
            ui.showMessage("Trollkarlen: ATTACK");
            ui.showMessage("Ditt HP: " + player.getHealth());
        }
    }
}
