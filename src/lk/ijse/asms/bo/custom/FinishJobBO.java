package lk.ijse.asms.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.asms.dto.SubPaymentDTO;

import java.sql.SQLException;

public interface FinishJobBO {
    ObservableList<String> getFinishJob(String jobStatus) throws SQLException, ClassNotFoundException;
    boolean finishJob(String jobId, SubPaymentDTO subPaymentDTO) throws SQLException, ClassNotFoundException;
}
