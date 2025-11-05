package se.iths.axel.adventuregame.model;

import se.iths.axel.adventuregame.view.UI;

public class StrengthRoom implements Room{
    @Override
    public void enterRoom(Player player, UI ui) {
        ui.showMessage("Du kryper in i en grotta. På en pedestal står det en bägare av glas fylld med en vätska.");
        String choice = ui.getInput("Väljer du att dricka av bägaren? (ja/nej)");

        if (choice.equalsIgnoreCase("ja")) {
            ui.showMessage("Det bubblar till i magen.. Du känner dig helt plötsligt mycket starkare!");
            player.setStrength(100);
            ui.showMessage("Din Strength: " + player.getStrength());
        }else {
            ui.showMessage("Du kryper tillbaka ut ur grottan och fortsätter ditt äventyr.");
        }
    }
}
