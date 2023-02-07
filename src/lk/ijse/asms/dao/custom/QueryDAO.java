package lk.ijse.asms.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dto.CustomDTO;
import lk.ijse.asms.view.tm.TeamTM;
import java.sql.SQLException;
import java.util.ArrayList;

public interface QueryDAO extends SuperDAO{
    ObservableList<CustomDTO> getEmployeeDetails(String contract_base) throws SQLException, ClassNotFoundException;
    CustomDTO getDetailForSubcPayment(String id) throws SQLException, ClassNotFoundException;
    ArrayList<String> getContractBaseFinishJob() throws SQLException, ClassNotFoundException;
    ObservableList<String> getFinishJob(String status) throws SQLException, ClassNotFoundException;
    ArrayList<String> getJobDetails(String status) throws SQLException, ClassNotFoundException;

}
