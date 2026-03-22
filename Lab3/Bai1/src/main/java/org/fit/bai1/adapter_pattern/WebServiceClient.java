package org.fit.bai1.adapter_pattern;

// WebServiceClient.java
// Đây là khách hàng, hệ thống hiện đại, chỉ biết JSON và sử dụng giao diện JsonTarget.

public class WebServiceClient {
    public static void main(String[] args) {
        // 1. Khởi tạo hệ thống cũ (chỉ có XML)
        LegacyXmlSystem oldSystem = new LegacyXmlSystem();

        // 2. Sử dụng Adapter để hệ thống mới (chuẩn JSON) có thể đọc được dữ liệu cũ
        JsonTarget jsonWebService = new XmlToJsonAdapter(oldSystem);

        // 3. Khách hàng gửi yêu cầu JSON
        String jsonData = "{\"user\":{\"name\":\"Toan\",\"role\":\"Admin\"}}";
        System.out.println("[Client] Gửi JSON Request: " + jsonData);

        // 4. Khách hàng sử dụng giao diện JsonTarget, không cần biết đến LegacyXmlSystem hay XmlToJsonAdapter
        String jsonResponse = jsonWebService.processJsonRequest(jsonData);

        // 5. Khách hàng nhận được kết quả JSON
        System.out.println("[Client] Nhận JSON Response: " + jsonResponse);
    }
}
