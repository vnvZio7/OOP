package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entity.Customer;
import entity.Vaccine;
import func.CustomerFunc;

public class demo extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addCustomerBtn;
    private JButton editCustomerBtn;
    private JButton deleteCustomerBtn;
    private JButton clearBtn;
    private JButton showAllBtn;

//    private JButton addVacBtn;
//    private JButton editVacBtn;
//    private JButton deleteVacBtn;
    private JButton searchBtn;
//    private JButton clearVacBtn;
    private JButton sortCustomerNameBtn;
    private JScrollPane jScrollPaneCustomerTable;
//    private JScrollPane jScrollPaneVaccineTable;
    private JScrollPane jScrollPaneAddress;
    private JTable CustomerTable;
//    private JTable VaccineTable;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel searchLabel;

//    private JLabel idVacLabel;
//    private JLabel nameVacLabel;
//    private JLabel priceVacLabel;
//    private JLabel injectAgainLabel;
//    private JLabel titleCustomerLabel;
//    private JLabel titleLabel;

//    private JTextField idVacField;
//    private JTextField nameVacField;
//    private JTextField priceVacField;
//    private JTextField injectAgainField;
    private JTextField searchField;

    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressTA;
    private JTextField phoneField;

    // định nghĩa các cột của bảng student
    private String[] columnCustomer = new String[]{
            "ID", "Name", "Age", "Address", "Phone"};
    private String[] columnVaccine = new String[]{
            "ID", "Name", "Price", "Ngày Tiêm", "Ngày Tiêm Lại"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object[][]{};
    private Object data2 = new Object[][]{};

    public demo() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addCustomerBtn = new JButton("Add");
        editCustomerBtn = new JButton("Edit");
        deleteCustomerBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        searchBtn = new JButton("Search");
        showAllBtn = new JButton("Show All Customer");

//        addVacBtn = new JButton("Add Vaccine");
//        editVacBtn = new JButton("Edit Vaccine");
//        deleteVacBtn = new JButton("Delete Vaccine");
//        clearVacBtn = new JButton("Clear Vaccine");

        sortCustomerNameBtn = new JButton("Sort By Name");

        jScrollPaneCustomerTable = new JScrollPane();
//        jScrollPaneVaccineTable = new JScrollPane();
        CustomerTable = new JTable();
//        VaccineTable = new JTable();

        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Age");
        addressLabel = new JLabel("Address");
        phoneLabel = new JLabel("Phone");
        searchLabel = new JLabel("Search Name");

//        idVacLabel = new JLabel("Id Vaccine");
//        nameVacLabel = new JLabel("Name Vaccine");
//        priceVacLabel = new JLabel("Price Vaccine");
//        injectAgainLabel = new JLabel("Inject Again");
//        titleCustomerLabel = new JLabel("Vaccine Đã Tiêm");
//        titleLabel = new JLabel("Danh Sách Khách Hàng Tiêm Chủng");
//        Font font = new Font("Arial", Font.BOLD, 24);
//        titleCustomerLabel.setFont(font);
//        titleLabel.setFont(font);

        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(15);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(15);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        phoneField = new JTextField(15);
        searchField = new JTextField(15);

//        idVacField = new JTextField(15);
//        idVacField.setEditable(false);
//        nameVacField = new JTextField(15);
//        priceVacField = new JTextField(15);
//        injectAgainField = new JTextField(15);

        // cài đặt các cột và data cho bảng student
        CustomerTable.setModel(new DefaultTableModel((Object[][]) data, columnCustomer));
//        VaccineTable.setModel(new DefaultTableModel((Object[][]) data2, columnVaccine));
        jScrollPaneCustomerTable.setViewportView(CustomerTable);
//        jScrollPaneVaccineTable.setViewportView(VaccineTable);
        jScrollPaneCustomerTable.setPreferredSize(new Dimension(550, 200));
//        jScrollPaneVaccineTable.setPreferredSize(new Dimension(550, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneCustomerTable);
//        panel.add(jScrollPaneVaccineTable);

        panel.add(addCustomerBtn);
        panel.add(editCustomerBtn);
        panel.add(deleteCustomerBtn);
        panel.add(clearBtn);
        panel.add(showAllBtn);

//        panel.add(addVacBtn);
//        panel.add(editVacBtn);
//        panel.add(deleteVacBtn);
//        panel.add(clearVacBtn);
        panel.add(searchBtn);
//        panel.add(titleLabel);

        panel.add(sortCustomerNameBtn);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(addressLabel);
        panel.add(phoneLabel);
//        panel.add(idVacLabel);
//        panel.add(nameVacLabel);
//        panel.add(priceVacLabel);
//        panel.add(titleCustomerLabel);
        panel.add(searchLabel);
//        panel.add(injectAgainLabel);
//        panel.add(injectAgainField);

        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(jScrollPaneAddress);
        panel.add(phoneField);
//        panel.add(idVacField);
//        panel.add(nameVacField);
//        panel.add(priceVacField);
        panel.add(searchField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneLabel, 250, SpringLayout.NORTH, panel);

//        layout.putConstraint(SpringLayout.WEST, idVacLabel, 10, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, idVacLabel, 390, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, nameVacLabel, 10, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, nameVacLabel, 420, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, priceVacLabel, 10, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, priceVacLabel, 450, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, injectAgainLabel, 10, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, injectAgainLabel, 480, SpringLayout.NORTH, panel);
//
//        layout.putConstraint(SpringLayout.WEST, titleCustomerLabel, 10, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, titleCustomerLabel, 340, SpringLayout.NORTH, panel);
//
//        layout.putConstraint(SpringLayout.WEST, titleLabel, 10, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, titleLabel, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, searchLabel, 500, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchLabel, 30, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchField, 100, SpringLayout.WEST, searchLabel);
        layout.putConstraint(SpringLayout.NORTH, searchField, 25, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchBtn, 190, SpringLayout.WEST, searchField);
        layout.putConstraint(SpringLayout.NORTH, searchBtn, 25, SpringLayout.NORTH, panel);


        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 60, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 90, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 120, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 150, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, phoneField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, phoneField, 250, SpringLayout.NORTH, panel);

