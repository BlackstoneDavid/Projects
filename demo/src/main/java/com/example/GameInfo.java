package com.example;

public class GameInfo 
{
    public String name, url, seller;
    public float price;
    public int storeID;

    public GameInfo(){}

    public GameInfo(int num)
    {
        storeID = num;
    }

    public GameInfo(String n, String s, String u, float p)
    {
        name = n;
        seller = s;
        price = p;
        url = u;
    }

    public int getID()
    {
        return storeID;
    }

    public String getName()
    {
        return name;
    }

    public String getSeller()
    {
        return seller;
    }

    public float getPrice()
    {
        return price;
    }

    public String getURL()
    {
        return url;
    }

    public void setID(int n)
    {
        storeID = n;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setSeller(String s)
    {
        seller = s;
    }

    public void setPrice(float p)
    {
        price = p;
    }

    public void setURL(String u)
    {
        url = u;
    }

    public void printID()
    {
        System.out.println("ID: " +storeID);
    }

    public void printName()
    {
        System.out.println("Game: " +name);
    }

    public void printSeller()
    {
        System.out.println("Seller: " +seller);
    }

    public void printURL()
    {
        System.out.println("URL: " +url);
    }

    public void printPrice()
    {
        System.out.println("Price: $" +price);
    }

    public void printInfo()
    {
       printID();
       printName();
       printSeller();
       printPrice();
       printURL();
    }
}
