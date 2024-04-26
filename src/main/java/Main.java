package org.example;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Instantiate repositories
        CustomerRepository customerRepository = new MySqlCustomerRepository();
        EmployeeRepository employeeRepository = new MySqlEmployeeRepository();
        MobileDeviceRepository mobileDeviceRepository = new MySqlMobileDeviceRepository();
        RepairJobRepository repairJobRepository = new MySqlRepairJobRepository();

        // Create sample entities
        Customer customer = new Customer(1, "John Doe", "john@example.com");
        Employee employee = new Employee(1, "Jane Smith", "Technician");
        MobileDevice mobileDevice = new MobileDevice(1, "Samsung", "Galaxy S20");
        RepairJob repairJob = new RepairJob(1, mobileDevice, "Cracked screen", customer, employee);

        try {
            // Test CRUD operations for CustomerRepository
            customerRepository.create(customer);
            customerRepository.update(customer);
            customerRepository.delete(customer.getId());
            Customer retrievedCustomer = customerRepository.getById(customer.getId());
            List<Customer> allCustomers = customerRepository.getAll();

            // Test CRUD operations for EmployeeRepository
            employeeRepository.create(employee);
            employeeRepository.update(employee);
            employeeRepository.delete(employee.getId());
            Employee retrievedEmployee = employeeRepository.getById(employee.getId());
            List<Employee> allEmployees = employeeRepository.getAll();

            // Test CRUD operations for MobileDeviceRepository
            mobileDeviceRepository.create(mobileDevice);
            mobileDeviceRepository.update(mobileDevice);
            mobileDeviceRepository.delete(mobileDevice.getId());
            MobileDevice retrievedMobileDevice = mobileDeviceRepository.getById(mobileDevice.getId());
            List<MobileDevice> allMobileDevices = mobileDeviceRepository.getAll();

            // Test CRUD operations for RepairJobRepository
            repairJobRepository.create(repairJob);
            repairJobRepository.update(repairJob);
            repairJobRepository.delete(repairJob.getId());
            RepairJob retrievedRepairJob = repairJobRepository.getById(repairJob.getId());
            List<RepairJob> allRepairJobs = repairJobRepository.getAll();

            // Run tests for repositories
            CustomerRepositoryTest.runTests();
            EmployeeRepositoryTest.runTests();
            MobileDeviceRepositoryTest.runTests();
            RepairJobRepositoryTest.runTests();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
