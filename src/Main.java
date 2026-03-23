import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // tạo database (hospital)
        // tạo bảng doctor (id, name, specialization)

        // Yêu cầu nhập vào thông tin để thêm mới d liệu vào database
        // Bước 1 : Mở kết nối
        try (Connection con = DatabaseConnection.openConnection()) {
            // Bước 2 : Viết các câu lệnh sql
            String sql = "INSERT INTO doctors VALUES (?, ?, ?, ?, ?)";
            // Bước 3 : Khởi tạo đối tượng PreparedStatement
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            for (int i = 1; i <= 5; i++) {
                //Bước 4 : Set parameter (tham số) vào
                System.out.println("Nhập mã bác sĩ: ");
                preparedStatement.setString(1, sc.nextLine());
                System.out.println("Nhập tên bác sĩ: ");
                preparedStatement.setString(2, sc.nextLine());
                System.out.println("NHập giới tính bác sĩ: ");
                preparedStatement.setString(3, sc.nextLine());
                System.out.println("Nhập tuổi bác sĩ: ");
                preparedStatement.setInt(4, Integer.parseInt(sc.nextLine()));
                System.out.println("Nhập chuyên khoa bác sĩ: ");
                preparedStatement.setString(5, sc.nextLine());

                // Bước 5 : Thực thi câu lệnh sql
                int row = preparedStatement.executeUpdate();

                System.out.println(row);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}