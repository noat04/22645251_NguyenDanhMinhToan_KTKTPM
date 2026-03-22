package org.fit.bai1.adapter_pattern;

// LegacyXmlSystem.java
// Đây là hệ thống cũ, chỉ cung cấp và hiểu XML.
// Nó không tương thích với JsonTarget và có giao diện riêng.

public class LegacyXmlSystem {
    // Phương thức này gửi yêu cầu XML và nhận kết quả XML
    public String sendXmlRequest(String xmlData) {
        System.out.println("\n[Hệ thống cũ] Nhận XML: " + xmlData);
        // Mô phỏng logic xử lý (chỉ trả về một XML khác)
        return "<response><status>success</status><data>Processed:" + xmlData + "</data></response>";
    }
}