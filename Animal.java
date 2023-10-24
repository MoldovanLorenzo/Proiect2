public class Animal {
    private final String gradinaZoo="ZooMures";
    private String tip;
    private String nume;
    private int varsta;
    private String taraOrigine;
    private boolean mamifer;

    public Animal(String tip, String nume, int varsta, String taraOrigine, boolean mamifer) {
        this.tip = tip;
        this.nume = nume;
        this.varsta = varsta;
        this.taraOrigine = taraOrigine;
        this.mamifer = mamifer;
    }

    public Animal() {}

    public String getAnimal() {
        return tip;
    }

    public boolean isMamifer() {

        return mamifer;
    }
    public String hranesteAnimal() {
        return nume+" a fost hranit";
    }
    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Animalul ").append(tip);
        stringBuffer.append(" pe nume ").append(nume);
        stringBuffer.append(" cu varsta de ").append(varsta).append(" ani din ").append(taraOrigine);
        stringBuffer.append(" se afla la ").append(gradinaZoo);
        return stringBuffer.toString();
    }
}
