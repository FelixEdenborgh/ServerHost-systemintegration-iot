package javafiles;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "elkostnadtable")
public class ElKostnad implements Serializable
{

    private static final long serialVersionUID = 1L;
    private int id;
    private int elkostnad;
    private Date date;
    
    public ElKostnad()
    {}
    
    public ElKostnad(int id, int elkostnad, Date date)
    {
        
        this.id = id;
        this.elkostnad = elkostnad;
        this.date = date;
        
    }
    
    public ElKostnad(int elkostnad)
    {
        this.elkostnad = elkostnad;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getelkostnad() 
    {
        return elkostnad;
    }

    @XmlElement
    public void setelkostnad(int elkostnad) 
    {
        this.elkostnad = elkostnad;
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