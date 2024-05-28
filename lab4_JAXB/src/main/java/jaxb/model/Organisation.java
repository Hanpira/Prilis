package jaxb.model;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organisation")
@XmlAccessorType(XmlAccessType.FIELD)

public class Organisation {
    private String orgNo;
    private String orgName;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    public Organisation() {

    }

    public Organisation(String orgNo, String orgName) {
        this.orgNo = orgNo;
        this.orgName = orgName;
    }


    public String getOrgNo() {
        return orgNo;
    }
    public void setOrgNo (String orgName) {
        this.orgNo = orgNo;
    }


    public String getOrgName() {
        return orgName;
    }
    public void setOrgName (String orgName) {
        this.orgNo = orgNo;
    }


    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
