package wunschliste;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class FeedReader {

  public void readIt() {
    try {
      URI feedUri = new URI("http://www.wunschliste.de/xml/atom.pl?user_id=183326&key=093712692730865");
      
      SyndFeedInput input = new SyndFeedInput();
      SyndFeed feed = input.build(new XmlReader(feedUri.toURL()));
  
      for (SyndEntry entry : feed.getEntries()) {
        String fullTitle = entry.getTitle();
        int splitPos = fullTitle.lastIndexOf("-");
        String titleEpisode = fullTitle.substring(0, splitPos);
        String dateTimeChannel = fullTitle.substring(splitPos);
        String channel = dateTimeChannel.substring(dateTimeChannel.lastIndexOf("/") + 2);
        
        splitPos = titleEpisode.lastIndexOf("(");
        String titleSub = titleEpisode.substring(0, splitPos);
        String episode = titleEpisode.substring(splitPos+1);
        
        Date updatedDate = entry.getUpdatedDate();
        System.out.println(updatedDate + " | " + channel + " | " + titleSub + " | " + episode);
      }
      
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
