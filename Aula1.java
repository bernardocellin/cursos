import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class Aula1 {
    public static void main(String args[]) {
        System.out.println("inicia teste");
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_hgne65xv"))
            .build();

            HttpResponse<String> response =
            client.send(request, BodyHandlers.ofString());
            String jsonFilmes = response.body();
            // System.out.println(response.body());

            List<String> titles = new ArrayList<String>();
            List<String> images = new ArrayList<String>();

            String [] atributos = jsonFilmes.split("\",");
            // para cada linha
            for (String linha : atributos) {
                // System.out.println(linha);
                String []propriedades = linha.split(":", 2);
                if (propriedades[0].equals("\"title\"")) {
                    titles.add(propriedades[1].replace("\"", ""));
                }
                if (propriedades[0].equals("\"image\"")) {
                    images.add(propriedades[1].replace("\"", ""));
                }
            }
            
            for (String title: titles) {
                System.out.println(title);
            }

            for (String image: images) {
                System.out.println(image);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

