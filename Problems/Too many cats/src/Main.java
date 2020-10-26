class Cat {
    String name;
    int age;

    private static int counter = 0;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
    }

    public static int getNumberOfCats() {
        moieem();
        return counter;
    }

    private static void moieem() {
        if (counter > 5) {
            for (int i = 0; i < counter - 5; i++) {
                System.out.println("You have too many cats");
            }
        }
    }
}