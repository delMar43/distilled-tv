package wunschliste;


public class Starter {

  // public static void main(String[] args) throws UnirestException, IOException
  // {
  // HttpResponse<String> resp =
  // Unirest.get("http://www.wunschliste.de/ajax/episodentermine.pl").field("episode_id",
  // "591714").asString();
  //
  // System.out.println(resp.getBody());
  //
  // Unirest.shutdown();
  // }

  public static void main(String[] args) throws Exception {
    FeedReader reader = new FeedReader();
    reader.readIt();
  }

}
