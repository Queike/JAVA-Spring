package adbWholesaleSys.dto;

import java.sql.Date;

public class WorkerDto {
    private int idWorker;
    private String forename;
    private String surname;
    private String pesel;
    private Date dateOfEmployment;
    private Date dateOfRelease;

    public WorkerDto(){}

    public WorkerDto(int idEmployee, String forename, String surname, String pesel, Date dateOfEmployment, Date dateOfRelease) {
        this.idWorker = idEmployee;
        this.forename = forename;
        this.surname = surname;
        this.pesel = pesel;
        this.dateOfEmployment = dateOfEmployment;
        this.dateOfRelease = dateOfRelease;
    }

    // alt + insert

    public int getIdEmployee() {
        return idWorker;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }
}


