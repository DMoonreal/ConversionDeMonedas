import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Conversion getConversion(String baseCode, String targetCode, double amount) {
        URI uri = URI.create("https://v6.exchangerate-api.com/v6/efb5f045f42de985aa2f4d3d/pair/" + baseCode + "/" + targetCode + "/" + amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(uri).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("Algo salió mal: " + e.getMessage(), e);
        }
    }
}
