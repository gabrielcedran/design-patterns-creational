package design.patterns.creational.builder.javabeans_setters;

/**
 * The problem with this approach is that it is not immutable thus things can be changed after they are set up.
 * On top of that, and even worse, there is no contract that signifies when a lunch order is valid.
 *
 * This is the bean model.
 */
public class LunchOrderBean {

    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunchOrderBean() {

    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }
}
