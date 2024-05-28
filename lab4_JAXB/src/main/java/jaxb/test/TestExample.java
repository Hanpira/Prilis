package jaxb.test;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: User
 * Date: 17.01.2022
 * Time: 19:43
 */

import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organisation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {

    private static final String XML_FILE = "dept-info.xml";

    public static void main(String[] args) {

        Employee emp1 = new Employee("A01", "Tom", null);
        Employee emp2 = new Employee("A02", "Mary", "E01");
        Employee emp3 = new Employee("A03", "John", null);

        Employee emp4 = new Employee("S01", "Chiara", null);
        Employee emp5 = new Employee("S02", "Tomaso", "E01");
        Employee emp6 = new Employee("S03", "Matteo", null);

        Employee emp7 = new Employee("C01", "Rick", null);
        Employee emp8 = new Employee("C02", "Laura", "E01");
        Employee emp9 = new Employee("C03", "Laviero", null);

        //accounting dep
        List<Employee> listA = new ArrayList<Employee>();
        listA.add(emp1);
        listA.add(emp2);
        listA.add(emp3);

        //software dep
        List<Employee> listS = new ArrayList<Employee>();
        listS.add(emp4);
        listS.add(emp5);
        listS.add(emp6);

        //consulting dep
        List<Employee> listC = new ArrayList<Employee>();
        listC.add(emp7);
        listC.add(emp8);
        listC.add(emp9);

        Department dept = new Department("D01", "ACCOUNTING", "NEW YORK");
        Department dept1 = new Department("D02", "Software", "Rome");
        Department dept2 = new Department("D03", "Consulting", "Milan");

        List<Department> list1 = new ArrayList<Department>();
        list1.add(dept);
        list1.add(dept1);
        list1.add(dept2);

        dept.setEmployees(listA);
        dept1.setEmployees(listS);
        dept2.setEmployees(listC);

        Organisation org = new Organisation("2", "Mersi");
        //List<Organisation> listOrg = new ArrayList<Organisation>();
        //listOrg.add(org);

        org.setDepartments(list1);

        try {

            // create JAXB context and instantiate marshaller
        //    JAXBContext context = JAXBContext.newInstance(Department.class);
            JAXBContext context = JAXBContext.newInstance(Organisation.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //    m.marshal(dept, System.out);
            m.marshal(org, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
        //    m.marshal(dept, outFile);
            m.marshal(org, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());
            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            // XML file create before.

            Organisation orgFromFile = (Organisation) um.unmarshal(new FileReader(XML_FILE));


            List<Department> deps = orgFromFile.getDepartments();

            for (Department depart : deps) {
                System.out.println("Department: " + depart.getDeptNo() + " " + depart.getDeptName() + " :");

                List<Employee> emps = depart.getEmployees();
                for (Employee emp : emps) {
                System.out.println("Employee " + emp.getEmpNo() + ": " + emp.getEmpName());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
