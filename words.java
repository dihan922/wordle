import java.net.http.*;
import java.net.URI;
import java.util.*;

class words 
{
  // Public variables used by other classes
  public static ArrayList<String> solutions;
  public static ArrayList<String> guesses;
  
  public static void createWordLists()
  {
    // Solutions and valid words retrieved from source code of original Wordle
    HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://raw.githubusercontent.com/andrew-t/gaming-wordle/main/words.json"))
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();

    try 
      {
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String jsonData = response.body();
        jsonData = jsonData.replaceAll("\"", "");
        
        String solutions_str = jsonData.split("],")[0];
        String guesses_str = jsonData.split("guesses:")[1];
        
        // Set word lists to text body of website + list clean-up
        ArrayList<String> solutions_lst = new ArrayList<String>(Arrays.asList(solutions_str.split(",")));
        solutions_lst.set(0, "cigar");
        solutions = solutions_lst;
        
        ArrayList<String> guesses_lst = new ArrayList<String>(Arrays.asList(guesses_str.split(",")));
        guesses_lst.set(0, "aahed");
        guesses_lst.set(guesses_lst.size()-1, "zymic");
        guesses = guesses_lst;
      }
      
    catch (Exception e)
      {
        System.err.println("Error");
      }
    }
  
}
