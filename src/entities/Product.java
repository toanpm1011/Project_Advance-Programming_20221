/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Phi Manh Toan
 */
public class  Product {
    int id;
    public Product(){
        
    }

    public Product(int id, String brand, String name, double price, String type, String photo) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.type = type;
        this.photo = photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getPhoto() {
        return photo;
    }
    String brand;
    String name;
    double price;
    String type;
    String photo;
}
