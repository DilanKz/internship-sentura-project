package org.example;
import okhttp3.*;

import java.io.IOException;
/**
 * @author Dilan
 * @created 03/02/2024 - 09:56 am
 */
public class Main {

    private static final OkHttpClient client = new OkHttpClient();
    private static final String BASE_URL = "http://localhost:8080/api/data";
    private static final String bearerToken = "wys_fT64v1TfZi1mAG1xzrPydS2nDvUXj90EzXTY";
    
    public static String getData(String id) throws IOException {
        String url = BASE_URL + "/" + id;
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String addData(String newData) throws IOException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), newData);
        Request request = new Request.Builder()
                .url(BASE_URL)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .post(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String deleteData(String id) throws IOException {
        String url = BASE_URL + "/" + id;
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .delete()
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String updateData(String id, String updatedData) throws IOException {
        String url = BASE_URL + "/" + id;
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), updatedData);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .put(requestBody)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static void main(String[] args) {

    }


}
