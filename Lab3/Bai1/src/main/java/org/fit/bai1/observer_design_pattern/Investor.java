package org.fit.bai1.observer_design_pattern;

// 4. Lớp Nhà đầu tư (Concrete Observer): Cập nhật trạng thái khi nhận thông báo
public class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println(" -> Nhà đầu tư " + name + " nhận được thông báo: " + stockSymbol + " giá mới là $" + price);
    }
}