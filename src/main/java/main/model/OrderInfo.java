package main.model;


import java.time.LocalDate;

public interface OrderInfo {
     Long getOrd();
     LocalDate getDt();
     String getFullName();
     String getStatusDescription();
     String getOriginDescription();
}
