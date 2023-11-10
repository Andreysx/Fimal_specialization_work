package Java_part;

public class Animal {

    private String name;

    private String command;


    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(animalInfo());
        return sb.toString();
}
public String animalInfo(){
        String ani = toString();
        return ani;
}

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", command='" + command + '\'' +
                '}';
    }
}
