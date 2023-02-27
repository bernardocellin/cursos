import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

public class Desafio {
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

            // List<String> titles = new ArrayList<String>();
            // List<String> images = new ArrayList<String>();

	    List<Movie> lista = new ArrayList<Movie>();
            String [] atributos = jsonFilmes.split("\",");
            // para cada linha
            for (String linha : atributos) {
                // System.out.println(linha);
                Movie filme = new Movie();
                String []propriedades = linha.split(":", 2);
                if (propriedades[0].equals("\"title\"")) {
                    // titles.add(propriedades[1].replace("\"", ""));
                    filme.setTitle(propriedades[1].replace("\"", ""));
                }
                if (propriedades[0].equals("\"image\"")) {
                    // images.add(propriedades[1].replace("\"", ""));
                    filme.setImage(propriedades[1].replace("\"", ""));
                }
                if (propriedades[0].equals("\"rating\"")) {
                    // images.add(propriedades[1].replace("\"", ""));
                    filme.setRating(Double.parseDouble(propriedades[1].replace("\"", "")));
                }
                if (propriedades[0].equals("\"year\"")) {
                    // images.add(propriedades[1].replace("\"", ""));
                    filme.setYear(Integer.parseInt(propriedades[1].replace("\"", "")));
                }
                lista.add(filme);
            }
            
            // for (Movie f : lista) {
            	// System.out.println(f.toString());
            // }
            
            String head =
	    """
	    <!DOCTYPE html>
	    <html>
	    <head>
            <meta charset=\"utf-8\">
	    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
	    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
		+ "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
            </head>
            """;
            
            String body = "<body>";
            
            for (Movie f : lista) {
            	body = body + "<div>";
            	body = body + "<br>";
            	body = body + "<label>Título</label>";
            	body = body + "<label>" + f.getTitle() + "</label>";
            	body = body + "<br>";
            	body = body + "<label>Imagem</label>";
            	body = body + "<img" + " src=\"" + f.getImage() + "></img>";
      	        body = body + "<br>";
            	body = body + "<label>Rating</label>";
            	body = body + "<label>" + f.getRating() + "</label>";
            	body = body + "<br>";
            	body = body + "<label>Year</label>";
            	body = body + "<label>" + f.getYear() + "</label>";
            	body = body + "</div>";
            }
            body = body + "</body>";
            
            
            FileWriter fileWriter = new FileWriter("output.html");
    	    PrintWriter printWriter = new PrintWriter(fileWriter);
            HtmlGenerator generator = new HtmlGenerator(printWriter);
            generator.generate(head+ body+ "</html>");
    	    printWriter.close();
            
            
            //for (String title: titles) {
            //    System.out.println(title);
            //}

            //for (String image: images) {
            //    System.out.println(image);
            //}

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

