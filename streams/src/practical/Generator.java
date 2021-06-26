package practical;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generator {

    private static Random rand = new Random();

    public static Employee[] generateEmployees(int count) {
        return Stream.generate(() -> randomEmployee())
                .limit(count)
                .toArray(Employee[]::new);
    }

    public static String randomString(int lenght) {
       return IntStream
                .generate(() -> rand.nextInt(80) + 32)
                .limit(lenght)
               .collect(() -> new StringBuilder(), (sb, intCode) -> sb.append((char)intCode), StringBuilder::append)
               .toString();
    }

    public static Address randomAddress() {
        Address address = new Address();
        address.street = randomString(10);
        address.state = randomString(2);
        address.zipCode = rand.nextInt(30) + 1;
        return address;
    }

    public static Employee randomEmployee() {
        Employee employee = new Employee();
        employee.address = randomAddress();
        employee.title = getRandomTitle();
        employee.salary = rand.nextInt(200000) + 100000;
        employee.firstname = randomString(6);
        employee.lastname = randomString(8);
        return employee;
    }

    public static String[] titles = new String[]{"Software Engineering Intern", "Product Manager", "Systems Engineer", "DevOps Engineer", "Software Architect"};
    private static String getRandomTitle() {
        return titles[rand.nextInt(titles.length)];
    }
}
