
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Currency;
import view.MainWindow;

/**
 *
 * @author saul
 */
public class CurrencyController implements DocumentListener {

    private Currency inCurrency;
    private Currency outCurrency;
    private MainWindow window;

    public CurrencyController(Currency inCurrency, Currency outCurrency, MainWindow window) {
        this.inCurrency = inCurrency;
        this.outCurrency = outCurrency;
        this.window = window;
        
        window.currencyInput.getDocument().addDocumentListener(this);
    }
    
    @Override
    public void insertUpdate(DocumentEvent de) {
        inCurrency.setValue(Double.parseDouble(window.currencyInput.getText()));
        try {
            window.result.setText(CurrencyOnlineService.calculate(inCurrency, outCurrency));
        } catch (IOException ex) {
            Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        
        if(window.currencyInput.getText().equals("")){
            
            window.result.setText(String.valueOf(0.0)+outCurrency.getSymbol());
            inCurrency.setValue(0.0);
            
        }else{
            inCurrency.setValue(Double.parseDouble(window.currencyInput.getText()));
            try {
                window.result.setText(CurrencyOnlineService.calculate(inCurrency, outCurrency));
            } catch (IOException ex) {
                Logger.getLogger(CurrencyController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void changedUpdate(DocumentEvent de) {}
    
}
