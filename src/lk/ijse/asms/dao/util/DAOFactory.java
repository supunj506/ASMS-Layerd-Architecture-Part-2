package lk.ijse.asms.dao.util;

import lk.ijse.asms.dao.SuperDAO;
import lk.ijse.asms.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        return daoFactory==null?daoFactory=new DAOFactory():daoFactory;
    }
    /* public static final Integer values */
    public enum DAOTypes{
        CUSTOMER,DIVISION,EMPLOYEE,EMPTEAM,JOB,PAYMENTPLANE,QUERY,SUBCPAYMENT,TEAM,USER,VEHICLE
    }
    /* Method for hiding the object creation logic */
    public <T extends SuperDAO > T getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case DIVISION:
                return (T) new DivisionDAOImpl();
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case EMPTEAM:
                return (T) new EmployeeTeamDAOImpl();
            case JOB:
                return (T) new JobDAOImpl();
            case PAYMENTPLANE:
                return (T) new PaymentPlaneDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case SUBCPAYMENT:
                return (T) new SubPaymentDAOImpl();
            case TEAM:
                return (T) new TeamDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            case VEHICLE:
                return (T) new VehicleDAOImpl();
            default:
                return null;
        }
    }


}
