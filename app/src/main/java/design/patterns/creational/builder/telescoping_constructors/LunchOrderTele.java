package design.patterns.creational.builder.telescoping_constructors;

/**
 * In this example, immutability is achieved and what is expected from contract perspective declared.
 * However it is not flexible enough. What a lunch only with break and meat is wanted? Should another
 * constructor be created? From flexibility perspective the java beans approach does a better job.
 *
 * This is the telescoping constructors model.
 */
public class LunchOrderTele {

    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderTele(String bread, String condiments) {
        this.bread = bread;
        this.condiments = condiments;
    }

    public LunchOrderTele(String bread, String condiments, String dressing) {
        this(bread, condiments);
        this.dressing = dressing;
    }

    public LunchOrderTele(String bread, String condiments, String dressing, String meat) {
        this(bread, condiments, dressing);
        this.meat = meat;
    }

    public String getBread() {
        return bread;
    }


    public String getCondiments() {
        return condiments;
    }


    public String getDressing() {
        return dressing;
    }


    public String getMeat() {
        return meat;
    }

}
