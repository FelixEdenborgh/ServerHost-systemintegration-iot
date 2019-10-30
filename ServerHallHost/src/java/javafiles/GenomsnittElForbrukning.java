package javafiles;

import java.io.Serializable;

public class GenomsnittElForbrukning implements Serializable 
{

    private static final long serialVersionUID = 1L;
    private int min, max, avg;
    private int elkostnad;

    public GenomsnittElForbrukning() 
    {
    }

    public GenomsnittElForbrukning(int avg, int min, int max, int elkostnad) 
    {

        this.avg = avg;
        this.min = min;
        this.max = max;
        this.elkostnad = elkostnad;

    }

    public int getMin() 
    {
        return min;
    }

    public void setMin(int min) 
    {
        this.min = min;
    }

    public int getMax() 
    {
        return max;
    }

    public void setMax(int max) 
    {
        this.max = max;
    }

    public int getAvg() 
    {
        return avg;
    }

    public void setAvg(int avg) 
    {
        this.avg = avg;
    }

    public int getelkostnad() 
    {
        return elkostnad;
    }

    public void setelkostnad(int elkostnad) 
    {
        this.elkostnad = elkostnad;
    }
    
    
}