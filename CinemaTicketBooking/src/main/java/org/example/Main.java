package org.example;


import java.util.Scanner;

public class Main {

    static char[][] seats = new char[5][6];
    static String[] movieNames = {"Superman","Avatar","Minecraft","Inside Out","F1"};

    public static void initializeSeats(){
        for(int i=0; i<5; i++){
            for(int j=0; j<6; j++){
                seats[i][j] = 'O';
            }
        }
    }

    public static void displaySeats(){
        for(int i=0; i<5; i++){
            for(int j=0; j<6; j++){
                System.out.print(seats[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static boolean isValidSeat(int seatNumber){
        int row = (seatNumber /10) - 1;
        int column = (seatNumber % 10) - 1;

        if(row < 0 || row >= 5 || column < 0 || column >= 6){
            System.out.println("Invalid Seat.");
            return false;
        }
        return true;
    }

    public static boolean bookSeat(int seatNumber){
        int row = (seatNumber /10) - 1;
        int column = (seatNumber % 10) - 1;

        if (!isValidSeat(seatNumber)){
            return false;
        }

        if(seats[row][column] == 'O'){
            seats[row][column] = 'X';
            return true;
        }
        else{
            System.out.println("This seat is already taken");
            return false;
        }
    }

    public static boolean cancelBooking(int seatNumber){
        int row = (seatNumber /10) - 1;
        int column = (seatNumber % 10) - 1;

        if (!isValidSeat(seatNumber)){
            return false;
        }

        if(seats[row][column] == 'X'){
            seats[row][column] = 'O';
            return true;
        }
        else{
            System.out.println("This seat is already empty");
            return false;
        }
    }

    public static void showAllMovies(){
        for(int i=0; i<movieNames.length; i++){
            System.out.print(movieNames[i] + " , ");
        }
    }

    public static void availableSeatsNumbers(){
        for(int i=0; i<5; i++){
            for(int j=0; j<6; j++){
                if(seats[i][j] == 'O'){
                    System.out.print((i+1) + "" + (j+1) + "  ");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        initializeSeats();

        Scanner sc = new Scanner(System.in);
        byte opr = 0;

        while (true) {
            System.out.println("Main Menu\n" +
                    "1. Display Seats\n" +
                    "2. Book Seat\n" +
                    "3. Cancel Booking\n" +
                    "4. Show all movies.\n" +
                    "5. Show number of available and booked seats\n" +
                    "0. Exit.\n" +
                    "=======================");

            opr = sc.nextByte();
            if(opr == 0) break;

            switch (opr) {

                case 1:
                    displaySeats();
                    break;

                case 2:
                    int seatToBook;
                    boolean booked;
                    do{
                        System.out.println("Pleas enter the seat number");
                        seatToBook = sc.nextInt();
                        booked = bookSeat(seatToBook);
                    }
                    while (!booked);
                    break;

                case 3:
                    int seatToCancel;
                    boolean cancelled;
                    do{
                        System.out.println("Pleas enter the seat number");
                        seatToCancel = sc.nextInt();
                        cancelled =cancelBooking(seatToCancel);
                    }
                    while (!cancelled);
                    break;

                case 4:
                    showAllMovies();
                    break;

                case 5:
                    availableSeatsNumbers();
                    break;

                case 0:
                    break;
            }

        }
    }
}
