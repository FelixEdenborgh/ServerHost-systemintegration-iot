package javafiles;
import java.io.Serializable;

public class Response implements Serializable 
{

    private static final long serialVersionUID = 1L;
    private String message;
    private Boolean status;

    public Response() 
    {
    }

    public Response(String message, Boolean status) 
    {
        this.message = message;
        this.status = status;
    }

    public String getMessage() 
    {
        return message;
    }

    public void setMessage(String message) 
    {
        this.message = message;
    }

    public Boolean getStatus() 
    {
        return status;
    }

    public void setStatus(Boolean status) 
    {
        this.status = status;
    }

}