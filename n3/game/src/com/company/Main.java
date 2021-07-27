package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        if(args.length<3){
            System.out.println("not enough arguments");
            return;
        }
        if(args.length%2==0){
            System.out.println("even number of arguments");
            return;
        }
        if(Game.duplicates(args)){
            System.out.println("there are duplicates");
            return;
        }
        Game game = new Game(args);
        System.out.println("enter your move");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num == 0){
            return;
        }
        game.playerMove(num);
    }
}
