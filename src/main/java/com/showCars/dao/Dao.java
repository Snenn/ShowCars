package com.showCars.dao;

import com.showCars.pojos.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao implements IDao {

    private static Dao dao;

    public static Dao getDAO() {
        if (dao == null) {
            synchronized (Dao.class) {
                if (dao == null) {
                    dao = new Dao();
                }
            }
        }
        return dao;
    }


    public List getAll() {
        List<Car> cars = new ArrayList();
        String sql = "SELECT * FROM car";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Car car = new Car();

                car.setModel(rs.getString("model"));

                car.setColor(rs.getString("color"));

                cars.add(car);
            }
        } catch (SQLException e) {

        }
        return cars;
    }

    @Override
    public void save(Object o) {

    }

    public void save(Car car) {
        String sql = String.format(
                "insert INTO car(model, color) values('%s', '%s');",
                car.getModel(), car.getColor()
        );
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error"+e);
        }


    }
}