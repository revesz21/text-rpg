package com.codecool.mightytextadventure;

import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);
    static Player player;

    public static boolean isRunning;

    //story elements
    public static String[] encounters = {"Battle", "Battle", "Battle", "Battle", "Battle"};
    public static String[] enemies = {"Hogger", "Tiger", "Grizzley", "Undead", "Orc"};

    public static int place = 0, act = 1;
    public static String[] places = {"Elwynn Forest", "Redridge Mountains", "Burning Steppes", "Molten Core", "Stranglethorn Vale", "Silithus", "Ahn'Qiraj", "Hillsbrad Foothills", "Eastern Plaguelands", "Naxxramas", "Shadowmoon Valley", "Blasted Lands", "Black Temple"};

    //method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;
        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter and integer!");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //method to simulate clearing the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    //method to print a separator with length n
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void anythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }

    public static void startGame() {
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Welcome to Azeroth!");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        do {
            clearConsole();
            printHeading("What is your name?");
            name = scanner.next();
            clearConsole();
            printHeading("Your name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                nameSet = true;
            }
        } while (!nameSet);

        player = new Player(name);

        Story.printArea1();

        isRunning = true;
        gameLoop();
    }

    public static void checkAct() {
        if (player.xp >= 3 && act == 1) {
            act = 2;
            place = 1;

            player.chooseTrait();
            Story.printArea2();
            enemies[0] = "Blackrock Gladiator";
            enemies[1] = "Blackrock Hunter";
            enemies[2] = "Cow";
            enemies[3] = "Guard Adams";
            enemies[4] = "Horse";

        } else if (player.xp >= 6 && act == 2) {
            act = 3;
            place = 2;

            player.chooseTrait();
            Story.printArea3();
            enemies[0] = "Black Dragon";
            enemies[1] = "Bone Witch";
            enemies[2] = "Blackrock Raider";
            enemies[3] = "Deathmaw";
            enemies[4] = "Enraged Wyvern";

        } else if (player.xp >= 9 && act == 3) {
            act = 4;
            place = 3;

            player.chooseTrait();
            Story.printArea4();
            enemies[0] = "Garr";
            enemies[1] = "Lucifron";
            enemies[2] = "Ragnaros";
            enemies[3] = "Majordomo";
            enemies[4] = "Magmadar";

        } else if (player.xp >= 12 && act == 4) {

            act = 5;
            place = 4;
            Story.printArea4Outro();
            player.chooseTrait();
            Story.printArea5();
            enemies[0] = "Bloodsail Mage";
            enemies[1] = "Bloodsail Deckhand";
            enemies[2] = "Booty Bay Guard";
            enemies[3] = "Drunken Bruise";
            enemies[4] = "Fleet Master Firallon";

        } else if (player.xp >= 15 && act == 5) {
            act = 6;
            place = 5;

            player.chooseTrait();
            Story.printArea6();
            enemies[0] = "Cenarion Outrider";
            enemies[1] = "Colossus of Ashi";
            enemies[2] = "Colossus of Regal";
            enemies[3] = "Colossus of Zora";
            enemies[4] = "Dredge Striker";

        } else if (player.xp >= 18 && act == 6) {
            act = 7;
            place = 6;

            player.chooseTrait();
            Story.printArea7();
            enemies[0] = "Lord Kri";
            enemies[1] = "Ouro";
            enemies[2] = "Emperor Vek'nilash";
            enemies[3] = "Emperor Vek'lor";
            enemies[4] = "C'thun";

        } else if (player.xp >= 21 && act == 7) {
            act = 8;
            place = 7;

            Story.printArea7Outro();
            player.chooseTrait();
            Story.printArea8();
            enemies[0] = "Tiger";
            enemies[1] = "Monkey";
            enemies[2] = "Zulian Hunter";
            enemies[3] = "Mummy";
            enemies[4] = "Sand Witch";


        } else if (player.xp >= 24 && act == 8) {
            act = 9;
            place = 8;

            player.chooseTrait();
            Story.printArea9();
            enemies[0] = "Captain Ironhill";
            enemies[1] = "Captured Farmer";
            enemies[2] = "Cave Yeti";
            enemies[3] = "Chicken";
            enemies[4] = "Condemned Cleric";

        } else if (player.xp >= 27 && act == 9) {
            act = 10;
            place = 9;

            player.chooseTrait();
            Story.printArea10();
            enemies[0] = "Abomination";
            enemies[1] = "Argent Guard";
            enemies[2] = "Blighthound";
            enemies[3] = "Ghoul";
            enemies[4] = "Carrion Grub";

        } else if (player.xp >= 30 && act == 10) {
            act = 11;
            place = 10;

            Story.printArea10Outro();
            player.chooseTrait();
            Story.printArea11();
            enemies[0] = "Thaddius";
            enemies[1] = "Baron Rivendare";
            enemies[2] = "Maexxna";
            enemies[3] = "Shappiron";
            enemies[4] = "Kel'thuzad";


        } else if (player.xp >= 33 && act == 11) {
            act = 12;
            place = 11;

            player.chooseTrait();
            Story.printArea12();
            enemies[0] = "Dreadlord";
            enemies[1] = "Draenei Refugee";
            enemies[2] = "Dreadmaul Brute";
            enemies[3] = "Doomlord";
            enemies[4] = "Kazzak";

            player.hp = player.maxHp;
        } else if (player.xp >= 36 && act == 12) {
            act = 13;
            place = 12;

            player.chooseTrait();
            Story.printArea13();
            player.hp = player.maxHp;
            //illidan

        }
    }

    public static void randomEncounter() {
        int encounter = (int) (Math.random() * encounters.length);

        if (encounters[encounter].equals("Battle")) {
            randomBattle();
        } else if (encounters[encounter].equals("Rest")) {
            //rest
        } else {
            //shop
        }
    }

    public static void continueJourney() {
        checkAct();
        if (act != 13) {
            randomEncounter();
        }
    }

    public static void characterInfo() {
        clearConsole();
        printHeading("CHARACTER INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);


        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }
        anythingToContinue();
    }

    public static void randomBattle() {
        clearConsole();
        printSeparator(60);
        System.out.println("You have encountered a creature. You'll have to fight it!");
        printSeparator(60);
        anythingToContinue();
        battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));

    }

    public static void battle(Enemy enemy) {
        while (true) {
            clearConsole();
            printHeading(enemy.name + "\nHP:" + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP:" + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action:");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
            int input = readInt("-> ", 3);

            if (input == 1) {
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                if (dmgTook < 0) {
                    dmg -= dmgTook / 2;
                    dmgTook = 0;
                }
                if (dmg > 0) {
                    //dmg = 0;
                    player.hp -= dmgTook;
                    enemy.hp -= dmg;
                    clearConsole();
                    printHeading("BATTLE");
                    System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                    printSeparator(30);
                    System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                    anythingToContinue();
                    if (player.hp <= 0) {
                        playerDied();
                        break;
                    } else if (enemy.hp <= 0) {
                        clearConsole();
                        printHeading("You defeated, " + enemy.name + "!");
                        player.xp += enemy.xp;
                        System.out.println("You earned " + enemy.xp + " XP!");
                        anythingToContinue();
                        break;
                    }
                }
            } else if (input == 2) {
                //potion
            } else {
                clearConsole();
                if (Math.random() * 10 + 1 <= 3.5) {
                    printHeading("You ran away from " + enemy.name + "!");
                    anythingToContinue();
                    break;
                } else {
                    printHeading("You did not manage to escape.");
                    int dmgTook = enemy.attack();
                    System.out.println("In your hurry you took " + dmgTook + " damage!");
                    anythingToContinue();
                    if (player.hp <= 0) {
                        playerDied();
                    }
                }

            }
        }
    }

    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action:");
        printSeparator(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    public static void playerDied(){
        clearConsole();
        printHeading("You died...");
        isRunning = false;
    }

    public static void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1) {
                continueJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }
}
