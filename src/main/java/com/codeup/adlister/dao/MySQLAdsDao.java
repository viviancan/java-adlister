package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;
    private List<Ad> adsList;


    public MySQLAdsDao(Config config) {
        try {
            System.out.println("making a connection");
            //TODO: Review registerDriver method
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database!", e);

        }

    }

    @Override
    public List<Ad> all() {
        Statement statement = null;
        String selectQuery = "SELECT * FROM ads";
         List<Ad> ads = new ArrayList<>();


        System.out.println("getting all of the ads!");

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectQuery);


            while (rs.next()) {
                System.out.println("Here's an ad:");
                System.out.println("  id: " + rs.getLong("id"));
                System.out.println("  title: " + rs.getString("title"));
                System.out.println("  description: " + rs.getString("description"));

                Ad ad = new Ad(
                        rs.getLong("id"),
                        1,
                        rs.getString("title"),
                        rs.getString("description")
                );

                ads.add(ad);

            }
            return ads;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot list movies!", e);

        }

    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES "
                    + "(" + ad.getUserId() + ", "
                    + "'" + ad.getTitle() + "', "
                    + "'" + ad.getDescription() + "')";

            System.out.println(insertQuery);

            statement.executeUpdate(insertQuery, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            System.out.println(rs.getLong(1));

            return rs.getLong(1);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
}
