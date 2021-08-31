package customer;

public class Main {
    public static void main(String[] args){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (Exception e){
            System.out.println(e);
        }
        new TabServer();
    }
}
