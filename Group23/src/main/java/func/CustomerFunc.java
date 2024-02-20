package func;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.Customer;
import entity.CustomerXML;
import entity.Vaccine;
import java.util.HashSet;
import java.util.Set;
import utils.FileUtils;

/**
 * StudentFunc class
 *
 * @author viettuts.vn
 */
public class CustomerFunc {
    private static final String STUDENT_FILE_NAME = "customer.xml";
    private List<Customer> listCustomers;

    public CustomerFunc() {
        this.listCustomers = readListCustomers();
    }

    /**
     * Lưu các đối tượng student vào file student.xml
     *
     * @param customers
     */
    public void writeListCustomers(List<Customer> customers) {
        CustomerXML customerXML = new CustomerXML();
        customerXML.setStudent(customers);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, customerXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     *
     * @return list student
     */
    public List<Customer> readListCustomers() {
        List<Customer> list = new ArrayList<Customer>();
        CustomerXML customerXML = (CustomerXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, CustomerXML.class);
        if (customerXML != null) {
            list = (List<Customer>) customerXML.getStudent();
        }
        return list;
    }


    /**
     * thêm student vào listStudents và lưu listStudents vào file
     *
     * @param customer
     */
    public void add(Customer customer) {
        int id = (listCustomers.size() > 0) ? (listCustomers.size() + 1) : 1;
        int tmp = 0;
        Set<Integer> listID = new HashSet<>();
        for(Customer it : listCustomers  )
        {
          listID.add(it.getId());
        }
        for(Integer it : listID){
              tmp++;
          if(it != tmp  )  {
              id = tmp ;
              break;
          }
        }
        customer.setId(id);
        listCustomers.add(customer);
        writeListCustomers(listCustomers);
    }

    public void addVaccine(int idCustomer, Vaccine vaccine) {
        Customer customer = findById(idCustomer);
        int id = (customer.getVaccines().size() > 0) ? (customer.getVaccines().size() + 1) : 1;
        int tmp = 0;
        Set<Integer> listID = new HashSet<>();
        for(Vaccine it : customer.getVaccines()  )
        {
          listID.add(it.getId());
        }
        for(Integer it : listID){
              tmp++;
          if(it != tmp  )  {
              id = tmp ;
              break;
          }
        }
        vaccine.setId(id);
        customer.getVaccines().add(vaccine);
        writeListCustomers(listCustomers);
    }

    public void editVaccine(int idCustomer, Vaccine vaccine) {
        Customer customer = findById(idCustomer);
        List<Vaccine> vaccines = customer.getVaccines();
        int size = vaccines.size();
        for (int i = 0; i < size; i++) {
            if (vaccines.get(i).getId() == vaccine.getId()) {
                vaccines.get(i).setName(vaccine.getName());
                vaccines.get(i).setPrice(vaccine.getPrice());
                vaccines.get(i).setInjectAgain(vaccine.getInjectAgain());
                writeListCustomers(listCustomers);
                break;
            }
        }
    }

    public boolean deleteVaccine(int idCustomer, Vaccine vaccine) {
        Customer customer = findById(idCustomer);
        for (int i = 0; i < customer.getVaccines().size(); i++) {
            if (customer.getVaccines().get(i).getId() == vaccine.getId()){
                customer.getVaccines().remove(i);
            }
        }
        writeListCustomers(listCustomers);
        return true;
    }

    /**
     * cập nhật student vào listStudents và lưu listStudents vào file
     *
     * @param customer
     */
    public void edit(Customer customer) {
        int size = listCustomers.size();
        for (int i = 0; i < size; i++) {
            if (listCustomers.get(i).getId() == customer.getId()) {
                listCustomers.get(i).setName(customer.getName());
                listCustomers.get(i).setAge(customer.getAge());
                listCustomers.get(i).setAddress(customer.getAddress());
                listCustomers.get(i).setPhone(customer.getPhone());
                writeListCustomers(listCustomers);
                break;
            }
        }
    }

    /**
     * xóa student từ listStudents và lưu listStudents vào file
     *
     * @param customer
     */
    public boolean delete(Customer customer) {
        boolean isFound = false;
        int size = listCustomers.size();
        for (int i = 0; i < size; i++) {
            if (listCustomers.get(i).getId() == customer.getId()) {
                customer = listCustomers.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listCustomers.remove(customer);
            writeListCustomers(listCustomers);
            return true;
        }
        return false;
    }

    public Customer findById(int id) {
        for (Customer c : listCustomers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public List<Customer> findAllByName(String name){
        List<Customer> customers = new ArrayList<>();
        for (Customer c:listCustomers) {
            if (c.getName().contains(name)){
                customers.add(c);
            }
        }
        return customers;
    }
    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortCustomerByName() {
        Collections.sort(listCustomers, new Comparator<Customer>() {
            public int compare(Customer customer1, Customer customer2) {
                return customer1.getName().compareTo(customer2.getName());
            }
        });
    }

    /**
     * sắp xếp danh sách student theo GPA theo tứ tự tăng dần
     */
//    public void sortStudentByGPA() {
//        Collections.sort(listCustomers, new Comparator<Customer>() {
//            public int compare(Customer customer1, Customer customer2) {
//                if (customer1.getGpa() > customer2.getGpa()) {
//                    return 1;
//                }
//                return -1;
//            }
//        });
//    }
    public List<Customer> getListStudents() {
        return listCustomers;
    }

    public void setListStudents(List<Customer> listCustomers) {
        this.listCustomers = listCustomers;
    }
}
