package org.example;
import okhttp3.Callback;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
/**
 * @author Dilan
 * @created 03/02/2024 - 09:56 am
 */
public class Main {

    private static String url = "https://70bd3ab9ff7a4a9ebca6c3f9f6e06e36.weavy.io/api/users/u256/tokens";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        String bearerToken = "wys_fT64v1TfZi1mAG1xzrPydS2nDvUXj90EzXTY";

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("Response: " + response.body().string());
            }

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }



}
