package javafiles;

import java.io.Serializable;
import java.sql.Date;

public class ServerHall implements Serializable 
{

    private static final long serialVersionUID = 1L;
    private int id;
    private int temperature;
    private int econsumption;
    private int eprice;
    private Date date;

    public ServerHall() 
    {
    }

    public ServerHall(int id, int temperature, int econsumption, int eprice, Date date) 
    {

        this.id = id;
        this.temperature = temperature;
        this.econsumption = econsumption;
        this.eprice = eprice;
        this.date = date;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getTemperature() 
    {
        return temperature;
    }

    public void setTemperature(int temperature) 
    {
        this.temperature = temperature;
    }

    public int getEconsumption() 
    {
        return econsumption;
    }

    public void setEconsumption(int econsumption) 
    {
        this.econsumption = econsumption;
    }

    public int getEprice() 
    {
        return eprice;
    }

    public void setEprice(int eprice) 
    {
        this.eprice = eprice;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }
}