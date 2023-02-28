import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class Desafio {
    public static void main(String args[]) {
        System.out.println("inicia teste");
        try {

            ImdbApiClient cliente = new ImdbApiClient();
            String json = cliente.getBody("https://imdb-api.com/en/API/Top250Movies/k_hgne65xv");

	        List<? extends Content> lista = new ImdbMovieJsonParser().parse(json);
            
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
            
            for (Content f : lista) {
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

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

