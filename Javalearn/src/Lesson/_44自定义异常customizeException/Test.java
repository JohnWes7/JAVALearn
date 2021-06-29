package Lesson._44自定义异常customizeException;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        try {
            person.setAge(-1);
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }
    }
}

//不合法年龄
class IllegalAgeException extends Exception {
    public IllegalAgeException(){

    }

    public IllegalAgeException(String message){
        super(message);
    }
}

class Person{
    private String name;
    private int age;

    public void setAge(int age) throws IllegalAgeException {
        if (age<0) {
            throw new IllegalAgeException("年龄为负数");
        }
        else{
            this.age = age;
        }
    }
    public int getAge() {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}