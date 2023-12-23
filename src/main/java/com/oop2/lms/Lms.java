/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.oop2.lms;

import com.oop2.lms.frame.DashboardFrame;
import com.oop2.lms.frame.HomeFrame;
import com.oop2.lms.frame.LoginFrame;
import com.oop2.lms.model.User;
import com.oop2.lms.util.Session;

/**
 *
 * @author Guinita
 */
public class Lms {

    public static void main(String[] args) {
        User user = Session.getLoggedInUser();
        if (user == null) {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        }
        if(user.getRole().equals("user")){
            HomeFrame homeFrame = new HomeFrame();
            homeFrame.setVisible(true);
            return;
        }
        DashboardFrame dashboardFrame = new DashboardFrame();
        dashboardFrame.setVisible(true);
    }
}
