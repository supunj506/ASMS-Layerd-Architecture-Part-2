package lk.ijse.asms.dao.util;

import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.entity.CustomEntity;
import lk.ijse.asms.entity.SuperEntity;

public interface CrudDAO <T extends SuperEntity,ID extends String>  extends SuperDAO {

}
