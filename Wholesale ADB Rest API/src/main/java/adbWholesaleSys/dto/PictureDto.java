package adbWholesaleSys.dto;

public class PictureDto {
    private int idPicture;
    private String picture;

    public PictureDto(){}

    public PictureDto(int idPicture, String picture) {
        this.idPicture = idPicture;
        this.picture = picture;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public String getPicture() {
        return picture;
    }
}
