package org.fit.bai1.composite_design_pattern;

// 2. Lớp Tập tin (Lá - không thể chứa thêm các thành phần khác)
class File implements FileSystemNode {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void hienThiThongTin(String lùi) {
        System.out.println(lùi + "- Tập tin: " + name);
    }
}