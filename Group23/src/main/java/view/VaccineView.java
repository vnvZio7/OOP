package view;

//import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooser;
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

import entity.Vaccine;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class VaccineView extends JFrame implements ActionListener, ListSelectionListener {

    private static final long serialVersionUID = 1L;
    private JButton addVacBtn;
    private JButton editVacBtn;
    private JButton deleteVacBtn;
    private JButton closeBtn;
    private JButton clearVacBtn;
    private JScrollPane jScrollPaneVaccineTable;
    private JTable VaccineTable;

    private JLabel idVacLabel;
    private JLabel nameVacLabel;
    private JLabel priceVacLabel;
    private JLabel injectAgainLabel;
    private JLabel titleCustomerLabel;
    private JDateChooser injectAgainField = new JDateChooser();
    private JTextField idVacField;
    private JTextField priceVacField;

    private String[] columnVaccine = new String[]{
        "ID", "Name", "Price", "Ngày Tiêm", "Ngày Tiêm Lại"};
//     định nghĩa dữ liệu mặc định của bẳng student là rỗng

    String city[] = {"Lao", "Phổi", "Viêm tai giữa", "Viêm gan B", "Uốn ván", "Tiêu chảy", "Covid 19 mũi 1", "Covid 19 mũi 2", "Covid 19 mũi 3", "Covid 19 mũi 4"};

    JComboBox nameVacField = new JComboBox(city);
    private Object data2 = new Object[][]{};

    public VaccineView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng

        addVacBtn = new JButton("Add Vaccine");
        editVacBtn = new JButton("Edit Vaccine");
        deleteVacBtn = new JButton("Delete Vaccine");
        clearVacBtn = new JButton("Clear Vaccine");
        closeBtn = new JButton("Close");

        jScrollPaneVaccineTable = new JScrollPane();
        VaccineTable = new JTable();

        // khởi tạo các label
        idVacLabel = new JLabel("Id Vaccine");
        nameVacLabel = new JLabel("Name Vaccine");
        priceVacLabel = new JLabel("Price Vaccine");
        injectAgainLabel = new JLabel("Inject Again");
        titleCustomerLabel = new JLabel("Vaccine Đã Tiêm");
        Font font = new Font("Arial", Font.BOLD, 24);
        titleCustomerLabel.setFont(font);
        nameVacField.setSelectedIndex(0);
        // khởi tạo các trường nhập dữ liệu cho student

        idVacField = new JTextField(15);
        idVacField.setEditable(false);
        priceVacField = new JTextField(15);
        // cài đặt các cột và data cho bảng student
        VaccineTable.setModel(new DefaultTableModel((Object[][]) data2, columnVaccine));
        jScrollPaneVaccineTable.setViewportView(VaccineTable);
        jScrollPaneVaccineTable.setPreferredSize(new Dimension(550, 200));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(1100, 1000);
        panel.setLayout(layout);
        panel.add(jScrollPaneVaccineTable);

        panel.add(addVacBtn);
        panel.add(editVacBtn);
        panel.add(deleteVacBtn);
        panel.add(clearVacBtn);
        panel.add(closeBtn);

        panel.add(idVacLabel);
        panel.add(nameVacLabel);
        panel.add(priceVacLabel);
        panel.add(titleCustomerLabel);
        panel.add(injectAgainLabel);
        panel.add(injectAgainField);

        panel.add(idVacField);
        panel.add(nameVacField);
        panel.add(priceVacField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idVacLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idVacLabel, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameVacLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameVacLabel, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, priceVacLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, priceVacLabel, 250, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, injectAgainLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, injectAgainLabel, 280, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, titleCustomerLabel, 40, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleCustomerLabel, 50, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idVacField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idVacField, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameVacField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameVacField, 220, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, priceVacField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, priceVacField, 250, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, injectAgainField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, injectAgainField, 280, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneVaccineTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneVaccineTable, 180, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addVacBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addVacBtn, 310, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editVacBtn, 130, SpringLayout.WEST, addVacBtn);
        layout.putConstraint(SpringLayout.NORTH, editVacBtn, 310, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteVacBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, deleteVacBtn, 350, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, clearVacBtn, 350, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearVacBtn, 130, SpringLayout.WEST, deleteVacBtn);
        layout.putConstraint(SpringLayout.NORTH, closeBtn, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, closeBtn, 830, SpringLayout.WEST, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Customer Information");
        this.setSize(950, 630);
        // disable Edit and Delete buttons
        editVacBtn.setEnabled(false);
        deleteVacBtn.setEnabled(false);
        addVacBtn.setEnabled(true);

        setLocationRelativeTo(null);

    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void fillVaccineFromSelectedRow() {
        int row = VaccineTable.getSelectedRow();
        if (row >= 0) {
            idVacField.setText(VaccineTable.getModel().getValueAt(row, 0).toString());
            int tmp = 0;
            for (int i = 0; i < city.length; i++) {
                if (city[i].equals(VaccineTable.getModel().getValueAt(row, 1).toString())) {
                    tmp = i;
                    break;
                }
            }
            nameVacField.setSelectedIndex(tmp);
            priceVacField.setText(VaccineTable.getModel().getValueAt(row, 2).toString());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date date = injectAgainField.getDate();
            try {
                date = dateFormat.parse(VaccineTable.getModel().getValueAt(row, 4).toString());
            } catch (ParseException ex) {
                Logger.getLogger(VaccineView.class.getName()).log(Level.SEVERE, null, ex);
            }
            injectAgainField.setDate(date);
            editVacBtn.setEnabled(true);
            deleteVacBtn.setEnabled(true);
            addVacBtn.setEnabled(false);
        }
    }

    public void showListVaccine(List<Vaccine> list) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int size = list.size();
        Object[][] vaccines = new Object[size][5];
        for (int i = 0; i < size; i++) {
            vaccines[i][0] = list.get(i).getId();
            vaccines[i][1] = list.get(i).getName();
            vaccines[i][2] = list.get(i).getPrice();
            vaccines[i][3] = formatter.format(list.get(i).getVaccinDate());
            vaccines[i][4] = formatter.format(list.get(i).getInjectAgain());
        }
        VaccineTable.setModel(new DefaultTableModel(vaccines, columnVaccine));
        clearVaccineInfo();
    }

    public void clearVaccineInfo() {
        idVacField.setText("");
        nameVacField.setSelectedIndex(-1);
        priceVacField.setText("");
        injectAgainField.setDate(null);
        // disable Edit and Delete buttons
        editVacBtn.setEnabled(false);
        deleteVacBtn.setEnabled(false);
        // enable Add button
        addVacBtn.setEnabled(true);
    }

    public Vaccine getVaccineInfo() {
        try {
            Vaccine vaccine = new Vaccine();
            if (idVacField.getText() != null && !"".equals(idVacField.getText())) {
                vaccine.setId(Integer.parseInt(idVacField.getText()));
            }
            vaccine.setName((String) nameVacField.getItemAt(nameVacField.getSelectedIndex()));
            vaccine.setPrice(Double.parseDouble(priceVacField.getText().trim()));

            Date inputDate = injectAgainField.getDate();
            vaccine.setInjectAgain(inputDate);
            return vaccine;
        } catch (Exception e) {
            showMessage(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void closeBtnListener(ActionListener listener) {
        closeBtn.addActionListener(listener);
    }

    public void addAddVaccineListener(ActionListener listener) {
        addVacBtn.addActionListener(listener);
    }

    public void addEdiVaccineListener(ActionListener listener) {
        editVacBtn.addActionListener(listener);
    }

    public void addDeleteVaccineListener(ActionListener listener) {
        deleteVacBtn.addActionListener(listener);
    }

    public void addClearVaccineListener(ActionListener listener) {
        clearVacBtn.addActionListener(listener);
    }

    public void addListVaccineSelectionListener(ListSelectionListener listener) {
        VaccineTable.getSelectionModel().addListSelectionListener(listener);
    }
}
