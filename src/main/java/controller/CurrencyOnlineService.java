
package controller;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import model.Currency;
import org.json.JSONObject;




/**
 *
 * @author saul
 */
public class CurrencyOnlineService {
    
    public static String calculate(Currency inCurrency, Currency outCurrency) 
            throws MalformedURLException, IOException{
        
        URL webService = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/"+ 
                  "currency-api@1/latest/currencies/"+inCurrency.getCode()+
                  "/"+outCurrency.getCode()+".json");
        
        JSONObject jsonObject = new JSONObject(IOUtils.toString(webService, StandardCharsets.UTF_8));
        
        return String.valueOf(inCurrency.getAmount() * 
                jsonObject.getDouble(outCurrency.getCode()) +
                 " " + outCurrency.getSymbol());
       
    }
    
}
