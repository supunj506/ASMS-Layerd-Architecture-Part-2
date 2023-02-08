package lk.ijse.asms.bo.util;

import lk.ijse.asms.bo.SuperBO;
import lk.ijse.asms.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory(){
        return boFactory==null?boFactory=new BOFactory():boFactory;
    }

    public enum BOTypes{
        ADDJOB,CALLJOB,CUSTOMER,EMPLOYEE,FINISHJOB,JOBREPORT,PAYMENTPLANE,PAYMENTREPORT,VEHICLE
    }

    public <T extends SuperBO >T getBO(BOTypes types){
        switch (types){
            case ADDJOB:
                return (T)new AddJobBOImpl();
            case CALLJOB:
                return (T) new CallJobBOImpl();
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case EMPLOYEE:
                return (T) new EmployeeBOImpl();
            case FINISHJOB:
                return (T) new FinishJobBOImpl();
            case JOBREPORT:
                return (T) new JobReportBOImpl();
            case PAYMENTPLANE:
                return (T) new PaymentPlaneBOImpl();
            case PAYMENTREPORT:
                return (T) new PaymentReportBOImpl();
            case VEHICLE:
                return (T) new VehicleBOImpl();
            default:
                return null;
        }
    }
}
