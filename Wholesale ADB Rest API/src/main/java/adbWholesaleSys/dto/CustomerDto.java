package adbWholesaleSys.dto;

import java.util.Date;

public class CustomerDto {
    private int idCustomer;
    private int idAddress;
    private String companyName;
    private String nip;
    private String name;
    private String surname;

    public CustomerDto(){}

    public CustomerDto(int idCustomer, int idAddress, String companyName, String nip, String name, String surname) {
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
        this.companyName = companyName;
        this.nip = nip;
        this.name = name;
        this.surname = surname;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getNip() {
        return nip;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
