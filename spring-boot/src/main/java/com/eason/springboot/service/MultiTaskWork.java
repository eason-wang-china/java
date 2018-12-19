package com.eason.springboot.service;

public class MultiTaskWork {

	private int hasDone = 0;
	private int needDo = 0;
	private long startTime;
	private long endTime;

	public MultiTaskWork() {

		this.startTime = System.currentTimeMillis();
	}

	public void addHasDone(int i) {
		hasDone += i;
		endTime = System.currentTimeMillis();
	}
	
	public boolean isDone() {
		if (hasDone >= needDo)
			return true;
		else
			return false;
	}
	
	public int getHasDone() {
		return hasDone;
	}

	public void setHasDone(int hasDone) {
		this.hasDone = hasDone;
	}

	public int getNeedDo() {
		return needDo;
	}

	public void setNeedDo(int needDo) {
		this.needDo = needDo;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

}
