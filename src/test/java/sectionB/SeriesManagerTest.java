package sectionB;

import org.junit.Before;
import org.junit.Test;
import sectionA.SeriesModel;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SeriesManagerTest {

    private ArrayList<SeriesModel> series;

    @Before
    public void setUp() {
        series = new ArrayList<>();
        series.add(new SeriesModel("S1", "Breaking Bad", 18, 62));
        series.add(new SeriesModel("S2", "Stranger Things", 16, 34));
    }

    // Test valid search
    @Test
    public void testSearchValid() {
        boolean found = series.stream().anyMatch(s -> s.getSeriesName().equalsIgnoreCase("Breaking Bad"));
        assertTrue(found);
    }

    // Test invalid search
    @Test
    public void testSearchInvalid() {
        boolean found = series.stream().anyMatch(s -> s.getSeriesName().equalsIgnoreCase("Game of Thrones"));
        assertFalse(found);
    }

    // Test valid age restriction update
    @Test
    public void testAgeRestrictionValid() {
        SeriesModel s = series.get(0);
        s.setSeriesAge(21);
        assertEquals(21, s.getSeriesAge());
    }

    // Test invalid age restriction (negative number)
    @Test
    public void testAgeRestrictionInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new SeriesModel("S3", "Invalid Series", -5, 10);
        });
        assertEquals("Age restriction cannot be negative", exception.getMessage());
    }

    // Test delete a series
    @Test
    public void testDeleteSeries() {
        boolean removed = series.removeIf(s -> s.getSeriesId().equalsIgnoreCase("S2"));
        assertTrue(removed);
        assertEquals(1, series.size());
    }

    // Test toString output
    @Test
    public void testToString() {
        SeriesModel s = series.get(0);
        String output = s.toString();
        assertTrue(output.contains("Series ID"));
        assertTrue(output.contains("Breaking Bad"));
    }
}
