package JDBC1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

//        productManager.updateDetailProduct(4,"Dữ liệu mới");
        productManager.selectAllProduct();
//        productManager.updateManufacturerAndPrice(2,"apple",12000000);
//        productManager.updateNumberAndStatusProduct(6,20,"0");
//        productManager.deleteProduct(4);


    }
}