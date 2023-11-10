package Java_part;

import Java_part.packs.Camel;
import Java_part.packs.Donkey;
import Java_part.packs.Horse;
import Java_part.pets.Cat;
import Java_part.pets.Dog;
import Java_part.pets.Hamster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry extends Counter implements AutoCloseable{

    private List<Animal> animals = new ArrayList<>();

    private static Counter count = new Counter();


    public void addAnimal(Animal animal){
        animals.add(animal);
        count.add();
    }

    public void studyCommand(Animal animal, String command){
        animal.setCommand(command);
    }

    public List<String> getCommands(Animal animal){
        List<String> commands = new ArrayList<>();
        commands.add(animal.getCommand());
        return commands;
    }
    public List<String> showAnimals(Animal animal){
        List<String> animals = new ArrayList<>();
        animals.add(animal.getInfo());
        return animals;
    }

    public static void main(String[] args) throws Exception {

        AnimalRegistry animalRegistry = new AnimalRegistry();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add new animal");
                System.out.println("2. Teach command");
                System.out.println("3. Get commands");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter animal type: ");
                        String type = scanner.nextLine();
                        System.out.println("Enter animal name: ");
                        String name = scanner.nextLine();
                        Animal animal;
                        switch (type) {
                            case "Dog":
                                animal = new Dog(name);
                                break;
                            case "Cat":
                                animal = new Cat(name);
                                break;
                            case "Hamster":
                                animal = new Hamster(name);
                                break;
                            case "Horse":
                                animal = new Horse(name);
                                break;
                            case "Camel":
                                animal = new Camel(name);
                                break;
                            case "Donkey":
                                animal = new Donkey(name);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + type);
                        }
                        animalRegistry.addAnimal(animal);
                        break;
                    case 2:
                        System.out.println("Enter animal name: ");
                        String animalName = scanner.nextLine();
                        Animal foundAnimal = animalRegistry.animals.stream()
                                .filter(a -> a.getName().equals(animalName))
                                .findFirst()
                                .orElse(null);
                        if (foundAnimal == null) {
                            System.out.println("No such animal");
                            break;
                        }
                        System.out.println("Enter command: ");
                        String command = scanner.nextLine();
                        animalRegistry.studyCommand(foundAnimal, command);
                        break;
                    case 3:
                        System.out.println("Enter animal name: ");
                        String aName = scanner.nextLine();
                        Animal fAnimal = animalRegistry.animals.stream()
                                .filter(a -> a.getName().equals(aName))
                                .findFirst()
                                .orElse(null);
                        if (fAnimal == null) {
                            System.out.println("No such animal");
                            break;
                        }
                        List<String> commands = animalRegistry.getCommands(fAnimal);
                        for (String cmd : commands) {
                            System.out.println(cmd);
                        }
                        break;

                    case 4:
                        return;
                }


        }
    }

//    @Override
//    public String toString() {
//        return "AnimalRegistry{" +
//                "animals=" + animal. +
//                '}';
//    }

    public void close() throws Exception {
        if (count.getCount() == 0) {
            throw new Exception("Counter was not used in try-with-resources block");
        } else {
            count.resetCount();
        }
    }



}
