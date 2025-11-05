package se.iths.axel.adventuregame.model;

import se.iths.axel.adventuregame.view.UI;

public class HealingRoom implements Room{

    @Override
    public void enterRoom(Player player, UI ui) {
        Wizard wizard = new Wizard("Trollkarl", 1000, 0, 20);
        ui.showMessage("Du klättrar upp en lång stege som tar dig högst upp i ett torn där du stöter på en trollkarl." +
                " Trollkarlen frågar om du vill spela ett spel.");

        String choice = ui.getInput("Vill du? (ja/nej)");

        if (choice.equalsIgnoreCase("ja")){
            int secretNumber = (int) (Math.random() * 3) + 1;
            int guess = Integer.parseInt(ui.getInput("Trollkarl: Du har en gissning att gissa rätt nummer, välj noga mellan 1-3: "));

            if (guess == secretNumber) {
                ui.showMessage("Grattis, du gissade rätt nummer. Jag återställer ditt HP till max!");
                player.setHealth(100);
                ui.showMessage("Ditt HP: " + player.getHealth());
            } else {
                ui.showMessage("Tyvärr, fel nummer.. !!ATTACK!!");
                player.setHealth(player.getHealth() - wizard.getStrength());
                ui.showMessage("Du blir attackerad av trollkarlen..");
                ui.showMessage("Ditt HP: " + player.getHealth());
            }
        }else {
            ui.showMessage("Du går vidare utan att spela trollkarlens spel.");
        }
    }
}
