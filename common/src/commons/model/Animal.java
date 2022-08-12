package commons.model;

public class Animal implements Comparable<Animal> {

    public Animal(final String color, final String name, final int size) {
        this.color = color;
        this.name = name;
        this.size = size;
    }

    public String color;
    public String name;
    public int size;

    @Override
    public int compareTo(Animal o) {
        return name.compareTo(o.name);
    }
}
