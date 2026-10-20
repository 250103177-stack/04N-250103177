public class Decorator_pattern_soft {
    public interface Pizza{
        String getDescription();
        double getPrice();
    }

    static class PlainPizza implements Pizza{
        @Override
        public String getDescription(){
            return "Plain Dough & Souce";
        }

        @Override
        public double getPrice(){
            return 5;
        }
    }

    static abstract class PizzaDecorator implements Pizza{
        Pizza pizza;

        public PizzaDecorator(Pizza pizza){
            this.pizza = pizza;
        }
    }

    static class CheeseDecorator extends PizzaDecorator{
        CheeseDecorator(Pizza pizza){
            super(pizza);
        }

        @Override
        public String getDescription(){
            return pizza.getDescription() + " +cheese";
        }

        @Override
        public double getPrice(){
            return pizza.getPrice() + 2;
        }
    }

    static class OlivesDecorator extends PizzaDecorator {
        OlivesDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + " +olives";
        }

        @Override
        public double getPrice() {
            return pizza.getPrice() + 1;
        }
    }

    static class PineappleDecorator extends PizzaDecorator {
        PineappleDecorator(Pizza pizza) {
            super(pizza);
        }

        @Override
        public String getDescription() {
            return pizza.getDescription() + " +pineapple";
        }

        @Override
        public double getPrice() {
            return pizza.getPrice() + 1.5;
        }
    }

    public static void main(String[] args){
        Pizza my_pizza = new PlainPizza();
        System.out.println(my_pizza.getDescription());
        System.out.println(my_pizza.getPrice());
        System.out.println();

        my_pizza = new CheeseDecorator(new OlivesDecorator(new PineappleDecorator(my_pizza)));
        System.out.println(my_pizza.getDescription());
        System.out.println(my_pizza.getPrice());
    }


}
