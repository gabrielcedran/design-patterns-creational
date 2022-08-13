package design.patterns.creational.builder.builder;

public class Demo {

    public static void main(String[] args) {
        LunchOrder lunchOrderBean = new LunchOrder
                .Builder()
                .bread("Wheat")
                .condiments("Lettuce")
                .dressing("Mustard")
                .meat("Ham")
                .build();

        System.out.println(lunchOrderBean.getBread());
        System.out.println(lunchOrderBean.getCondiments());
        System.out.println(lunchOrderBean.getDressing());
        System.out.println(lunchOrderBean.getMeat());
    }
}
