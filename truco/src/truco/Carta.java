package truco;
public class Carta {
    protected String naipes;
    protected String value;
    protected int forca;
    public Carta(String naipes, String value, int FORCA) {
        this.naipes = naipes;
        this.value = value;
        this.forca = FORCA; 
    }
    public String getNaipe() {
    	return this.naipes;
    }
    public String getValue() {
    	return this.value;
    }
    public int getForca() {
    	return forca;
    }
    public void setForca(int i) {
    	this.forca += i;
    }
}
