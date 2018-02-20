package adbWholesaleSys.dto;

public class OrderItemDto {
    private int idOrderItem;
    private int idOrder;
    private int idArticle;
    private int quantity;

    public OrderItemDto(){}

    public OrderItemDto(int idOrderItem, int idOrder, int idArticle, int quantity) {
        this.idOrderItem = idOrderItem;
        this.idOrder = idOrder;
        this.idArticle = idArticle;
        this.quantity = quantity;
    }

    public int getIdOrderItem() {
        return idOrderItem;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public int getQuantity() {
        return quantity;
    }
}
