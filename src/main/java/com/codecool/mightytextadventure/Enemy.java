package com.codecool.mightytextadventure;

public class Enemy extends Character{
    int playerXp;
    public Enemy(String name, int playerXp){
        super(name, (int) (Math.random()*playerXp + playerXp/3 + 5), (int) (Math.random()*(5) + 1));
        this.playerXp = playerXp;
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(playerXp/4 + 1) + xp/4 + 5);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(playerXp/4 + 1) + xp/4 + 3);
    }
}
