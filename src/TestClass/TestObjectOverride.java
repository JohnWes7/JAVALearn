package TestClass;

public class TestObjectOverride {
    public static void main(String[] args) {
        Employee e1 = new Employee(100, "johnwest");
        Employee e2 = new Employee(100, "zw");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));
    }
}

class Employee extends Object {
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id:" + this.id + " name:" + this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Employee employee = (Employee) obj;
        return this.id == employee.id;
    }
}