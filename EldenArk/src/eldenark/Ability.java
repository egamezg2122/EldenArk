package eldenark;

/**
 *
 * @author egame
 *
 */

public class Ability {

    Character mainCharacter;

    Character enemy;

    String abilitiesWarrior[] = {"Martillo de Thor", "Carga de ariete", "Grito de combate", "Doble filo", "Salto heroico"};

    String abilitiesMage[] = {"Bola de fuego", "Traslación", "Nova de Escarcha", "Clima de Trueno", "Lunargenta"};

    String abilitiesPriest[] = {"Infusión de poder", "Punición", "Salto de fe", "Levitación", "Rezo desesperado"};

    public Ability(Character mainCharacter, Character enemy) {

        this.mainCharacter = mainCharacter;

        this.enemy = enemy;

        if (mainCharacter.getRole().equals("Warrior")) {

            warriorAbility(enemy, mainCharacter);

        } else if (mainCharacter.getRole().equals("Mage")) {

            mageAbility(enemy, mainCharacter);

        } else {

            priestAbility(mainCharacter);

        }

    }

    public void showAbilities() {
        
        if (mainCharacter.getRole().equals("Warrior")) {

            for (int i = 0; i < ((mainCharacter.getLevel() / 5) + 2); i++) {

            System.out.println(abilitiesWarrior[i]);

            }

        } else if (mainCharacter.getRole().equals("Mage")) {

            for (int i = 0; i < ((mainCharacter.getLevel() / 5) + 2); i++) {

            System.out.println(abilitiesMage[i]);

            }

        } else {

            for (int i = 0; i < ((mainCharacter.getLevel() / 5) + 2); i++) {

            System.out.println(abilitiesPriest[i]);

            }

        }
        
    }

    // Warrior
    public void warriorAbility(Character enemy, Character mainCharacter) {

        int option;

        boolean control = false;

        do {

            System.out.println("Que habilidad quieres usar?");

            showAbilities();
            
            option = Teclat.llegirInt();

            if ((option < (mainCharacter.getLevel() / 5) + 2) && option >= 1) {

                control = true;

            } else {

                System.out.println("The ability is not avilable, caldo de pollo");

            }

        } while (!control);

        switch (option) {

            case 1:
                enemy.setHp(enemy.getHp() - 40);

                mainCharacter.setMp(mainCharacter.getMp() - 5);

                break;

            case 2:
                enemy.setHp(enemy.getHp() - 50);

                mainCharacter.setMp(mainCharacter.getMp() - 10);

                break;

            case 3:
                enemy.setHp(enemy.getHp() - 60);

                mainCharacter.setMp(mainCharacter.getMp() - 15);

                break;

            case 4:
                enemy.setHp(enemy.getHp() - 70);

                mainCharacter.setMp(mainCharacter.getMp() - 20);

                break;

        }

    }

    // Priest
    public void priestAbility(Character mainCharacter) {

        int option;

        boolean control = false;

        do {

            System.out.println("Que habilidad quieres usar?");

            showAbilities();
            
            option = Teclat.llegirInt();

            if ((option < (mainCharacter.getLevel() / 5) + 2) && option >= 1) {

                control = true;

            } else {

                System.out.println("The ability is not avilable, caldo de pollo");

            }

        } while (!control);

        switch (option) {

            case 1:
                mainCharacter.setHp(mainCharacter.getHp() + 40);

                mainCharacter.setMp(mainCharacter.getMp() - 5);

                break;

            case 2:
                mainCharacter.setHp(mainCharacter.getHp() + 50);

                mainCharacter.setMp(mainCharacter.getMp() - 10);

                break;

            case 3:
                mainCharacter.setHp(mainCharacter.getHp() + 60);

                mainCharacter.setMp(mainCharacter.getMp() - 15);

                break;

            case 4:
                mainCharacter.setHp(mainCharacter.getHp() + 70);

                mainCharacter.setMp(mainCharacter.getMp() - 20);

                break;

        }

    }

    public void mageAbility(Character enemy, Character mainCharacter) {

        int option;

        boolean control = false;

        do {

            System.out.println("Que habilidad quieres usar?");

            showAbilities();
            option = Teclat.llegirInt();

            if ((option < (mainCharacter.getLevel() / 5) + 2) && option >= 1) {

                control = true;

            } else {

                System.out.println("The ability is not avilable, caldo de pollo");

            }

        } while (!control);

        switch (option) {

            case 1:
                enemy.setHp(enemy.getHp() - 40);

                mainCharacter.setMp(mainCharacter.getMp() - 5);

                break;

            case 2:
                enemy.setHp(enemy.getHp() - 50);

                mainCharacter.setMp(mainCharacter.getMp() - 10);

                break;

            case 3:
                enemy.setHp(enemy.getHp() - 60);

                mainCharacter.setMp(mainCharacter.getMp() - 15);

                break;

            case 4:
                enemy.setHp(enemy.getHp() - 70);

                mainCharacter.setMp(mainCharacter.getMp() - 20);

                break;

        }

    }

}
