package Seminar5OOP;

import Seminar5OOP.personal.controllers.UserController;
import Seminar5OOP.personal.model.FileOperation;
import Seminar5OOP.personal.model.FileOperationImpl;
import Seminar5OOP.personal.model.Repository;
import Seminar5OOP.personal.model.RepositoryFile;
import Seminar5OOP.personal.views.Validation;
import Seminar5OOP.personal.views.ViewUser;

public class Main {
    public static void main(String[] args) throws Exception {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        Repository repository = new RepositoryFile(fileOperation);
        UserController controller = new UserController(repository,new Validation());
        ViewUser view = new ViewUser(controller);
        view.run();
    }
    
}