//        layout.putConstraint(SpringLayout.WEST, idVacField, 100, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, idVacField, 390, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, nameVacField, 100, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, nameVacField, 420, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, priceVacField, 100, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, priceVacField, 450, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, injectAgainField, 100, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, injectAgainField, 480, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneCustomerTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneCustomerTable, 60, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, jScrollPaneVaccineTable, 300, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, jScrollPaneVaccineTable, 350, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addCustomerBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addCustomerBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editCustomerBtn, 80, SpringLayout.WEST, addCustomerBtn);
        layout.putConstraint(SpringLayout.NORTH, editCustomerBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteCustomerBtn, 80, SpringLayout.WEST, editCustomerBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteCustomerBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteCustomerBtn);

//        layout.putConstraint(SpringLayout.WEST, addVacBtn, 20, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, addVacBtn, 510, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, editVacBtn, 130, SpringLayout.WEST, addVacBtn);
//        layout.putConstraint(SpringLayout.NORTH, editVacBtn, 510, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, deleteVacBtn, 20, SpringLayout.WEST, panel);
//        layout.putConstraint(SpringLayout.NORTH, deleteVacBtn, 550, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.NORTH, clearVacBtn, 550, SpringLayout.NORTH, panel);
//        layout.putConstraint(SpringLayout.WEST, clearVacBtn, 130, SpringLayout.WEST, deleteVacBtn);


        layout.putConstraint(SpringLayout.NORTH, sortCustomerNameBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortCustomerNameBtn, 80, SpringLayout.WEST, clearBtn);
        layout.putConstraint(SpringLayout.NORTH, showAllBtn, 290, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, showAllBtn, 180, SpringLayout.NORTH, sortCustomerNameBtn);

        this.add(panel);
        this.pack();
        this.setTitle("Customer Information");
        this.setSize(950, 630);
        // disable Edit and Delete buttons
        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        addCustomerBtn.setEnabled(true);

