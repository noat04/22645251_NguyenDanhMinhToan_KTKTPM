package org.fit.bai1.observer_design_pattern;

public class ObserverMain {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.0);

        Investor inv1 = new Investor("Nguyễn Văn A");
        Investor inv2 = new Investor("Trần Thị B");

        // Đăng ký theo dõi
        appleStock.registerObserver(inv1);
        appleStock.registerObserver(inv2);

        // Mô phỏng giá cổ phiếu thay đổi
        appleStock.setPrice(155.0);

        // B ngừng theo dõi, C vào theo dõi
        appleStock.removeObserver(inv2);
        appleStock.registerObserver(new Investor("Lê Văn C"));

        appleStock.setPrice(160.0);
    }
}
