package org.fit.bai1.adapter_pattern;

// JsonTarget.java
// Đây là giao diện mà khách hàng (WebServiceClient) mong muốn sử dụng.
// Nó chỉ định nghĩa các phương thức liên quan đến JSON.

public interface JsonTarget {
    // Hàm này được gọi bởi Client để gửi dữ liệu JSON và nhận kết quả JSON
    String processJsonRequest(String jsonData);

    // Hàm này cho phép chuyển đổi XML sang JSON (khi cần)
    String convertXmlToJson(String xmlData);
}
