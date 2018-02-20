package adbWholesaleSys.dto;

public class ArticlesDeliversDto {
    private int idArticlesDelivers;
    private int idArticle;
    private int idManufacturer;
    private int quantity;

    public ArticlesDeliversDto(){}

    public ArticlesDeliversDto(int idArticlesDelivers, int idArticle, int idManufacturer, int quantity) {
        this.idArticlesDelivers = idArticlesDelivers;
        this.idArticle = idArticle;
        this.idManufacturer = idManufacturer;
        this.quantity = quantity;
    }

    public int getIdArticlesDelivers() {
        return idArticlesDelivers;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public int getQuantity() {
        return quantity;
    }
}
