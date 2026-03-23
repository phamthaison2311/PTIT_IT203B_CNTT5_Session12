package B2_SS12_JAVA_ADVANCED;

import util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class B2_SS12 {
    public static void main(String[] args) {
        // Giả lập dữ liệu nhập vào từ Y tá
        String patientId = "P001";
        double tempInput = 37.5; // Dù hệ thống dùng dấu phẩy hay chấm, biến double vẫn là 37.5
        int heartRateInput = 85;

        // Câu lệnh SQL với Placeholder (?)
        String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";

        try (Connection con = DatabaseConnection.openConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            // Sử dụng các phương thức set tương ứng với kiểu dữ liệu
            // Không cần lo lắng về định dạng dấu chấm/phẩy tại đây
            pstmt.setDouble(1, tempInput);
            pstmt.setInt(2, heartRateInput);
            pstmt.setString(3, patientId);

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Cập nhật chỉ số sinh tồn thành công cho bệnh nhân: " + patientId);
                System.out.println("Nhiệt độ: " + tempInput + "°C");
                System.out.println("Nhịp tim: " + heartRateInput + " bpm");
            } else {
                System.out.println(" Không tìm thấy bệnh nhân có ID: " + patientId);
            }

        } catch (SQLException e) {
            System.err.println("Lỗi cập nhật Database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
