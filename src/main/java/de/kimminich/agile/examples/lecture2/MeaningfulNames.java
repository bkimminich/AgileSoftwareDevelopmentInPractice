package de.kimminich.agile.examples.lecture2;

public class MeaningfulNames {

    public class Bad {
        int elapsed;
        int creationDiff;
        int modDays;
        int fileAge;
    }

    public class Okay {
        int elapsedTimeInDays;
        int daysSinceCreation;
        int daysSinceModification;
        int fileAgeInDays;
    }
    
    public class FileRequest {
        Days elapsed;
        Days fileAge;
        Days ageOfLastModification;
    }
    
    public static class Days {
        // e.g. http://joda-time.sourceforge.net/apidocs/org/joda/time/Days.html
    }

}
