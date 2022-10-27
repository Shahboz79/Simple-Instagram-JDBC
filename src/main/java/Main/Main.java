package Main;

import Controller.UserController;
import Util.Util;
import model.User;

public class Main {
    public static User currentUser = null;
    public static void main(String[] args) {
        int number = -1;
        do {
            if (currentUser==null){
                System.out.print("1.Login\n" +
                        "2.Register\n" +
                        "0.Exit\n" +
                        "Enter number: ");
                number = Util.SCANNER_INT.nextInt();

                switch (number){
                    case 1:
                        UserController.login();
                        break;
                    case 2:
                        UserController.register();
                }

            }else {
                UserController.menu();
            }

        }while (number!=0);
    }
}
