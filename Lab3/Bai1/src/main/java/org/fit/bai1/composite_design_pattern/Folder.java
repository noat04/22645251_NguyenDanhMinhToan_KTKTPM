package org.fit.bai1.composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// 3. Lớp Thư mục (Hợp thể - có thể chứa thêm các Tập tin hoặc Thư mục khác)
public class Folder implements FileSystemNode {
    private String name;
    // Danh sách chứa các thành phần con, có thể là File hoặc Folder
    private List<FileSystemNode> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemNode component) {
        children.add(component);
    }

    public void removeComponent(FileSystemNode component) {
        children.remove(component);
    }

    @Override
    public void hienThiThongTin(String lùi) {
        System.out.println(lùi + "+ Thư mục: " + name);
        // Duyệt qua tất cả các con và gọi showDetails của chúng (Đệ quy)
        for (FileSystemNode component : children) {
            component.hienThiThongTin(lùi + "    ");
        }
    }
}