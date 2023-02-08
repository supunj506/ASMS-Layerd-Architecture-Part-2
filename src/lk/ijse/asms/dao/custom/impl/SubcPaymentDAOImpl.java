package lk.ijse.asms.dao.custom.impl;
import lk.ijse.asms.dao.custom.SubcPaymentDAO;
import lk.ijse.asms.dto.SubPaymentDTO;
import lk.ijse.asms.dao.SQLUtil;
import lk.ijse.asms.entity.SubPayment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SubcPaymentDAOImpl implements SubcPaymentDAO {
    @Override
    public boolean saveSubCPayment(SubPayment subPaymentEntity) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("insert into subc_payment (id,emp_id,job_id,data_point,power_point,camera_point,total_amount,pay_status) values (?,?,?,?,?,?,?,?)",
               subPaymentEntity.getId(),
               subPaymentEntity.getEmp_id(),
               subPaymentEntity.getJob_id(),
               subPaymentEntity.getData_point(),
               subPaymentEntity.getPower_point(),
               subPaymentEntity.getCamera_point(),
               subPaymentEntity.getTotal_amount(),
               subPaymentEntity.getPay_status());

    }
    @Override
        public String getNextId () throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT id FROM subc_payment ORDER BY id DESC LIMIT 1");
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
        ResultSet rst=SQLUtil.execute("select * from subc_payment where id=?",id);
        if(rst.next()){
            return new SubPayment(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getInt(4),
                    rst.getInt(5),
                    rst.getInt(6),
                    rst.getDouble(7),
                    LocalDate.parse(rst.getString(8)),
                    rst.getString(9));
        }
        return null;
    }

}
