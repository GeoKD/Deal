package KedelidzeKrutyakov.deal.persistence.entity;

import KedelidzeKrutyakov.deal.enums.EmploymentStatus;
import KedelidzeKrutyakov.deal.enums.Position;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Period;

public class Employment implements Serializable {
    private EmploymentStatus employmentStatus;
    private String employerINN;
    private BigDecimal Salary;
    private Position position;
    private Period workExperienceTotal;
    private Period workExperienceCurrent;

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(EmploymentStatus employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getEmployerINN() {
        return employerINN;
    }

    public void setEmployerINN(String employerINN) {
        this.employerINN = employerINN;
    }

    public BigDecimal getSalary() {
        return Salary;
    }

    public void setSalary(BigDecimal salary) {
        Salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Period getWorkExperienceTotal() {
        return workExperienceTotal;
    }

    public void setWorkExperienceTotal(Period workExperienceTotal) {
        this.workExperienceTotal = workExperienceTotal;
    }

    public Period getWorkExperienceCurrent() {
        return workExperienceCurrent;
    }

    public void setWorkExperienceCurrent(Period workExperienceCurrent) {
        this.workExperienceCurrent = workExperienceCurrent;
    }
}
