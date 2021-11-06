package formulaone;

public class Main {
    
    public static String fileNameStartTime = "C:\\repositoryfour\\formulaone\\src\\main\\resources\\start.log";
    public static String fileNameEndTime = "C:\\repositoryfour\\formulaone\\src\\main\\resources\\end.log";
    public static String fileNameRacersInfo = "C:\\repositoryfour\\formulaone\\src\\main\\resources\\abbreviations.txt";
   
    public static void main(String[] args) {
        
        Facade facade = new Facade(new FileReader(), new RacerParser(), new Formatter());
        String result = facade.bestRacersResultsOfRing(fileNameStartTime, fileNameEndTime, fileNameRacersInfo);
        System.out.println(result);
        
    }
}
