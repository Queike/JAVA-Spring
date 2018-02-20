package adbWholesaleSys.dto;

public class ManufacturerDto {
    private int idManufacturer;
    private String designation;

    public ManufacturerDto(){}

    public ManufacturerDto(int idManufacturer, String designation) {
        this.idManufacturer = idManufacturer;
        this.designation = designation;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public String getDesignation() {
        return designation;
    }
}
