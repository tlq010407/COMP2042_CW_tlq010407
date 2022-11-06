package Game2048;

import java.util.Properties;

public class Record{

    public final String propertiesFilename;
    private final Properties props = new Properties();

    public Record(int grid_size) {
        this.propertiesFilename = "game2048_" + grid_size + "_record.properties";
    }

    public void saveRecord(Integer score) {
        int oldRecord = restoreRecord();
        props.setProperty("record", Integer.toString(Math.max(oldRecord, score)));

    }

    public int restoreRecord() {

        String score = props.getProperty("record");
        if (score != null) {
            return Integer.parseInt(score);
        }
        return 0;
    }

}
