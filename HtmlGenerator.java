import java.io.PrintWriter;

public class HtmlGenerator {

    PrintWriter printer;
    
    public HtmlGenerator(PrintWriter printer) {
    	this.printer = printer;
    } 
    
    public void generate(String site) {
        System.out.println("imprimindo" + site);
        printer.print(site);
    }
}

