package ie.tudublin;

public class PitchSpeller {

    public String spell(float frequency)
    {
        float[] frequencies = {146.83f, 164.81f, 185.00f, 196.00f, 220.00f, 246.94f, 277.18f, 293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f, 1318.51f, 1479.98f, 1567.98f, 1760.00f, 1975.53f, 2217.46f, 2349.32f};
	    String[] spellings = {"D,", "E,", "F#,", "G,", "A,", "B,", "C#", "D", "E", "F#", "G", "A", "B","c#", "d", "e", "f#", "g", "a", "b", "c#'", "d'", "e'", "f#'", "g'", "a'", "b'", "c''", "d''"};
        
        float min = 100000000;
        int minI = 0;
        for(int i = 0; i < frequencies.length; i++)
        {
            if(frequency > frequencies[i])
            {
                if (frequency - frequencies[i] < min)
                {
                    min = frequency - frequencies[i];
                    minI = i;  
                }          
            }
            else if(frequency < frequencies[i])
            {
                if(frequencies[i] - frequency < min)
                {
                    min = frequencies[i] - frequency;
                    minI = i;
                }
            }
        }
        return spellings[minI];
    }

}
