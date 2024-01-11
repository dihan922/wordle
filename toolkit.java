import java.util.*;

class toolkit {
  // Background color variables for feedback
  public static final String RESET_BG = "\u001B[0m";
  public static final String YELLOW_BG = "\u001B[43m";
  public static final String GREEN_BG	= "\u001B[42m";

  // Returns feedback of word with animation
  public static void processGuess(String guess, String target)
  {
    guess = guess.toUpperCase();
    target = target.toUpperCase();
    
    // Gives green letter priority to letters in correct position
    ArrayList<Character> non_green_letters = new ArrayList<Character>();
    for (int i=0; i<5; i++)
      {
        if (guess.charAt(i) != target.charAt(i))
          {
            non_green_letters.add(target.charAt(i));
          }
      }

    for (int i=0; i<5; i++)
      {
        sleep(500);
        // Green letters
        if (guess.charAt(i) == target.charAt(i))
          {
            System.out.print(GREEN_BG + guess.charAt(i) + RESET_BG + " ");
          }
        // Yellow letters
        else if (non_green_letters.contains(guess.charAt(i)))
          {
            System.out.print(YELLOW_BG + guess.charAt(i) + RESET_BG + " ");
            
            // Gives yellow letter priority to one of any duplicate letters
            Iterator<Character> itr = non_green_letters.iterator();
    
            while (itr.hasNext()) 
              {
                char letter = itr.next();
                if (letter == guess.charAt(i)) 
                  {
                    itr.remove();
                    break;
                  }
              }
          }
        // Gray letters
        else 
          {
            System.out.print(guess.charAt(i) + " ");
          }
      }
    sleep(500);
    System.out.println();
  }

  // Randomly selects word from solutions list in words.java class
  public static String getRandomWord()
    {
      Random r = new Random();
      int index = (1 + r.nextInt(2315));
      return words.solutions.get(index);
    }

  // Prevents cheating by checking if word is in any word list from words.java class
  public static boolean checkIfWord(String word)
    {
      return (words.guesses.indexOf(word) != -1 || words.solutions.indexOf(word) != -1);
    }

  // Sleep function for animation
  public static void sleep(int ms)
  {
    try
      {
        Thread.sleep(ms);
      }
    catch (InterruptedException ex)
      {
        Thread.currentThread().interrupt();
      }
  }
}
