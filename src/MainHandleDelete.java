import util.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainHandleDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Thao tác xóa bác sĩ
        // B1: NHập id của bác sĩ muốn xóa
        System.out.println("Nhập id của bác sĩ muốn xóa: ");
        String idDelete = sc.nextLine();
        // B2: Mở kết nối
        try(Connection connection = DatabaseConnection.openConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call delete_doctor_by_id}");
            callableStatement.setString(1, idDelete);
            int row = callableStatement.executeUpdate();
            System.out.println(row);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        // B3: Gọi thủ tục
        // B4: Sử dụng đối tượng CallableStatement để gọi
        // B5: Thực thi câu lệnh executeUpdate();
    }
}