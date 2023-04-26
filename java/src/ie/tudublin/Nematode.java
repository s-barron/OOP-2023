package ie.tudublin;

import processing.data.TableRow;


public class Nematode {

    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;
    
    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"),
            tr.getInt("length"),
            tr.getInt("limbs") == 1,
            tr.getString("gender"),
            tr.getInt("eyes") == 1
        );
    }
    public Nematode(String name, int length, boolean limbs, String gender, boolean eyes)
    {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    @Override
    public String toString()
    {
        return "\nName: " + name + "\nLength: " + length + "\nLimbs: " + limbs + "\nGender: " + gender + "\nEyes: " + eyes;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean isLimbs() {
        return limbs;
    }
    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public boolean isEyes() {
        return eyes;
    }
    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }
    
    int d = 60;
    
    public void render(NematodeVisualiser pa)
    {
        pa.stroke(255);
        for(int i = 0; i < length; i++)
        {
            pa.circle(pa.width/2, i*d, d/2);
        }
    }
    
}
