//package qlsv;

import java.awt.EventQueue;

import controller.LoginController;
import view.LoginView;
import view.RegisterView;   
import view.VaccineView;
import view.demo;

public class App {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                VaccineView dm = new VaccineView();
//                dm.setVisible(true);
                LoginView view = new LoginView();
                RegisterView registerView = new RegisterView();
                LoginController controller = new LoginController(view, registerView);
                // hiển thị màn hình login
                controller.showLoginView();
            }
        });
    }
}