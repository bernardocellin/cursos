import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class HtmlgGenerator {

    PrintWriter printer;
    
    public HtmlGenerator(PrintWriter printer) {
    	this.printer = printer;
    } 
    
    public void generate(String site) {
        System.out.println("imprimindo" + site);
        printWriter.print(site);
    }
}

