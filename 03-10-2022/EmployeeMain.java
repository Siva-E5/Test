import com.element5.controller.*;

/**
 * <p>
 * This class I have created a method that method access the Employee controller
 * class
 * <p>
 *
 * @version java "18.0.2.1".
 * @author Sivaramakrishnan
 */
public class EmployeeMain {

	/**
	 * <p>
	 * This main method I have created the object for Employee controller class to
	 * access that class members.
	 * </p>
	 */
	public static void main(String args[]) {
		EmployeeController employeeController = new EmployeeController();
		employeeController.employeeMenuView();
	}

}