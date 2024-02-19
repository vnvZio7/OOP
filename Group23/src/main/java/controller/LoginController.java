package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import func.UserFunc;
import entity.User;
import view.LoginView;
import view.RegisterView;
import view.CustomerView;
import view.VaccineView;

public class LoginController {
    private UserFunc userDao;
    private LoginView loginView;
    private RegisterView registerView;
    private CustomerView customerView;
    private VaccineView vaccineView;
    public LoginController(LoginView view, RegisterView registerView) {
        this.loginView = view;
        this.registerView = registerView;
        this.userDao = new UserFunc();
        view.addLoginListener(new LoginListener());
        view.showRegisterView(new RegisterListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            entity.User user = loginView.getUser();
            if (userDao.checkUser(user)) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                customerView = new CustomerView();
                vaccineView = new VaccineView();
                vaccineView.setVisible(false);
                StudentController studentController = new StudentController(customerView,vaccineView);
                studentController.showStudentView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            loginView.setVisible(false);
            registerView.setVisible(true);
        }
    }
}