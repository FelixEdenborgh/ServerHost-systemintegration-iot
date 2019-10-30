package javafiles;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerHallDBDao 
{

    Properties p = new Properties();

    public ServerHallDBDao() 
    {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            p.load(new FileInputStream("C:\\Users\\Felix\\OneDrive - System Provider Edenborgh AB\\Dokument\\NetBeansProjects\\ServerHallHost\\src\\java\\javafiles\\settings.properties"));

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerHallDBDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerHallDBDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Temp> getLatestTemperature() 
    {

        List<Temp> TempList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("SELECT id, temperature, date FROM serverhall.temperature ORDER BY date DESC LIMIT 1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int temperature = rs.getInt("temperature");
                Timestamp date = rs.getTimestamp("date");

                TempList.add(new Temp(id, temperature, date));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TempList;
    }

    public List<ElForbrukning> getLatestElForbrukning() 
    {

        List<ElForbrukning> EconsList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("SELECT id, elforbrukning, date FROM serverhall.elforbrukning ORDER BY date DESC LIMIT 1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int elforbrukning = rs.getInt("elforbrukning");
                Timestamp date = rs.getTimestamp("date");

                EconsList.add(new ElForbrukning(id, elforbrukning, date));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return EconsList;
    }

    public List<ElKostnad> getelkostnad() 
    {

        List<ElKostnad> elkostnadList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("SELECT id, elkostnad, date FROM serverhall.elkostnad ORDER BY date DESC LIMIT 1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                int elkostnad = rs.getInt("elkostnad");
                Date date = rs.getDate("date");

                elkostnadList.add(new ElKostnad(id, elkostnad, date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elkostnadList;

    }

    public void insertTemp(Temp t) 
    {

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO serverhall.temperature (temperature) VALUES (?)");

            stmt.setInt(1, t.getTemperature());

            int a = stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertelkostnad(ElKostnad t) 
    {

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("INSERT INTO serverhall.elkostnad (elkostnad) VALUES (?)");

            stmt.setInt(1, t.getelkostnad());

            int a = stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GenomsnittTemp> RapportGenomSnittMinMax() 
    {

        List<GenomsnittTemp> list = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("select genomsnittlig(temperature), max(temperature), min(temperature) from serverhall.temperature;");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int avgg = rs.getInt("genomsnittlig(temperature)");
                int maxx = rs.getInt("max(temperature)");
                int minn = rs.getInt("min(temperature)");

                list.add(new GenomsnittTemp(avgg, maxx, minn));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<GenomsnittElForbrukning> RapportGenomsnittElForbrukning() 
    {

        List<GenomsnittElForbrukning> econList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"))) {

            PreparedStatement stmt = con.prepareStatement("select genomsnittlig(elforbrukning), max(elforbrukning), min(elforbrukning), elkostnad.elkostnad from serverhall.elforbrukning, serverhall.elkostnad");
                    
             ResultSet rs = stmt.executeQuery();
             
             while(rs.next()){
                 
                 int avg = rs.getInt("genomsnittlig(elforbrukning)");
                 int min = rs.getInt("min(elforbrukning)");
                 int max = rs.getInt("max(elforbrukning)");
                 int elkostnad = rs.getInt("elkostnad");
                 
                 econList.add(new GenomsnittElForbrukning(avg, min, max, elkostnad));
                         
             }
             
        } catch(Exception e){
            e.printStackTrace();
        }
        return econList;
    }

}