package org.fit.bai1.observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

// 3. Lớp Cổ phiếu (Concrete Subject): Chứa trạng thái thực sự (symbol, price)
public class Stock implements Subject {
    private String symbol;
    private double price;
    private List<Observer> investors = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    // Khi giá cổ phiếu thay đổi, tự động thông báo
    public void setPrice(double price) {
        this.price = price;
        System.out.println("\n[Hệ thống] Giá cổ phiếu " + symbol + " vừa thay đổi thành: $" + price);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        investors.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        investors.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer investor : investors) {
            investor.update(symbol, price); // Gửi dữ liệu mới nhất cho người theo dõi
        }
    }
}