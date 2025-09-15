package sectionA;

import java.util.ArrayList;
import java.util.Scanner;

public class SeriesManager {
    private static final ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        splashScreen();

        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series");
            System.out.println("(2) Search for a series");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addSeries();
                case 2 -> searchSeries();
                case 3 -> updateSeriesAgeRestriction();
                case 4 -> deleteSeries();
                case 5 -> viewAllSeries();
                case 6 -> {
                    System.out.println("Exiting application. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void splashScreen() {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("***************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String input = scanner.nextLine();
        if (!input.equals("1")) {
            System.out.println("Exiting application. Goodbye!");
            System.exit(0);
        }
    }

    private static void addSeries() {
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age Restriction: ");
        int age = scanner.nextInt();

        System.out.print("Enter Number of Episodes: ");
        int episodes = scanner.nextInt();
        scanner.nextLine(); // consume newline

        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);

        System.out.println("Series added successfully!");
        pauseForUser();
    }

    private static void searchSeries() {
        System.out.print("Enter Series Name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getSeriesName().equalsIgnoreCase(name)) {
                System.out.println("Series found: " + series);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series not found.");
        }
        pauseForUser();
    }

    private static void updateSeriesAgeRestriction() {
        System.out.print("Enter Series ID to update age restriction: ");
        String id = scanner.nextLine();

        boolean found = false;
        for (SeriesModel series : seriesList) {
            if (series.getSeriesId().equalsIgnoreCase(id)) {
                System.out.print("Enter new Age Restriction: ");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // consume newline
                series.setSeriesAge(newAge);
                System.out.println("Series age restriction updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Series not found.");
        }
        pauseForUser();
    }

    private static void deleteSeries() {
        System.out.print("Enter Series ID to delete: ");
        String id = scanner.nextLine();

        boolean removed = seriesList.removeIf(series -> series.getSeriesId().equalsIgnoreCase(id));

        if (removed) {
            System.out.println("Series deleted successfully!");
        } else {
            System.out.println("Series not found.");
        }
        pauseForUser();
    }

    private static void viewAllSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
        } else {
            System.out.println("\nSeries Report - 2025");
            System.out.println("***************************************");
            for (SeriesModel series : seriesList) {
                System.out.println(series);
            }
        }
        pauseForUser();
    }

    private static void pauseForUser() {
        System.out.println("\nPress Enter to return to the menu...");
        scanner.nextLine();
    }
}
