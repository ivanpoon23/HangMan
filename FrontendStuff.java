import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FrontendStuff {
  int Counter= 0;
  Scanner input = new Scanner(System.in);
  String [] allwords;
  List<String> allword = new ArrayList<>();
  public  void CommandLoop() {
  
    System.out.println("Welcome to hangman!");
    System.out.println("Please input the words you would like to guess from and please"
        + " seperate the words with commas and no spaces");
    allwords = input.nextLine().split(",");
    for(String word: allwords) {

      allword.add(word);
    }
    Word hey = new Word(allword);
    while(!hey.win&&hey.Counter<7) {
      System.out.println("Please input a letter of your guess");
      hey.checkLetter(new showLetter(input.nextLine()));
      System.out.println(hey.showWord());
  }
    if(hey.win) {
      System.out.println("Congrats on winning");
    }else if(!hey.win) {
      System.out.println("Sorry you lost");
      System.out.println("The word was "+ hey.actualWord);
    }
  }
  public static void main(String[]args) {
    FrontendStuff front = new FrontendStuff();
    front.CommandLoop();
  }
}
