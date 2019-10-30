package javafiles;

import java.io.Serializable;

public class GenomsnittTemp implements Serializable 
{

    private static final long serialVersionUID = 1L;
    private int avg;
    private int max;
    private int min;

    public GenomsnittTemp() 
    {
    }

    public GenomsnittTemp(int avg, int max, int min) 
    {

        this.avg = avg;
        this.max = max;
        this.min = min;

    }

    public int getAvg() 
    {
        return avg;
    }

    public void setAvg(int avg) 
    {
        this.avg = avg;
    }

    public int getMax() 
    {
        return max;
    }

    public void setMax(int max) 
    {
        this.max = max;
    }

    public int getMin() 
    {
        return min;
    }

    public void setMin(int min) 
    {
        this.min = min;
    }

}