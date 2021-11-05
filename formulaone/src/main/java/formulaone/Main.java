package formulaone;

public class Main {
    
    public static void main(String[] args) {
        Facade facade = new Facade(new FileReader(), new RacerParser(), new Formatter());
        String fileNameStartTime = "C:\\repositoryfour\\formulaone\\src\\main\\resources\\start.log";
        String fileNameEndTime = "C:\\repositoryfour\\formulaone\\src\\main\\resources\\end.log";
        String fileNameAbbrevAndFullnameAndTeamOfRacers = "C:\\repositoryfour\\formulaone\\src\\main\\resources\\abbreviations.txt";
        String result = facade.bestRacersResultsOfRing(fileNameStartTime, fileNameEndTime, fileNameAbbrevAndFullnameAndTeamOfRacers);
        System.out.println(result);
    }
}
