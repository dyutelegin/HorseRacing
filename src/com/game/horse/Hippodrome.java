package com.game.horse;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private static List<Horse> horses;

    public List<Horse> getHorses(){
        return horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }
    public static Hippodrome game;

    public void run() throws Exception {
        for (int i = 1; i <= 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move() {
        for (Horse horse: Hippodrome.horses){
            horse.move();
        }
    }
    public void print() {
        for (Horse horse: Hippodrome.horses){
            horse.print();
        }
        for (int i = 1; i<=10; i++){
            System.out.println();
        }
    }
    public Horse getWinner(){
        Horse winner = null;
        for (Horse horse: Hippodrome.horses){
            if (winner == null) winner = horse;
            if (winner.getDistance()<horse.getDistance()) winner = horse;
        }
        return winner;
    }
    public void printWinner(){
        Horse horse = getWinner();
        System.out.println("Winner is " + horse.getName() + "!");
    }
    public static void main(String[] args){
        game = new Hippodrome(new ArrayList<>());
        Horse horse1 = new Horse("Ivan", 3.0, 0.0);
        Horse horse2 = new Horse("Barzoy", 3.0, 0.0);
        Horse horse3 = new Horse("Bivaliy", 3.0, 0.0);
        Horse horse4 = new Horse("Lider", 3.0, 0.0);
        horses = new ArrayList<>();
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        horses.add(horse4);
        try{
            game.run();
        }
        catch(Exception e){
        }
        game.printWinner();
    }
}
