package pl.coderslab.team2.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    int orderId;
    String acceptanceData;
    String beginRepairingData;
    String destinedWorker;
    String issueInfo;
    String repairInfo;
    String Status;
    String vechicle;
    BigDecimal costForClient;
    BigDecimal partsCost;
    double workHoursCost;
    double workHoursAmount;

    public Orders(){}

    public Orders(int orderId, String acceptanceData, String beginRepairingData, String destinedWorker, String issueInfo, String repairInfo, String Status, String vechicle, BigDecimal costForClient, BigDecimal partsCost, double workHoursCost, double workHoursAmount) {
        //this.orderId = orderId;
        this.acceptanceData = acceptanceData;
        this.beginRepairingData = beginRepairingData;
        this.destinedWorker = destinedWorker;
        this.issueInfo = issueInfo;
        this.repairInfo = repairInfo;
        this.Status = Status;
        this.vechicle = vechicle;
        this.costForClient = costForClient;
        this.partsCost = partsCost;
        this.workHoursCost = workHoursCost;
        this.workHoursAmount = workHoursAmount;
    }
    public int getOrderId(){
        return orderId;
    }
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public Object getAcceptanceData() {
        return acceptanceData;
    }

    public void setAcceptanceData(String acceptanceData) {
        this.acceptanceData = acceptanceData;
    }

    public Object getBeginRepairingData() {
        return beginRepairingData;
    }

    public void setBeginRepairingData(String beginRepairingData) {
        this.beginRepairingData = beginRepairingData;
    }

    public String getDestinedWorker() {
        return destinedWorker;
    }

    public void setDestinedWorker(String destinedWorker) {
        this.destinedWorker = destinedWorker;
    }

    public String getIssueInfo() {
        return issueInfo;
    }

    public void setIssueInfo(String issueInfo) {
        this.issueInfo = issueInfo;
    }

    public String getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(String repairInfo) {
        this.repairInfo = repairInfo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getVechicle() {
        return vechicle;
    }

    public void setVechicle(String vechicle) {
        this.vechicle = vechicle;
    }

    public BigDecimal getCostForClient() {
        return costForClient;
    }

    public void setCostForClient(BigDecimal costForClient) {
        this.costForClient = costForClient;
    }

    public BigDecimal getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(BigDecimal partsCost) {
        this.partsCost = partsCost;
    }

    public double getWorkHoursCost() {
        return workHoursCost;
    }

    public void setWorkHoursCost(double workHoursCost) {
        this.workHoursCost = workHoursCost;
    }

    public double getWorkHoursAmount() {
        return workHoursAmount;
    }

    public void setWorkHoursAmount(double workHoursAmount) {
        this.workHoursAmount = workHoursAmount;
    }

}