package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductInfoDAO {
	private static ProductInfoDAO productInfoDAO = new ProductInfoDAO();
	private ProductInfoDAO() {};
	public static ProductInfoDAO getInstance() {
		return productInfoDAO;
	}
	public List<ProductInfoDO> getList() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/XE";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<ProductInfoDO> list = new ArrayList<>();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"c##test","1234");
			pstm = conn.prepareStatement("select * from productInfo");
			rs = pstm.executeQuery();
			if(rs.next()) {
				do {
					ProductInfoDO data = new ProductInfoDO();
					data.setNo(rs.getInt("no"));
					data.setName(rs.getString("name"));
					data.setPrice(rs.getInt("price"));
					data.setDetail(rs.getString("detail"));
					list.add(data);
				}while(rs.next());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				e2.getStackTrace();
			}
		}
		return list;
	}
	/*public void insert(ProductInfoDTO data) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:5500:em";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"c##testuser","1234");
			pstm = conn.prepareStatement("insert into productInfo value(?,?,?,?)");
			pstm.setInt(0, data.getNo());
			pstm.setString(1, data.getName());
			pstm.setInt(2, data.getPrice());
			pstm.setString(4, data.getDetail());
			pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(conn!=null) conn.close();
			}catch(Exception e2) {
				e2.getStackTrace();
			}
		}
	}*/
}
