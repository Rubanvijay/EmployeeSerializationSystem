import java.io.*;
import java.util.ArrayList;
import java.util.List;


class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Salary=" + salary +
                '}';
    }
}

public class Main {


    public static List<Employee> readEmployeesFromTextFile(String fileName) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double salary = Double.parseDouble(parts[2].trim());
                employees.add(new Employee(id, name, salary));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return employees;
    }


    public static void serializeEmployees(String fileName, List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized to " + fileName);
        } catch (IOException e) {
            System.out.println("Error serializing employees: " + e.getMessage());
        }
    }


    public static List<Employee> deserializeEmployees(String fileName) {
        List<Employee> employees = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing employees: " + e.getMessage());
        }
        return employees;
    }

    public static void main(String[] args) {
        String inputFile = "employees.txt";
        String binaryFile = "employees.dat";


        List<Employee> employees = readEmployeesFromTextFile(inputFile);


        serializeEmployees(binaryFile, employees);


        List<Employee> deserializedEmployees = deserializeEmployees(binaryFile);


        if (deserializedEmployees != null) {
            System.out.println("Deserialized Employees:");
            for (Employee emp : deserializedEmployees) {
                System.out.println(emp);
            }
        }
    }
}
