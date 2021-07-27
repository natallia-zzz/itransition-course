package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Game {
    private String[] moves;
    private int move;
    private byte[] hmac_key;
    private byte[] hmac_output;
    private int length;
    public Game(String[] args){
        moves = args;
        this.length = args.length;
        SecureRandom rand = new SecureRandom();
        hmac_key = rand.generateSeed(128/8);
        move = ThreadLocalRandom.current().nextInt(1, length + 1);
        hmac_generator(Integer.valueOf(move).toString());
        System.out.println("HMAC: " + byteArrayToHex(hmac_output));
        print(args);
    }
    public void playerMove(int plMove){
        if(plMove < 0|| plMove > length){
            System.out.println("move out of range");
            return;
        }
        System.out.println("your move:" + moves[plMove-1]);
        System.out.println("computer move:" + moves[move-1]);
        if(plMove == move){
            System.out.println("its a tie!");
        }
        else if(IntStream.of(winnerList()).anyMatch(x -> x == plMove)){
            System.out.println("you win!");
        }
        else{
            System.out.println("you lose");
        }
        System.out.println("HMAC key: " + byteArrayToHex(hmac_key));
    }
    private void hmac_generator(String message){
        try{
            Mac sha256_hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(hmac_key, "HmacSHA256");
            sha256_hmac.init(secret_key);
            hmac_output = sha256_hmac.doFinal(message.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }
    private int[] winnerList(){
        int[] wins = new int[(length-1)/2];
        if(move <= (length+1)/2){
            for(int i = 0; i < (length-1)/2;i++){
                wins[i] = move + i + 1;
            }
        } else{
            for(int i = 0; i < (length-1)/2;i++){
                if(move + i + 1 > length) {
                    wins[i] = (move + i + 1) % length;
                }
                else{
                    wins[i] = move + i + 1;
                }
            }
        }
        return wins;
    }

    public static boolean duplicates(final String[] List)
    {
        Set<String> lump = new HashSet<String>();
        for (String i : List)
        {
            if (lump.contains(i)) return true;
            lump.add(i);
        }
        return false;
    }
    public static void print(String[] args){
        System.out.println("Available moves:");
        for(int i = 1; i < args.length+1; i++){
            System.out.println(i+":"+args[i-1]);
        }
        System.out.println("0:exit");
    }
    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02X", b));
        return sb.toString();
    }
}
