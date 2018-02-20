package adbWholesaleSys.dto;

import java.math.BigDecimal;

public class ArticleDto {
    private int idArticle;
    private int idPicture;
    private String name;
    private BigDecimal price;
    private String description;

    public ArticleDto(){}

    public ArticleDto(int idArticle, int idPicture, String name, BigDecimal price, String description){
        this.idArticle = idArticle;
        this.idPicture = idPicture;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public int getIdPicture() {
        return idPicture;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
