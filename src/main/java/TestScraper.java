import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class TestScraper {


    //@Bean
    public static void scrape() {
        try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_78)) {
            final HtmlPage page = webClient.getPage("https://www.trickstercards.com/game/");
            //Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
            //page.getElementsByIdAndOrName("Bridge");
            System.out.println(page.getBody().getTextContent());
            System.out.println(page.getElementsByIdAndOrName("Bridge"));
            final String pageAsXml = page.asXml();
            //Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

            final String pageAsText = page.asText();
            //Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public static void main(String[] args) {
        scrape();
    }
}
