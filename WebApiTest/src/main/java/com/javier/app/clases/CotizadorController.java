package com.javier.app.clases;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController //Controlador Rest
public class CotizadorController {

	@Autowired
	private RestTemplate restTemplate;

	//Diferenrtes String con las API y las KEY incluidas
	String urlDolar ="https://api.cambio.today/v1/quotes/EUR/USD/json?quantity=1&key=4453|2m3OUSg*x^rBUaNRYw~Kbu5JrLHBMNdN";
	String urlEuro = "https://api.cambio.today/v1/quotes/EUR/EUR/json?quantity=1&key=4453|2m3OUSg*x^rBUaNRYw~Kbu5JrLHBMNdN";
	String urlReal = "https://api.cambio.today/v1/quotes/EUR/BRL/json?quantity=1&key=4453|2m3OUSg*x^rBUaNRYw~Kbu5JrLHBMNdN";

	@GetMapping(value = "/cotizacion/dolar")
	public List<Object> cotizacionDolar() { //Listado de tipo Object

		HttpHeaders headers = new HttpHeaders(); 
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
		Object objects = restTemplate.exchange(urlDolar,HttpMethod.GET,entity, Object.class);
		//Te llamo a la URL que te indico para el dolar....poe medio de GET...le paso los valores
		//de entity para el tema la cabecera (headers está ahí arriba)....y le paso el OBjectt.

		return Arrays.asList(objects); //Me retorna esto que convierto como lista....
	}
	
	@GetMapping(value = "/cotizacion/euro")
	public List<Object> cotizacionEuro() {
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        Object objects = restTemplate.exchange(urlEuro,HttpMethod.GET,entity, Object.class);

		return Arrays.asList(objects);
	}
	
	@GetMapping(value = "/cotizacion/real")
	public List<Object> cotizacionReal() {
		
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        Object objects = restTemplate.exchange(urlReal,HttpMethod.GET,entity, Object.class);

		return Arrays.asList(objects);
	}

}
