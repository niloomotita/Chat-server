/*
 * Chat Server
 */

/**
 *
 * @author Long, Niloo 
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
       greeted = false;
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
       System.out.println("Username is " +username);
       //return this.username;
   }
   
   public void quit() {
       System.out.println("Bye!");
       System.exit(0);
   }
   
   public void printResult(){
       if(!command.contains(":")){
       System.out.println(username + ":" + command);
       }
   }
   
   public void chat() {
       getUsername();
        
        while (!username.isEmpty()) {
            getCommand();
            switch (command) {
                case ":quit": quit();
                    
                case ":user": getUsername();
   
                default: printResult();
            }
        }    
    }
   
   
   
   public void run() {
       if(!greeted) {
        System.out.println("Welcome to our chatserver");
        greeted = true;
       }
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
