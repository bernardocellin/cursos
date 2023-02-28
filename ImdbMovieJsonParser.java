import java.util.ArrayList;
import java.util.List;

public class ImdbMovieJsonParser implements JsonParser{
    
    public List<? extends Content>parse(String json) {
        List<Movie> lista = new ArrayList<Movie>();
        String [] atributos = json.split("\",");
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
        return lista;
    }
}


