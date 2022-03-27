public class Start {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();

        System.out.println(cat1.getWeight());
        System.out.println(cat2.getWeight());
        System.out.println(cat3.getWeight());
        System.out.println(cat4.getWeight());
        System.out.println(cat5.getWeight());


        cat1.feed(900.);
        cat2.feed((double) 300);
        System.out.println("_____________");
        System.out.println(cat1.getWeight());
        System.out.println(cat2.getWeight());

        cat3.feed(5465498.);
        System.out.println(cat3.getStatus());

        while (true) {
            cat4.meow();
            if (cat4.getStatus().equals("Dead"))
                break;
        }
        System.out.println(cat4.getStatus());


    }
}