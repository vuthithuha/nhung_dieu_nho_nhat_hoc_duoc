package omc.training.api;

import vinid.api.rest.*;

import java.util.Scanner;

public class MainApplicationTest {
    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
        exercise04();

    }

    public static void exercise01() {
        RestMethod method = RestMethod.POST;
        RestHeaders headers = new RestHeaders();
        String hostname = "";
        String path = "";
        RestRequest request = new RestRequest(hostname, path, method);

        headers.add("Authorization", "Basic b25laHMtYWdlbnQ6WjUrQ2IydFQzPWZiNi9SVQ==");
        headers.add("Content-Type", "application/json");

        RestBody body = new RestBody();
        body.add("squadName", "Super hero squad");
        body.add("homeTown", "Metro City");
        body.add("formed", 2016);
        body.add("secretBase", "Super tower");
        body.add("active", true);

        request.setBody(body);
        request.setHeader(headers);

        RestResponse response = request.send();
        System.out.println(body.prettyPrint());
        response.extract().body().prettyPrint();
    }

    public static void exercise02() {
        RestMethod method = RestMethod.POST;
        String hostname = "";
        String path = "";
        RestRequest request = new RestRequest(hostname, path, method);
        RestBody body = new RestBody();
        body.addMapToArray("members", "name", "Molecule Man");
        body.addMapToArray("members", "age", 29);
        body.addMapToArray("members", "secretIdentity", "Dan Jukes");

        request.setBody(body);

        RestResponse response = request.send();
        response.extract().body().prettyPrint();

    }

    public static void exercise03() {
        RestMethod method = RestMethod.POST;
        String hostname = " ";
        String path = "";
        RestRequest request = new RestRequest(hostname, path, method);
        RestBody body = new RestBody();
        body.add("squadName", "Super hero squad");
        body.add("homeTown", "Metro City");
        body.add("formed", 2016);
        body.add("secretBase", "Super tower");
        body.add("active", true);
        body.addMapToArray("members", "name", "Molecule Man");
        body.addMapToArray("members", "age", 29);
        body.addMapToArray("members", "name", "Molecule Man");

        request.setBody(body);


    }

    public static void exercise04() {
        requestOtp();
        verifyOtp();
        getProfile();

    }

    public static void requestOtp() {
        RestMethod method = RestMethod.POST;
        RestHeaders header = new RestHeaders();
        header.add("X-Device-ID", "Device_0118000010");
        header.add("X-RF-Device-ID", "Device_0118000010");
        header.add("Content-Typ", "application/json");

        RestBody body = new RestBody();
        body.add("phone_number", "+84118000010");

        String hostname = "https://api-uat.vinid.dev";
        String path = "/iam/v1/otp/login/request";
        RestRequest request = new RestRequest(hostname, path, method);

        request.setHeader(header);
        System.out.println("requestOtp");
        System.out.println(body.prettyPrint());
    }

    public static void verifyOtp() {
        RestMethod method = RestMethod.POST;

        RestHeaders header = new RestHeaders();
        header.add("X-Device-ID", "Device_0118000010");
        header.add("X-RF-Device-ID", "DD_-RtQcv1CP0v1B1zPC1EYQpclsdCWgDIV_PfA5qXAh3P");
        header.add("Content-Type", "application/json");

        RestBody body = new RestBody();
        body.add("phone_number", "+84118000010");
        body.add("otp", "123456");
        body.add("is_new_install", "false");

        String hostname = "https://api-uat.vinid.dev";
        String path = "/iam/v1/otp/login/verify";
        RestRequest request = new RestRequest(hostname, path, method);
        request.setBody(body);
        request.setHeader(header);

        RestResponse response = request.send();
        System.out.println("verifyOtp");
        System.out.println(body.prettyPrint());
    }

    public static void getProfile() {
        RestMethod method = RestMethod.GET;

        RestHeaders headers = new RestHeaders();
        headers.add("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6InBQWlBpektGc2JVVkpycUViVlVnOSJ9.eyJodHRwczovL3ZpbmlkLm5ldCI6eyJsZXZlbCI6MSwicGhvbmVfbnVtYmVyIjoiKzg0MTE4MDAwMDEwIiwidXNlcl9pZCI6MjAwMjI4NH0sImlzcyI6Imh0dHBzOi8vYXV0aC1xYy5vbmVtb3VudC5kZXYvIiwic3ViIjoiYXV0aDB8NjEyZjBmNGYwYjIzMTgwMDZhNDExNWIxIiwiYXVkIjoiaHR0cHM6Ly9hcGktdWF0LnZpbmlkLmRldi9sZXZlbC0xIiwiaWF0IjoxNjQ1MTU2NTA5LCJleHAiOjE2NDUyNDI5MDksImF6cCI6Ik1KN2ZTY0hKbkdhaUptbU9KaThSeVZzVjJlSEJnY0NEIiwic2NvcGUiOiJvZmZsaW5lX2FjY2VzcyIsImd0eSI6InBhc3N3b3JkIn0.JaubIvgxNzhNFFfLimSO8jd5NKyK0cJDZJ1mLGZ3PLuC7eWxpTWNLDe6kkj_0mZuKzxHJ7AKnQCb5HTQDrXfA6YE9al0s7j4-TS7o6811hFriexIoN66tnfVG8kiuHq3KuzinEemaBCtwbNIq1cdwGIODvjMyjThboC11fBQ9BN67TK5xzwY1dCpJMXvw2wWPPa5s6WXscPzYB_RXyjKo8rdTQdC0kChxYxwLP7tmC862-4485CQU1hbAXuxrm25XZJhubAqhEF2jBIfxuwLYeoVMKQ5rBHbZpvOM6hxLlga_ShEU6CoBxBqRO38oUMV5WIWs9imC_l6Owe1V5L2iw");
        headers.add("X-Device-ID", "Device_0118000010");
        headers.add("Content-Type", "application/json");

        String hostname = "https://api-uat.vinid.dev";
        String path = "/user-profile/v2/me/profile/basic";
        RestRequest request = new RestRequest(hostname, path, method);
        request.setHeader(headers);

        RestResponse response = request.send();
        System.out.println("getProfile");
        response.extract().prettyPrint();
    }


}

