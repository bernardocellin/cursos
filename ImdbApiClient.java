import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ImdbApiClient {

    private HttpClient client;
    
    public ImdbApiClient() {
    	this.client = HttpClient.newHttpClient();
    }
    
    public String makeRequest(String link) {

        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(link))
        .build();
        HttpResponse<String> response;
        
        try {
            response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}


