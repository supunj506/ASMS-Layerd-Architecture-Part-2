package lk.ijse.asms.bo.util;

import lk.ijse.asms.bo.SuperBO;
import lk.ijse.asms.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory(){
        if(boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }
    public enum BOTypes{
        ADDJOB,CALLJOB,CUSTOMER,EMPLOYEE,FINISHJOB,JOBREPORT,PAYMENTPLANE,PAYMENTREPORT,VEHICLE
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case ADDJOB:
                return new AddJobBOImpl();
            case CALLJOB:
                return new CallJobBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case FINISHJOB:
                return new FinishJobBOImpl();
            case JOBREPORT:
                return new JobReportBOImpl();
            case PAYMENTPLANE:
                return new PaymentPlaneBOImpl();
            case PAYMENTREPORT:
                return new PaymentReportBOImpl();
            case VEHICLE:
                return new VehicleBOImpl();
            default:
                return null;
        }
    }
}
