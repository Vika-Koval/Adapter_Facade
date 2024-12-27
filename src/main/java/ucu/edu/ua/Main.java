package ucu.edu.ua;

import java.io.IOException;

import ucu.edu.ua.task1.Facebookuser;
import ucu.edu.ua.task1.Facebookuseradapter;
import ucu.edu.ua.task1.Messagesender;
import ucu.edu.ua.task2.Authadapter;
import ucu.edu.ua.task2.DBadapter;
import ucu.edu.ua.task2.Reportbuilder;
import ucu.edu.ua.task3.Company;
import ucu.edu.ua.task3.Companyfacade;

public class Main {

    private static final long ALMOST_NOW = 100;

    private static final long VALID = System.currentTimeMillis() - ALMOST_NOW;

    public static void main(String[] args) {
        Facebookuser facebookUser = new Facebookuser(
                                    "first@gmail.com",
                                    "Ukraine",
                                    VALID
                                    );

        Messagesender messageSender = new Messagesender();

        System.out.println(messageSender.send(
            "Hello!", new Facebookuseradapter(facebookUser), "Ukraine"
            ));

        System.out.println();

        DBadapter db = new DBadapter();
        Authadapter authAdapter = new Authadapter();
        if (authAdapter.authenticate(db)) {
            Reportbuilder br = new Reportbuilder(db);
            System.out.println(br.buildReport());
        }
        Companyfacade facade = new Companyfacade();
        try {
            Company company = facade.getCompanyInfo("ucu.edu.ua");
            System.out.println();
            System.out.println(company);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}