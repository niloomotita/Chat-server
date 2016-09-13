/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Long-PC
 */
package chatserver;
import java.util.Scanner;

public class CommandInterpreter {
   private String command; //Command list :user|:quit
   private String username; //Store username
   private Boolean greeted;
   
   public CommandInterpreter() {
       command = null;
       username = null;
   }
   
   Scanner inp = new Scanner(System.in);
   
   public void getCommand() {
       command = inp.next();
       command += inp.nextLine();
       //return this.command;
   }
   
   public void getUsername() {
       System.out.print("Input username: ");
       username = inp.next();
       //return this.username;
   }
   
   public void quit() {
       System.out.println("Bye!");
       System.exit(0);
   }
   
   public void chat() {
        getUsername();
        System.out.println("Username is " +username);
        while (!username.isEmpty()) {
            getCommand();
            switch (command) {
                case ":quit": quit();
                    
                case ":user": run();
   
                default: System.out.println(username + ":" + command);
            }
        }    
    }
   
   public void run() {
       System.out.println("Welcome to our chatserver");
       while (true) {
        getCommand();   
        switch (command) {
            case ":user": chat();
            
            case ":quit": quit();
            
            default: System.out.println("Invalid Command");
        }
      }
   }
}
