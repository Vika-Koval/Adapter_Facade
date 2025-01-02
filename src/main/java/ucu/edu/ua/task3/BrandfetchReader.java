package ucu.edu.ua.task3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class BrandfetchReader {

    private static final int FORBIDDEN_STATUS_CODE = 403;
    private static final int OK_STATUS_CODE = 200;

    public Company getCompanyInfo(String website) throws IOException {
        String apiKey = "z8/ZhU+9itoC2F9YkZ1KWbpqDYDeC8QQyO8NStxgSX4=";
        URL url = new URL("https://api.brandfetch.io/v1/company/" + website);
        HttpURLConnection connection =
                        (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == FORBIDDEN_STATUS_CODE) {
            System.out.println(
        "API call failed with status: 403 ( Some API key stuff again )");
            return new Company();
        } else if (responseCode != OK_STATUS_CODE) {
            System.out.println(
                "Error: Server returned HTTP response code: " + responseCode);
            return new Company();
        }

        @SuppressWarnings("resource")
        String text = new Scanner(connection.getInputStream())
                                .useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);

        Company company = new Company();
        company.setName(jsonObject.optString("name"));
        company.setDescription(jsonObject.optString("description"));
        company.setLogo(jsonObject.optString("logo"));

        return company;
    }
}
