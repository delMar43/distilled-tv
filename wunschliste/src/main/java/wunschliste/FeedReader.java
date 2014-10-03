package wunschliste;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class FeedReader {

  private static final DateFormat SDF = SimpleDateFormat.getDateTimeInstance();
  
  public void readIt() {
    try {
      URI feedUri = new URI("http://www.wunschliste.de/xml/atom.pl?user_id=183326&key=093712692730865");
      
      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(feedUri.toURL()));
  
//      for (SyndEntry entry : feed.getEntries()) {
//        Date updatedDate = entry.getUpdatedDate();
//        System.out.println(SDF.format(updatedDate) + ": " + entry.getTitle());
//      }
      
      System.out.println(feed);
      
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (FeedException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
