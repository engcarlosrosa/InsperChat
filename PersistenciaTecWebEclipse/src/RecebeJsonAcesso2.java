import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RecebeJsonAcesso {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
	
	
    HttpClient client = HttpClients.createDefault();
    HttpGet request = new HttpGet("http://localhost:8080/PersistenciaTecWebEclipse/jsonAcesso");


    HttpResponse resp = client.execute(request);

    if( resp.getStatusLine().getStatusCode() == 200) {
        InputStreamReader stream = new InputStreamReader(resp.getEntity().getContent());
        BufferedReader br = new BufferedReader(stream);
        String line;
        while ( (line = br.readLine()) != null ) {
            System.out.println(line);
            JSONObject jsonObject;
            JSONParser parser = new JSONParser();
            long id;
            JSONObject data;
            String matricula;
            String nome;
            String nivelDeEntrada;
            long ano;
            long mes;
            long dia;
            String dataString;
            
            try {
            	jsonObject = (JSONObject) parser.parse(new FileReader("C:\\Users\\user\\Documents\\GitHub\\PersistenciaTecWebEclipse\\src\\acesso.json"));
            	
            	id = (long) jsonObject.get("id");
            	data = (JSONObject) jsonObject.get("data");
            	matricula = (String) jsonObject.get("matricula");
            	nome = (String) jsonObject.get("nome");
            	nivelDeEntrada = (String) jsonObject.get("nivelDeEntrada");
            	
            	JSONObject data2 = (JSONObject) jsonObject.get("data");
            	ano = (long) data2.get("year");
            	mes = (long) data2.get("month");
            	dia = (long) data2.get("dayOfMonth");
            	
            	System.out.printf("id: %s\nAno: %s\nMes: %s\nDia: %s\nMatricula: %s\nNome: %s\nNivelDeEntrada: %s\n", 
            			id, ano, mes, dia, matricula, nome, nivelDeEntrada);
            		/*	
            	System.out.printf("id: %s\nMatricula: %s\nNome: %s\nNivelDeEntrada: %s\n", 
            			id, matricula, nome, nivelDeEntrada);*/
            } catch (FileNotFoundException e){
            	e.printStackTrace();
            } catch (IOException e){
            	e.printStackTrace();
            } catch (ParseException e) {
            	e.printStackTrace();
            }
        }
    }else{
    	System.out.println("Pagina não encontrada");
    }
  }
}

