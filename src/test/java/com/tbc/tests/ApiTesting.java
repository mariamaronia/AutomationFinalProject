package com.tbc.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTesting {

    @Test
    public void CheckStatusOfApi(){
        String baseURL = "https://reqres.in/api/users?page=2";
        Response response = RestAssured.get(baseURL);
        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200,"სტატუს კოდი არ არის 200");
    }


    @Test
    public void checkResponseTime() {
        //ვამოწმებ 5 წამზე ნაკლები სჭირდება თუ არა რესპონსის მიღებას
        String baseURL = "https://reqres.in/api/users?page=2";
        long startTime = System.currentTimeMillis();
        Response response = RestAssured.get(baseURL);
        long endTime = System.currentTimeMillis();
        long durationInSeconds = (endTime - startTime) / 1000;
        Assert.assertTrue(durationInSeconds <= 5, "პასუხი დაგვიანდა, დრო: " + durationInSeconds + " წამი");

    }
}
