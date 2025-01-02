package ucu.edu.ua.task3;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;
import org.json.JSONObject;

public class PDLReader {
    private static final int OK_STATUS_CODE = 200;
    private static final int UNAUTHORIZED_STATUS_CODE = 401;

    public Company getCompanyInfo(String website) throws IOException {
        String apiKey = "";
        URL url = new URL(
        "https://api.peopledatalabs.com/v5/company/enrich?website=" + website
        );
        HttpURLConnection connection = 
                    (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", apiKey);
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == UNAUTHORIZED_STATUS_CODE) {
            System.out.println("I have no PDL API key");
            return new Company();
        } else if (responseCode != OK_STATUS_CODE) {
            System.out.println(
                "Error: Server returned HTTP response code: " + responseCode
                );
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