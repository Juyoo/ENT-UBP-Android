package com.ent_ubp_android.app.exchange.serveur;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class SingletonUbpRestTemplate {

    //Instance Singleton
    private static SingletonUbpRestTemplate instance = new SingletonUbpRestTemplate();

    public static final String BASE_URL = "http://192.168.43.201:8080/api/";
    private String token;


    private SingletonUbpRestTemplate(){}

    //Récupère l'instance de restTemplate ou la créer
    public static SingletonUbpRestTemplate getRestTemplate() {
        if(instance == null){
            instance = new SingletonUbpRestTemplate();
        }
        return instance;
    }

    public <T> T getForObject(String url, Class<T> responseType) throws RestClientException {
        // ajouter le header avec le token
        RestTemplate restTemplate = new RestTemplate();
        //add the jackson message converter
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(10 * 1000);
        ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setReadTimeout(10 * 1000);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        //Make the request, marshaling the response from Json to an array of T
        return restTemplate.getForObject(url, responseType);

        // conserver le token retourné par le restTemplate
    }

    public <T> T postForObject(String url, Object object, Class<T> responseType){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate.postForObject(url, object, responseType);
    }


}