//        editVacBtn.setEnabled(false);
//        deleteVacBtn.setEnabled(false);
//        addVacBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list student vào bảng studentTable
     *
     * @param list
     */
    public void showListCustomers(List<Customer> list) {
        int size = list.size();
        // với bảng studentTable có 5 cột, 
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student 
        // số cột: là 5
        Object[][] students = new Object[size][5];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getAge();
            students[i][3] = list.get(i).getAddress();
            students[i][4] = list.get(i).getPhone();
        }
        CustomerTable.setModel(new DefaultTableModel(students, columnCustomer));
    }

    /**
     * điền thông tin của hàng được chọn từ bảng student
     * vào các trường tương ứng của student.
     */
    public void fillCustomerFromSelectedRow() {
        CustomerFunc customerFunc = new CustomerFunc();
        // lấy chỉ số của hàng được chọn 
        int row = CustomerTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(CustomerTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(CustomerTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(CustomerTable.getModel().getValueAt(row, 2).toString());
            addressTA.setText(CustomerTable.getModel().getValueAt(row, 3).toString());
            phoneField.setText(CustomerTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editCustomerBtn.setEnabled(true);
            deleteCustomerBtn.setEnabled(true);
            // disable Add button
            addCustomerBtn.setEnabled(false);
            int id = Integer.parseInt(CustomerTable.getModel().getValueAt(row, 0).toString());
            List<Vaccine> vaccines = customerFunc.findById(id).getVaccines();
//            showListVaccine(vaccines);
//            clearVaccineInfo();
        }
    }

//    public void fillVaccineFromSelectedRow() {
//        int row = VaccineTable.getSelectedRow();
//        if (row >= 0) {
//            idVacField.setText(VaccineTable.getModel().getValueAt(row, 0).toString());
//            nameVacField.setText(VaccineTable.getModel().getValueAt(row, 1).toString());
//            priceVacField.setText(VaccineTable.getModel().getValueAt(row, 2).toString());
//            injectAgainField.setText(VaccineTable.getModel().getValueAt(row, 3).toString());
//            editVacBtn.setEnabled(true);
//            deleteVacBtn.setEnabled(true);
//            addVacBtn.setEnabled(false);
//        }
//    }

//    public void showListVaccine(List<Vaccine> list) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        int size = list.size();
//        Object[][] vaccines = new Object[size][5];
//        for (int i = 0; i < size; i++) {
//            vaccines[i][0] = list.get(i).getId();
//            vaccines[i][1] = list.get(i).getName();
//            vaccines[i][2] = list.get(i).getPrice();
//            vaccines[i][3] = formatter.format(list.get(i).getVaccinDate());
//            vaccines[i][4] = formatter.format(list.get(i).getInjectAgain());
//        }
//        VaccineTable.setModel(new DefaultTableModel(vaccines, columnVaccine));
//    }


    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressTA.setText("");
        phoneField.setText("");
        // disable Edit and Delete buttons
        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        // enable Add button
        addCustomerBtn.setEnabled(true);
    }

//    public void clearVaccineInfo() {
//        idVacField.setText("");
//        nameVacField.setText("");
//        priceVacField.setText("");
//        injectAgainField.setText("");
//        // disable Edit and Delete buttons
//        editVacBtn.setEnabled(false);
//        deleteVacBtn.setEnabled(false);
//        // enable Add button
//        addVacBtn.setEnabled(true);
//    }

    /**
     * hiện thị thông tin student
     *
     * @param customer
     */
    public void showStudent(Customer customer) {
        idField.setText("" + customer.getId());
        nameField.setText(customer.getName());
        ageField.setText("" + customer.getAge());
        addressTA.setText(customer.getAddress());
        phoneField.setText("" + customer.getPhone());
        // enable Edit and Delete buttons
        editCustomerBtn.setEnabled(true);
        deleteCustomerBtn.setEnabled(true);
        // disable Add button
        addCustomerBtn.setEnabled(false);
    }

    public String getNameSearch() {
        String name = searchField.getText();
        if (!name.equals("")) {
            return name;
        }
        return null;
    }

    /**
     * lấy thông tin student
     *
     * @return
     */
    public Customer getStudentInfo() {
        // validate student
        if (!validateName() || !validateAge() || !validateAddress() || !validatePhone()) {
            return null;
        }
        try {
            Customer customer = new Customer();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                customer.setId(Integer.parseInt(idField.getText()));
            }
            customer.setName(nameField.getText().trim());
            customer.setAge(Byte.parseByte(ageField.getText().trim()));
            customer.setAddress(addressTA.getText().trim());
            customer.setPhone(phoneField.getText().trim());
            return customer;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

//    public Vaccine getVaccineInfo() {
//        try {
//            Vaccine vaccine = new Vaccine();
//            if (idVacField.getText() != null && !"".equals(idVacField.getText())) {
//                vaccine.setId(Integer.parseInt(idVacField.getText()));
//            }
//            vaccine.setName(nameVacField.getText().trim());
//            vaccine.setPrice(Double.parseDouble(priceVacField.getText().trim()));
//
//            String inputDate = injectAgainField.getText();
//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//
//            Date date = dateFormat.parse(inputDate);
//            vaccine.setInjectAgain(date);
//            return vaccine;
//        } catch (ParseException ex) {
//            showMessage("Ngày không hợp lệ. (VD: 20/11/2022)");
//        } catch (Exception e) {
//            showMessage(e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }

    public int getIdCustomer() {
        String id = idField.getText();
        if (id.equals("")) {
            return -1;
        }
        return Integer.parseInt(id);
    }

    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Address không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAge() {
        try {
            Byte age = Byte.parseByte(ageField.getText().trim());
            if (age < 0 || age > 100) {
                ageField.requestFocus();
                showMessage("Age không hợp lệ, age nên trong khoảng 0 đến 100.");
                return false;
            }
        } catch (Exception e) {
            ageField.requestFocus();
            showMessage("Age không hợp lệ!");
            return false;
        }
        return true;
    }

    private boolean validatePhone() {
        try {
            Integer.parseInt(phoneField.getText().trim());

            if (phoneField.getText().trim().length() != 10) {
                phoneField.requestFocus();
                showMessage("Phone không hợp lệ, phải là 10 ký tự.");
                return false;
            }
        } catch (Exception e) {
            phoneField.requestFocus();
            showMessage("Phone phải là số");
            return false;
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddStudentListener(ActionListener listener) {
        addCustomerBtn.addActionListener(listener);
    }

    public void searchCustomerListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }

    public void showAllCustomerListener(ActionListener listener) {
        showAllBtn.addActionListener(listener);
    }

    public void addAddVaccineListener(ActionListener listener) {
//        addVacBtn.addActionListener(listener);
    }

    public void addEdiStudentListener(ActionListener listener) {
        editCustomerBtn.addActionListener(listener);
    }

    public void addEdiVaccineListener(ActionListener listener) {
//        editVacBtn.addActionListener(listener);
    }

    public void addDeleteStudentListener(ActionListener listener) {
        deleteCustomerBtn.addActionListener(listener);
    }

    public void addDeleteVaccineListener(ActionListener listener) {
//        deleteVacBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addClearVaccineListener(ActionListener listener) {
//        clearVacBtn.addActionListener(listener);
    }

//    public void addSortStudentGPAListener(ActionListener listener) {
//        sortStudentGPABtn.addActionListener(listener);
//    }

    public void addSortStudentNameListener(ActionListener listener) {
        sortCustomerNameBtn.addActionListener(listener);
    }

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        CustomerTable.getSelectionModel().addListSelectionListener(listener);
    }

    public void addListVaccineSelectionListener(ListSelectionListener listener) {
//        VaccineTable.getSelectionModel().addListSelectionListener(listener);
    }
}
