import java.util.Random;
import java.util.ArrayList;
import java.util.List;
class showLetter{
  String letter = "_ ";
  String realString;
  
  public showLetter(String letter) {
    realString = letter;
  }
  public void showLeter() {
    letter = realString;
  }
}
public class Word {
  Random rand = new Random();
  String[]word;
  int totalGuesses =0;
  int Counter;
  int correctLetters = totalGuesses - Counter;
  String hang = "";
  List<String> allWords;
  ArrayList <showLetter> stuff = new ArrayList<>();
  boolean win = false;
  String actualWord = "";
     
  
  
  
  
  public Word(List<String> allwords) {
    allWords = allwords;
    actualWord = allWords.get(rand.nextInt(0, allwords.size()));
    word =actualWord.split("");
    for(int i = 0;i<word.length;i++) {
      showLetter newLetter = new showLetter(word[i]);
      stuff.add(newLetter);
    }
  }
  
  public void checkLetter(showLetter letter) {
    boolean addCounter = true;
    totalGuesses ++;
    for (int i =0; i<word.length; i++) {
      if(letter.realString.equals(word[i])) {
        stuff.get(i).showLeter();
        addCounter = false;
        correctLetters++;
      }
    }
    if(addCounter) {
      Counter++;
      addHangMan();
    }
    win = (correctLetters == stuff.size())&&totalGuesses>0;
  }
  public void addHangMan() {
    if(Counter == 1) {
      hang+= "   —\n"
          + "|     |\n"
          + "   —";
    }
    if(Counter == 2) {
      hang+="\n";
      hang+= "\\";
    }
    if(Counter == 3) {
      hang +="  |";
  
      
    }
    
    if(Counter == 4) {
      hang +="  /";
    }
    
    if(Counter == 5) {
      hang+="\n  /";
         
    }
    
    if(Counter == 6) {
      hang +=" \\";
      
    }
    
  }
  public String showWord() {
    String returnValue = hang;
    returnValue+= "\n";
    for (showLetter letter: stuff) {
      returnValue+= letter.letter +" ";
    }
    return returnValue;
  }

}


