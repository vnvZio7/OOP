package controller;

import entity.User;
import func.UserFunc;
import view.LoginView;
import view.RegisterView;
import view.CustomerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private UserFunc userDao;
    private LoginView loginView;
    private RegisterView registerView;

    private CustomerView customerView;
    public RegisterController(LoginView view, RegisterView registerView) {
        this.loginView = view;
        this.registerView = registerView;
        this.userDao = new UserFunc();
        registerView.addRegisterListener(new RegisterListener());
    }

    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            entity.User user = registerView.getUser();
            if (userDao.checkUserName(user)) {
                userDao.add(user);
                loginView.setVisible(true);
                registerView.setVisible(false);
            } else {
                registerView.showMessage("username đang bị trùng hoặc để trống");
            }
        }
    }
}
