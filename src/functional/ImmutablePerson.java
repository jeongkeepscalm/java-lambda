package functional;

public class ImmutablePerson {

    private String name;
    private int age;
    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // getter 만 제공
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    // 변경이 필요한 경우, 기존 객체를 수정하지 않고 새 객체를 반환한다.
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge);
    }


    @Override
    public String toString() {
        return "MutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
