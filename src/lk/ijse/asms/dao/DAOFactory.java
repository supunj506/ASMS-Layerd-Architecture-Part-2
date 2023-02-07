package lk.ijse.asms.dao;

import lk.ijse.asms.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    public static DAOFactory getDaoFactory(){
        if(daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    /* public static final Integer values */
    public enum DAOTypes{
        CUSTOMER,DIVISION,EMPLOYEE,EMPTEAM,JOB,PAYMENTPLANE,QUERY,SUBCPAYMENT,TEAM,USER,VEHICLE
    }
    /* Method for hiding the object creation logic */
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case DIVISION:
                return new DivisionDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case EMPTEAM:
                return new EmpTeamDAOImpl();
            case JOB:
                return new JobDAOImpl();
            case PAYMENTPLANE:
                return new PaymentPlaneDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            case SUBCPAYMENT:
                return new SubcPaymentDAOImpl();
            case TEAM:
                return new TeamDAOImpl();
            case USER:
                return new UserDAOImpl();
            case VEHICLE:
                return new VehicleDAOImpl();
            default:
                return null;
        }
    }


}
