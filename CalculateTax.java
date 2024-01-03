import java.util.Scanner;

// Interface Taxable
interface Taxable {
    double salesTax = 0.07; // 7%
    double incomeTax = 0.105; // 10.5%

    // Abstract method to calculate tax
// Static method to calculate tax
    static double calcTax(double amount, double taxRate) {
        return amount * taxRate;
    }
}

// Employee class implementing Taxable
class Employees implements Taxable {
    private final int empId;
    private final String name;
    private final double salary;

    // Constructor
    public Employees(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    // Implementation of calcTax method for income tax calculation

    public double calcIncomeTax() {
        return Taxable.calcTax(salary, Taxable.incomeTax);
    }
    // Accessor for empId
    public int getEmpId() {
        return empId;
    }

    // Accessor for name
    public String getName() {
        return name;
    }
}

// Product class implementing Taxable
class Products {
    private final int pid;
    private final double price;
    private final int quantity;

    // Constructor
    public Products(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    // Implementation of calcTax method for sales tax calculation

    public double calcSalesTax() {
        return Taxable.calcTax(price * quantity, Taxable.salesTax);
    }
    // Accessor for pid
    public int getPid() {
        return pid;
    }
}

// Main class with the main method
public class CalculateTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept employee information
        System.out.println("Enter Employee ID:");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.println("Enter Employee Name:");
        String empName = scanner.nextLine();
        System.out.println("Enter Employee Salary:");
        double empSalary = scanner.nextDouble();

        Employees employee = new Employees(empId, empName, empSalary);

        // Accept product information
        System.out.println("Enter Product ID:");
        int productId = scanner.nextInt();
        System.out.println("Enter Product Price:");
        double productPrice = scanner.nextDouble();
        System.out.println("Enter Product Quantity:");
        int productQuantity = scanner.nextInt();

        Products product = new Products(productId, productPrice, productQuantity);

        System.out.println("Employee ID: " + employee.getEmpId());
        System.out.println("Employee Name: " + employee.getName());
        // Print income tax for employee

        System.out.println("Income Tax for Employee: " + employee.calcIncomeTax());

        System.out.println("Product ID: " + product.getPid());

        // Print sales tax for product
        System.out.println("Sales Tax for Product: " + product.calcSalesTax());

    }
}

