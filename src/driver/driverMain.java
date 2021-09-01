package driver;
public class driverMain {
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(Exception e){

        }
    }
    public static void main(String[] args) throws Exception{
        new TabServer();
    }
}