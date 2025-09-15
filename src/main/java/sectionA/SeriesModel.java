package sectionA;

public class SeriesModel {
    private String seriesId;
    private String seriesName;
    private int seriesAge;
    private int numberOfEpisodes;

    // Constructor
    public SeriesModel(String seriesId, String seriesName, int seriesAge, int numberOfEpisodes) {
        this.seriesId = seriesId;
        this.seriesName = seriesName;
        setSeriesAge(seriesAge); // setter for validation
        this.numberOfEpisodes = numberOfEpisodes;
    }

    // Getters
    public String getSeriesId() {
        return seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public int getSeriesAge() {
        return seriesAge;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    // Setters
    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public void setSeriesAge(int seriesAge) {
        if (seriesAge < 0) {
            throw new IllegalArgumentException("Age restriction cannot be negative");
        }
        this.seriesAge = seriesAge;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        if (numberOfEpisodes < 0) {
            throw new IllegalArgumentException("Number of episodes cannot be negative");
        }
        this.numberOfEpisodes = numberOfEpisodes;
    }

    @Override
    public String toString() {
        return "Series ID: " + seriesId +
                ", Name: " + seriesName +
                ", Age Restriction: " + seriesAge +
                ", Episodes: " + numberOfEpisodes;
    }
}
