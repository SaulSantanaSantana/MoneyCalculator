
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import view.MainWindow;

/**
 *
 * @author saul
 */
public class ComboBoxController implements ActionListener {
    
    private final Currency inCurrency;
    private final Currency outCurrency;
    private final MainWindow window;

    public ComboBoxController(Currency inCurrency, Currency outCurrency,MainWindow window) 
            throws FileNotFoundException, IOException {
        
        this.window = window;
        this.inCurrency = inCurrency;
        this.outCurrency = outCurrency;
        
        BufferedReader file = new BufferedReader(new FileReader("currencies.txt"));
        String line;
        while((line = file.readLine()) != null){
            window.finalCurrencyMenu.addItem(line);
            window.inicialCurrencyMenu.addItem(line);
        }
        
        window.inicialCurrencyMenu.addActionListener(this);
        window.finalCurrencyMenu.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == window.inicialCurrencyMenu){
            String[] strip0 = window.inicialCurrencyMenu.getSelectedItem().toString().split(", ");
            inCurrency.changeCurrency(strip0[1], strip0[2], strip0[0]);
            
        }else if(ae.getSource() == window.finalCurrencyMenu){
            String[] strip1 = window.finalCurrencyMenu.getSelectedItem().toString().split(", ");
            outCurrency.changeCurrency(strip1[1], strip1[2], strip1[0]);
        }
 
    }
    
    
    
    
}
