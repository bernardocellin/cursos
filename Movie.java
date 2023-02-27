import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String urlImage;
    private Double rating;
    private Integer year;
    
    public String getTitle() {
    	return this.title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
}

