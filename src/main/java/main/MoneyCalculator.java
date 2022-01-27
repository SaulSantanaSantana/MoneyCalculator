
package main;

import java.io.IOException;
import model.Currency;
import view.MainWindow;

/**
 *
 * @author saul
 */
public class MoneyCalculator {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        Currency in = new Currency("USD","Dólar Estadounidense","$",0.0);
        Currency out = new Currency("USD","Dólar Estadounidense","$",0.0);
        
        MainWindow frame = new MainWindow(in, out);
    }
     
}
