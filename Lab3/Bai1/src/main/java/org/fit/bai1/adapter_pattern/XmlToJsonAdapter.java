package org.fit.bai1.adapter_pattern;

// XmlToJsonAdapter.java
// Lớp này là cầu nối giữa JsonTarget và LegacyXmlSystem.
// Nó triển khai JsonTarget nhưng trong nội bộ chứa một tham chiếu đến LegacyXmlSystem.

public class XmlToJsonAdapter implements JsonTarget {
    private LegacyXmlSystem xmlSystem;

    // Nhận hệ thống XML cũ vào thông qua constructor (aggregation)
    public XmlToJsonAdapter(LegacyXmlSystem xmlSystem) {
        this.xmlSystem = xmlSystem;
    }

    @Override
    public String processJsonRequest(String jsonData) {
        // B1: Chuyển đổi JSON Data -> XML Data (Request)
        String xmlData = jsonToXml(jsonData);
        System.out.println("[Adapter] Đã chuyển JSON -> XML: " + xmlData);

        // B2: Gọi phương thức trên hệ thống cũ với XML Data
        String xmlResponse = xmlSystem.sendXmlRequest(xmlData);
        System.out.println("[Adapter] Đã nhận XML từ hệ thống cũ: " + xmlResponse);

        // B3: Chuyển đổi XML Response -> JSON Data (Response)
        String jsonResponse = xmlToJson(xmlResponse);
        System.out.println("[Adapter] Đã chuyển XML -> JSON: " + jsonResponse);

        // B4: Trả kết quả JSON cho Client
        return jsonResponse;
    }

    @Override
    public String convertXmlToJson(String xmlData) {
        // Hàm này cho phép chuyển đổi một XML bất kỳ sang JSON (khi cần)
        return xmlToJson(xmlData);
    }

    // --- CÁC HÀM TRỢ GIÚP (PRIVATE) ---
    // Logic chuyển đổi JSON sang XML (Mô phỏng bằng String reresentation)
    private String jsonToXml(String json) {
        // Giả sử chuyển đổi:
        // {"user":{"name":"Toan","role":"Admin"}} -> "<user><name>Toan</name><role>Admin</role></user>"
        // Trong thực tế sẽ dùng thư viện như Jackson/Gson
        return json.replace("\"", "") // Loại bỏ dấu ngoặc kép
                .replace(":", ">") // Thay dấu hai chấm bằng dấu ngoặc góc
                .replace(",", "</") // Thay dấu phẩy bằng dấu ngoặc góc đóng
                .replace("{", "<") // Thay dấu ngoặc nhọn bằng dấu ngoặc góc
                .replace("}", "</"); // Thay dấu ngoặc nhọn bằng dấu ngoặc góc đóng
    }

    // Logic chuyển đổi XML sang JSON (Mô phỏng bằng String reresentation)
    private String xmlToJson(String xml) {
        // Giả sử chuyển đổi:
        // "<user><name>Toan</name><role>Admin</role></user>" -> {"user":{"name":"Toan","role":"Admin"}}
        // Trong thực tế sẽ dùng thư viện như Jackson/Gson
        return xml.replace(">", ":") // Thay dấu ngoặc góc bằng dấu hai chấm
                .replace("<", "\"") // Thay dấu ngoặc góc bằng dấu ngoặc kép
                .replace(":", "\":\"") // Thay dấu hai chấm bằng dấu ngoặc kép + dấu hai chấm
                .replace("</", "\",\""); // Thay dấu ngoặc góc đóng bằng dấu ngoặc kép + dấu phẩy
    }
}
