package formulaone;

public class Main {
    
    public static String repository = "C:\\repositoryfour\\formulaone\\src\\main\\resources\\";
    public static String fileNameStartTime = repository + "start.log";
    public static String fileNameEndTime = repository + "end.log";
    public static String fileNameRacersInfo = repository + "abbreviations.txt";
   
    public static void main(String[] args) {
        
        Facade facade = new Facade(new FileReader(), new RacerParser(), new Formatter());
        String result = facade.bestRacersResultsOfRing(fileNameStartTime, fileNameEndTime, fileNameRacersInfo);
        System.out.println(result);
        
    }
}
