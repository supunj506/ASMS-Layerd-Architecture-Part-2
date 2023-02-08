package lk.ijse.asms.dao.custom.impl;
import lk.ijse.asms.dao.custom.SubPaymentDAO;
import lk.ijse.asms.dao.util.SQLUtil;
import lk.ijse.asms.entity.SubPayment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SubPaymentDAOImpl implements SubPaymentDAO {
    @Override
    public boolean saveSubCPayment(SubPayment subPaymentEntity) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("insert into SubPayment (sub_payment_id ,employee_id ,job_id,job_power_point_count ,job_data_point_count ,job_camera_point_count ,sub_payment_total_amount ,sub_payment_pay_status ) values (?,?,?,?,?,?,?,?)",
               subPaymentEntity.getSub_payment_id(),
               subPaymentEntity.getEmployee_id(),
               subPaymentEntity.getJob_id(),
               subPaymentEntity.getJob_power_point_count(),
               subPaymentEntity.getJob_data_point_count(),
               subPaymentEntity.getJob_camera_point_count(),
               subPaymentEntity.getSub_payment_total_amount(),
               subPaymentEntity.getSub_payment_pay_status());

    }
    @Override
        public String getNextId () throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT sub_payment_id  FROM SubPayment ORDER BY sub_payment_id  DESC LIMIT 1");
            if (rst.next()) {
                String payId=(rst.getString(1));
                String []ids= payId.split("Sub");
                int id=Integer.parseInt(ids[1]);
                id+=1;
                if(id>9){
                    return "Sub"+id;
                }
                return "Sub0"+id;

            }
            return "Sub01";
        }

    @Override
    public SubPayment getSubPaymentById(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst=SQLUtil.execute("select * from SubPayment where sub_payment_id =?",id);
        if(rst.next()){
            return new SubPayment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getDouble(7),
                    LocalDate.now(),
                    rst.getString(9));
        }
        return null;
    }

}
