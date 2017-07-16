package com.acadgild.Entity;

public class SeatAllotment {

	private int empId;
	private int buildingId;
	private int seatNo;
	private int floorNo;
	private String seatStatus ;
	private String requestedByUser;
	private String AdminStatusUpdate;
	private Boolean waitingForAdminApproval;

	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public int getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public String getRequestedByUser() {
		return requestedByUser;
	}

	public void setRequestedByUser(String requestedByUser) {
		this.requestedByUser = requestedByUser;
	}

	public String getAdminStatusUpdate() {
		return AdminStatusUpdate;
	}

	public void setAdminStatusUpdate(String adminStatusUpdate) {
		AdminStatusUpdate = adminStatusUpdate;
	}

	public Boolean getWaitingForAdminApproval() {
		return waitingForAdminApproval;
	}

	public void setWaitingForAdminApproval(Boolean waitingForAdminApproval) {
		this.waitingForAdminApproval = waitingForAdminApproval;
	}
	
	
	
}
