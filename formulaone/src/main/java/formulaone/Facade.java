package formulaone;

public class Facade {
    
    private FileReader fileReader;
    private RacersData racersData;
    private RacerParser racerParser;
    private Formatter formatter;
    
    public Facade(FileReader fileReader, RacersData racersData, RacerParser racerParser, Formatter formatter) {
        super();
        this.fileReader = fileReader;
        this.racersData = racersData;
        this.racerParser = racerParser;
        this.formatter = formatter;
    }
    
    public String bestRecersResultsOfRing(String nameStartTimeFile, String nameEndTimeFile, String abbrevAndFullnameAndTeamOfRacersFile) {
        racersData.setStartData(fileReader.getData(nameStartTimeFile));
        racersData.setEndData(fileReader.getData(nameEndTimeFile));
        racerParser.setRasers(fileReader.getDataRacers(abbrevAndFullnameAndTeamOfRacersFile));
        
        
        fileReader.getDataRacers(abbrevAndFullnameAndTeamOfRacersFile);
        return formatter.formatRacersResults(racerParser.setResultResers(racersData.getStartData(), racersData.getEndData()), racerParser);
    }
    

}
