package javafiles;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "elforbrukningtable")
public class ElForbrukning implements Serializable 
{

    private static final long serialVersionUID = 1L;
    private int id;
    private int elforbrukning;
    private Date date;
    
    public ElForbrukning()
    {}
    
    public ElForbrukning(int id, int elforbrukning, Date date)
    {
        
        this.id = id;
        this.elforbrukning = elforbrukning;
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

    public int getelforbrukning() 
    {
        return elforbrukning;
    }

    @XmlElement
    public void setelforbrukning(int elforbrukning) 
    {
        this.elforbrukning = elforbrukning;
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