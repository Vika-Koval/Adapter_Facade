package ucu.edu.ua;

import java.io.IOException;

import ucu.edu.ua.task1.FacebookUser;
import ucu.edu.ua.task1.Facebookuseradapter;
import ucu.edu.ua.task1.MessageSender;
import ucu.edu.ua.task2.AuthAdapter;
import ucu.edu.ua.task2.DBAdapter;
import ucu.edu.ua.task2.ReportBuilder;
import ucu.edu.ua.task3.Company;
import ucu.edu.ua.task3.CompanyFacade;

public class Main {

    private static final long ALMOST_NOW = 100;

    private static final long VALID = System.currentTimeMillis() - ALMOST_NOW;

    public static void main(String[] args) {
        FacebookUser facebookUser = new FacebookUser(
                                    "first@gmail.com",
                                    "Ukraine",
                                    VALID
                                    );

        MessageSender messageSender = new MessageSender();

        System.out.println(messageSender.send(
            "Hello!", new Facebookuseradapter(facebookUser), "Ukraine"
            ));

        System.out.println();

        DBAdapter db = new DBAdapter();
        AuthAdapter authAdapter = new AuthAdapter();
        if (authAdapter.authenticate(db)) {
            ReportBuilder br = new ReportBuilder(db);
            System.out.println(br.buildReport());
        }
        CompanyFacade facade = new CompanyFacade();
        try {
            Company company = facade.getCompanyInfo("ucu.edu.ua");
            System.out.println();
            System.out.println(company);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}