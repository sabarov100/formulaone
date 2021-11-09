package formulaone;

public class Facade {

    private FileReader fileReader;
    private RacerParser racerParser;
    private Formatter formatter;
    
    public Facade(FileReader fileReader, RacerParser racerParser, Formatter formatter) {
        super();
        this.fileReader = fileReader;
        this.racerParser = racerParser;
        this.formatter = formatter;
    }
    
    public String bestRacersResultsOfRing(String nameStartTimeFile, String nameEndTimeFile,
            String RacersFileInfo) {
        return formatter.formatRacersResult(racerParser.initializationRacers
                (fileReader.getListData(RacersFileInfo),
                fileReader.getListData(nameStartTimeFile), 
                fileReader.getListData(nameEndTimeFile)));
    }
}
