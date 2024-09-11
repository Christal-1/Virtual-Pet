package org.mobile.virtual;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Virtual Pet game!");
        System.out.print("Enter your pet's name: ");
        String petName = scanner.nextLine();

        VirtualPet pet = new VirtualPet(petName);
        boolean gameOn = true;

        while (gameOn) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Feed " + pet.getName());
            System.out.println("2. Play with " + pet.getName());
            System.out.println("3. Check " + pet.getName() + "'s status");
            System.out.println("4. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character left by nextInt()

            switch (choice) {
                case 1:  // Feed Pet
                    System.out.println("Choose a food to feed your pet:");
                    System.out.println("1. Carrot");
                    System.out.println("2. Steak");
                    System.out.println("3. Apple");
                    System.out.println("4. Fish");
                    System.out.print("Enter your choice: ");

                    int foodChoice = scanner.nextInt();
                    scanner.nextLine();  // Consume newline character left by nextInt()
                    String food;

                    // Determine the food based on user input
                    switch (foodChoice) {
                        case 1:
                            food = "Carrot";
                            break;
                        case 2:
                            food = "Steak";
                            break;
                        case 3:
                            food = "Apple";
                            break;
                        case 4:
                            food = "Fish";
                            break;
                        default:
                            System.out.println("Invalid choice! Feeding with default food: Carrot.");
                            food = "Carrot";  // Default to Carrot if invalid choice
                            break;
                    }

                    pet.feed(food);  // Feed the pet with the selected food
                    break;

                case 2:  // Play with Pet
                    pet.play();
                    break;

                case 3:  // Check Pet's Status
                    pet.checkStatus();
                    break;

                case 4:  // Quit
                    gameOn = false;
                    break;

                default:  // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            pet.passTime();

            if (!pet.isAlive()) {
                System.out.println("\nOh no! " + pet.getName() + " has passed away...");
                gameOn = false;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
