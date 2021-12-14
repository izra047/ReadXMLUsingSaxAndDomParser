
package readxmlusingsax.domparser;


public class Filas {
    private double id;
    private String country;
    private int female;
    private int male;
    int total = 0;

    public Filas() {
    }

    public double getId() {
        return id;
    }
   
    public void setId(double id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
        
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
        
    }
    
    @Override
    public String toString(){
        return "Filas{" + "id=" + id + "\n country=" + country + "\n female=" + female + "\n male=" + male + "\n total=" + (total = male + female ) + "}\n";
    }
    
}
