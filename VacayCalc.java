//Olivia Mirly
//HW 11
//This program calculates the cost of a vacation based on number of people and amenities

import java.util.Scanner;

public class VacayCalc {

    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        double total = 0.00;

        System.out.println("Welcome to Ocean Mules Tropical Resort!" +
                "\nHow many guests will be in your party? ");
        double[] guests = new double[input.nextInt()];

        System.out.println("And how many nights will you be staying? ");
        int nights = input.nextInt();

        for(int i = 0; i < guests.length; i++) {
            System.out.println("Start entering details for guest #" + (i + 1));
            guests[i] = calculateRoomCost(nights);
            guests[i] += calculateMealPlan(nights);
            guests[i] += getActivitiesCost();
            total += guests[i];
            System.out.println("\n---------------------------------");
        }

        System.out.printf("\nEstimated total cost of your trip: $%.2f", total);
        System.out.printf("\nAverage nightly cost per person: $%.2f", avgCostPerGuest(guests));
    }
    public static double calculateRoomCost(int nights) {
        Scanner rInput = new Scanner(System.in);

        System.out.println("Room options: " +
                "\n1. Standard room w/ no view: $100/night" +
                "\n2. Luxury room w/ view: $200/night" +
                "\n3. Luxury room w/balcony: $300/night" +
                "\nPlease enter your choice: ");
        int choice = rInput.nextInt();

        return nights * choice * 100.00;
    }

    public static double calculateMealPlan(int nights) {
        Scanner mInput = new Scanner(System.in);

        System.out.println("Meal plan options: " +
                "\n1. Lunch and dinner only: $65/night" +
                "\n2. Three meals a day: $150/night" +
                "\n3. Three meals a day w/ drinks: $225/night" +
                "\n4. No meal plan: $0/night" +
                "\nPlease enter your choice: ");
        int choice = mInput.nextInt();

        switch(choice) {
            case 1:
                return nights * 65.00;
            case 2:
                return nights * 150.00;
            case 3:
                return nights * 225.00;
            default:
                return 0.00;
        }
    }

    public static double getActivitiesCost() {
        Scanner aInput = new Scanner(System.in);
        int choice = 0;
        double sum = 0;

        while(choice != 6) {
            System.out.println("Activity options (you may select multiple):" +
                    "\n1. Scuba Adventure: $300" +
                    "\n2. Island Shopping Hop: $100" +
                    "\n3. Paddle Boarding: $125" +
                    "\n4. Deep Sea Fishing: $500" +
                    "\n5. Beach Sitting: $0" +
                    "\n6. That's all -- done!" +
                    "\nEnter you choice: ");
            choice = aInput.nextInt();

            switch (choice) {
                case 1:
                    sum += 300.00;
                    break;
                case 2:
                    sum += 100.00;
                    break;
                case 3:
                    sum += 125.00;
                    break;
                case 4:
                    sum += 500.00;
                    break;
                default:
                    sum += 0.00;
            }
        }

        return sum;
    }

    public static double avgCostPerGuest(double[] guests) {
        double sum = 0;

        for(int i = 0; i < guests.length; i++) {
            sum += guests[i];
        }

        return sum/guests.length;
    }

}