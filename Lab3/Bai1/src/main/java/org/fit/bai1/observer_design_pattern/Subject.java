package org.fit.bai1.observer_design_pattern;

// 2. Giao diện Chủ thể: Định nghĩa các phương thức để chủ thể có thể quản lý người quan sát
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
