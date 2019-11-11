package com.brainacad;

import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;


public class RestTest{

    private static final String URL="https://reqres.in/";

    @Test//GET метод
    public void checkGetResponseStatusCode() throws IOException {
        String endpoint="/api/users";

        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");

         int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 200", 200, statusCode);
    }


    @Test//GET метод
    public void checkGetResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";

        HttpResponse response = HttpClientHelper.get(URL+endpoint,"page=2");

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    @Test//POST метод
    public void checkPostResponseStatusCode() throws IOException {
        String endpoint="/api/users";

        //создаём тело запроса
        String requestBody="{\"name\": \"test1\",\"job\": \"test1\"}";

        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);

        //получаем статус код из ответа
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);
        Assert.assertEquals("Response status code should be 201", 201, statusCode);
    }

    @Test//POST метод
    public void checkPostResponseBodyNotNull() throws IOException {
        String endpoint="/api/users";


        //создаём тело запроса
        String requestBody="{\"name\": \"test1\",\"job\": \"test1\"}";

        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);
        Assert.assertNotEquals("Body shouldn't be null", null, body);
    }

    //TODO: напишите по тесткейсу на каждый вариант запроса на сайте https://reqres.in
    //TODO: в тескейсах проверьте Result Code и несколько параметров из JSON ответа (если он есть)

    @Test
    public void checkPutResponseStatusCode() throws IOException {
        String endpoint = "/api/users";

        String requestBody="{\"name\": \"test1\",\"job\": \"leader\"}";

        HttpResponse response = HttpClientHelper.put(URL + endpoint, requestBody);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);

    }

    @Test
    public void checkPutResponseBodyNotNull(){
        String endpoint = "/api/users";

        /*-----*/


    }

    @Test
    public void checkDeleteResponseStatusCode() throws IOException {
        String endpoin = "/api/users";

        HttpResponse response = HttpClientHelper.delete(URL + endpoin);


        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Response Code : " + statusCode);


    }


    @Test
    public void sendPostRegisterUser() throws IOException {
        String endpoint = "/api/register";

        String requestBody="{\"email\": \"test@test.gmail\",\"password\": \"test\"}";

        HttpResponse response = HttpClientHelper.post(URL+endpoint,requestBody);

        //Конвертируем входящий поток тела ответа в строку
        String body=HttpClientHelper.getBodyFromResponse(response);
        System.out.println(body);

    }

}
