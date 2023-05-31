package com.codecool.mightytextadventure;

public class Player extends Character{

    public int numAtkUpgrades, numDefUpgrades;

    public String[] atkUpgrades = {"Strength", "Agility"};
    public String[] defUpgrades = {"Stamina", "Intellect"};
    public Player(String name) {
        super(name, 100, 0);
        //setting # of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        chooseTrait();
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(xp/4 + numAtkUpgrades*3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 2);

    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 2);
    }

    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait:");
        System.out.println("(1) " + atkUpgrades[ (int)Math.round(Math.random())]);
        System.out.println("(2) " + defUpgrades[ (int)Math.round(Math.random())]);
        //get the player choice
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        //deal with the choice
        if(input == 1){
            GameLogic.printHeading("You chose an offensive trait!");
            numAtkUpgrades++;
        }else{
            GameLogic.printHeading("You chose a defensive trait!");
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
}
