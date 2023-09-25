import java.util.*;
import java.util.stream.Collectors;

public class User {

    static List<User> users = new ArrayList<>();
    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {

        users.add(new User("Ivan", 18));
        users.add(new User("Boris", 26));
        users.add(new User("Ivan", 18));

        System.out.println("Main list" + users);

        sortedAndReturnOldest(users);
    }

    public static void sortedAndReturnOldest(List<User> users) {
        List<User> uniqueList = users.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique users" + uniqueList);
        uniqueList.sort(Comparator.comparing(User::getName));
        System.out.println("Sorted by name" + uniqueList);
        uniqueList.sort(Comparator.comparing(User::getAge));
        System.out.println("Sorted by age" + uniqueList);
        Optional<User> maxAge = uniqueList.stream().max(Comparator.comparingInt(User::getAge));
        System.out.println("Oldest user" + maxAge);
    }


}
