package formulaone;

public class Main {
    
    public static String fileNameStartTime = "src\\main\\resources\\start.log";
    public static String fileNameEndTime = "src\\main\\resources\\end.log";
    public static String fileNameRacersInfo = "src\\main\\resources\\abbreviations.txt";
   
    public static void main(String[] args) {
        
        Facade facade = new Facade(new FileReader(), new RacerParser(), new Formatter());
        String result = facade.bestRacersResultsOfRing(fileNameStartTime, fileNameEndTime, fileNameRacersInfo);
        System.out.println(result);
        
    }
}
