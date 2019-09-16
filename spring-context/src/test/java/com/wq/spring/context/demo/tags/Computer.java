package com.wq.spring.context.demo.tags;

/**
 * @Author: wangqiang20995
 * @Date:2018/11/30
 * @Description:
 * @Resource:
 */
public class Computer {

	private ComputerCore computerCore;

	private ExtandService extandService;

	@Override
	public String toString() {
		return "Computer{" +
				"computerCore=" + computerCore +
				", extandService=" + extandService +
				'}';
	}

	public ComputerCore getComputerCore() {
		return computerCore;
	}

	public void setComputerCore(ComputerCore computerCore) {
		this.computerCore = computerCore;
	}

	public ExtandService getExtandService() {
		return extandService;
	}

	public void setExtandService(ExtandService extandService) {
		this.extandService = extandService;
	}
}
