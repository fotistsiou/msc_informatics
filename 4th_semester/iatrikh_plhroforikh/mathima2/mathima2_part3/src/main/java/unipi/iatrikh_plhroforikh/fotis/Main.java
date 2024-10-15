package unipi.iatrikh_plhroforikh.fotis;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        // Use the HttpRequest method directly - json and array-json api
        String response = get("https://www.boredapi.com/api/activity");
        String response2 = get("https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata");
        System.out.println(response);
        System.out.println(response2);

        // Use the HttpRequest method within get2 for json api
        get2("https://www.boredapi.com/api/activity");

        // Use the HttpRequest method within get3 for array-json api
        get3("https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata");
    }

    // HttpRequest GET request using java.net.http library
    public static String get(String uri) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // GET request to the specified URI and parses the JSON response using com.google.gson library.
    public static void get2(String uri) {
        String response = get(uri);
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        System.out.println(jsonObject.get("activity"));
    }

    // GET request to the specified URI and parses the JSON array response using com.google.gson library.
    public static void get3(String uri) {
        String response = get(uri);
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        if(jsonObject.get("meals").isJsonArray()) {
            JsonArray jsonArray = jsonObject.get("meals").getAsJsonArray();
            if (jsonArray.get(0).isJsonObject()) {
                JsonObject jsonObject2 = jsonArray.get(0).getAsJsonObject();
                System.out.println(jsonObject2.get("strMeal").getAsString());
            }
        }
    }
}
