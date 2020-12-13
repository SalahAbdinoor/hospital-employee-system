import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Salah Abdinoor
 * 12/7/2020
 * 4:13 PM
 * AOD2Employee
 * Copyright: MIT
 */
public class DAO {

    private Scanner s;
    private String data;

    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private String salary;
    private String department;
    private String phoneNumber;
    private String specialization;
    private String userID;

    public static final String cardiologyFile = "Lists\\CardiologyEmployees";
    public static final String surgeryFile = "Lists\\SurgeryEmployees";
    public static final String criticalCareFile = "Lists\\CriticalCareEmployees";
    public static final String anaestheticsFile = "Lists\\AnaestheticsEmployees";

    public static final String cardiology = "Cardiology";
    public static final String anaesthetics = "Anaesthetics";
    public static final String surgery = "Surgery";
    public static final String criticalCare = "Critical care";


    public List<Employee>  surgeryList = new ArrayList<>();

    public List<Employee> anaestheticsList = new ArrayList<>();

    public List<Employee> cardiologyList = new ArrayList<>();

    public List<Employee> criticalCareList = new ArrayList<>();


    public DAO() throws FileNotFoundException {
        createSurgeryList(surgeryFile, surgeryList);
        createCriticalCareList(criticalCareFile, criticalCareList);
        createCardiologyList(cardiologyFile, cardiologyList);
        createAnaestheticsList(anaestheticsFile, anaestheticsList);

    }

    private void createAnaestheticsList(String anaestheticsFile, List<Employee> anaestheticsList) throws FileNotFoundException {
        updateEmployeeList(anaestheticsFile, anaestheticsList);
    }

    private void createCardiologyList(String cardiologyFile, List<Employee> cardiologyList) throws FileNotFoundException {
        updateEmployeeList(cardiologyFile, cardiologyList);
    }

    private void createCriticalCareList(String criticalCareFile, List<Employee> criticalCareList) throws FileNotFoundException {
        updateEmployeeList(criticalCareFile, criticalCareList);
    }

    private void createSurgeryList(String surgeryFile, List<Employee> surgeryList) throws FileNotFoundException {
        updateEmployeeList(surgeryFile, surgeryList);
    }

    public void updateEmployeeList(String filePath, List<Employee> list) throws FileNotFoundException {
        s = new Scanner(new FileReader(filePath));
        try {

            while (s.hasNextLine()) {
                data = s.nextLine();
                if (data.isEmpty()){
                    continue;
                }
                    String[] temp = data.split(",");
                    firstName = temp[0];
                    lastName = temp[1];
                    gender = temp[2];
                    birthDate = temp[3];
                    department = temp[4];
                    phoneNumber = temp[5];
                    salary = temp[6];
                    specialization = temp[7];
                    userID = temp[8];

                    list.add(new Employee(firstName, lastName, gender, birthDate, department, phoneNumber, salary, specialization, userID));

            }
            s.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        for (Employee e:list
             ) {
            System.out.println(e.getUserID());
        }
    }



}