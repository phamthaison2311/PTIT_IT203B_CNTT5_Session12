package B1_SS12_JAVA_ADVANCED;

import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class B1_SS12 {
    public static void main(String[] args) {
        /**
         * Phần 1 - Phân tích:
         * PreparedStatement hoạt động như một khuôn mẫu (template).
         * Cơ chế "Pre-compiled" giúp Database hiểu rõ cấu trúc câu lệnh ngay từ đầu.
         * Khi dữ liệu được truyền vào thông qua các dấu (?), Database chỉ coi đó
         * là các giá trị literal (chuỗi thuần túy), không bao giờ thực thi chúng như mã lệnh.
         */

        // Phần 2 - Thực thi:
        String doctorCode = "D001";
        String password = "' OR '1' = '1";
        try (Connection con = DatabaseConnection.openConnection()) {
            String sql = "SELECT * FROM doctor WHERE code = ? AND pass = ?";

            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, "D001");
                pstmt.setString(2, password);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        System.out.println("Đăng nhập thành công! ID: " + rs.getString("code"));
                    } else {
                        System.out.println("Đăng nhập thất bại: Thông tin không chính xác.");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Lỗi kết nối cơ sở dữ liệu!");
            e.printStackTrace();
        }
    }
}