package com.wq.spring.context.demo.tags;

/**
 * @Author: wangqiang20995
 * @Date:2018/11/30
 * @Description:
 * @Resource:
 */
public class ExtandService {

	private String keybord;
	private String monitor;
	private String mouse;

	@Override
	public String toString() {
		return "ExtandService{" +
				"keybord='" + keybord + '\'' +
				", monitor='" + monitor + '\'' +
				", mouse='" + mouse + '\'' +
				'}';
	}

	public String getKeybord() {
		return keybord;
	}

	public void setKeybord(String keybord) {
		this.keybord = keybord;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}
}
