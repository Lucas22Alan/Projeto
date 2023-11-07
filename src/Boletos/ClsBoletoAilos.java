/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boletos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Lucas
 */
public class ClsBoletoAilos {
    
    public void gerarRequisicao(){
        try {
            String urlDestino="https://apiendpointhml.ailos.coop.br/token";// o id vem gerado da venda quando precisa criar o pix id composto pelo cnpj+id do movimento da venda
            
            String consumerkey="xmynkDSAZcTypdNPqAfWfmdzH9Ea";
            String consumersecret="OaPG5wWyboQnD2fZQtUE0UuP1ZQa";
            String consumerchar=consumerkey+":"+consumersecret;
            String base64enc=Base64.getEncoder().encodeToString(consumerchar.getBytes());
            
            System.out.println(new String(Base64.getDecoder().decode(base64enc)));
            
            URL url= new URL(urlDestino);
            
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            String parametros = "grant_type="+URLEncoder.encode("client_credentials", "UTF-8");
            
              connection.setRequestMethod("POST");
               connection.setRequestProperty("Authorization", "Basic "+base64enc);
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                
                
                 System.out.println("===== Detalhes da Solicitação Antes do Envio =====");
           Map<String, List<String>> headers = connection.getRequestProperties();
                for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                    String headerName = entry.getKey();
                    List<String> headerValues = entry.getValue();
                    for (String value : headerValues) {
                        System.out.println(headerName + ": " + value);
                    }
}
          System.out.println("url: "+connection.getURL());
                connection.setDoOutput(true);



                 OutputStream outputStream = connection.getOutputStream();
                 outputStream.write(parametros.getBytes("UTF-8"));
                 outputStream.flush();
                 outputStream.close();
                 
                 
                  int retorno=connection.getResponseCode();
            
           BufferedReader reader;
            if (retorno >= 200 && retorno < 300) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Exibir a resposta da solicitação
            System.out.println("Response Code: " + retorno);
            System.out.println("Response Body: " + response.toString());
            JSONObject jsonObject = new JSONObject(response.toString());
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClsBoletoAilos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClsBoletoAilos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
