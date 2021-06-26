package practical;

public class Person {
    public String firstname;
    public String lastname;
    public Address address;

    public void test() {
        rPerson person = new rPerson("wenchy", "iscool");
        person.firstname();
        person.lastname();
    }

}

record rPerson(String firstname, String lastname) {
}
