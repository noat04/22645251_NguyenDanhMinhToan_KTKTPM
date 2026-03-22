package org.fit.bai1.observer_design_pattern;

// 1. Giao diện Người quan sát: Định nghĩa cách các người quan sát nhận thông báo
public interface Observer {
    void update(String symbol, double price);
}
