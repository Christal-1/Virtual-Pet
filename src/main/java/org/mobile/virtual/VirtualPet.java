package org.mobile.virtual;

public class VirtualPet {
    private String name;
    private int health;
    private int happiness;

    public VirtualPet(String name) {
        this.name = name;
        this.health = 100;
        this.happiness = 100;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getHappiness() {
        return happiness;
    }

    public void feed(String food) {
        switch (food) {
            case "Carrot":
                if (health < 100) {
                    health += 5; // Carrot gives 5 health points
                    System.out.println(name + " is fed with a Carrot! Health increased slightly.");
                } else {
                    System.out.println(name + " is already full.");
                }
                break;
            case "Steak":
                if (health < 100) {
                    health += 15; // Steak gives 15 health points
                    System.out.println(name + " is fed with a Steak! Health increased significantly.");
                } else {
                    System.out.println(name + " is already full.");
                }
                break;
            case "Apple":
                if (health < 100) {
                    health += 8; // Apple gives 8 health points
                    System.out.println(name + " is fed with an Apple! Health moderately increased.");
                } else {
                    System.out.println(name + " is already full.");
                }
                break;
            case "Fish":
                if (health < 100) {
                    health += 12; // Fish gives 12 health points
                    System.out.println(name + " is fed with Fish! Health increased.");
                } else {
                    System.out.println(name + " is already full.");
                }
                break;
            default:
                System.out.println("Unknown food item.");
                break;
        }
        // Ensure health doesn't exceed 100
        if (health > 100) {
            health = 100;
        }
    }


    public void play() {
        if (happiness < 100) {
            happiness += 10;
            health -= 5; // Playing decreases health a little
            System.out.println(name + " had fun playing! Happiness increased.");
        } else {
            System.out.println(name + " is already happy.");
        }
    }

    public void checkStatus() {
        System.out.println("\n" + name + "'s Status:");
        System.out.println("Health: " + health + "/100");
        System.out.println("Happiness: " + happiness + "/100");
    }

    public void passTime() {
        // Reduce stats over time
        health -= 5;
        happiness -= 5;

        if (health < 0) health = 0;
        if (happiness < 0) happiness = 0;
    }

    public boolean isAlive() {
        return health > 0 && happiness > 0;
    }
}
