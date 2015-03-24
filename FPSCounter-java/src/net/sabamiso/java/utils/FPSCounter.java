//
//	FPSCounter.java - simple performance check class for fps (frame per second).
//
// github:
//     https://github.com/yoggy/FPSCounter
//
// license:
//     Copyright (c) 2015 yoggy <yoggy0@gmail.com>
//     Released under the MIT license
//     http://opensource.org/licenses/mit-license.php
//
package net.sabamiso.java.utils;

public class FPSCounter {
	String name;
	int check_count;
	boolean debug_output;

	long st;
	int count;
	float t;
	float fps;

	public FPSCounter() {
		this.name = "FPSCounter";
		this.check_count = 100;
		this.debug_output = false;

		clear();
	}

	public FPSCounter(String name) {
		this.name = name;
		this.check_count = 100;
		this.debug_output = false;

		clear();
	}

	public FPSCounter(String name, int check_count) {
		this.name = name;
		this.check_count = check_count;
		this.debug_output = false;

		clear();
	}

	public FPSCounter(String name, int check_count, boolean debug_output) {
		this.name = name;
		this.check_count = check_count;
		this.debug_output = debug_output;

		clear();
	}

	public void clear() {
		st = getTickCount();
		count = 0;
		t = 0.0f;
		fps = 0.0f;
	}

	public String getName() {
		return name;
	}

	public void setName(String val) {
		name = val;
	}

	public int getCheckCount() {
		return check_count;
	}

	public void setCheckCount(int val) {
		if (val <= 0) {
			System.out
					.println("ERROR : FPSCounter.setCheckCount(int val) : invalid val...val="
							+ val);
			return;
		}
		check_count = val;
		clear();
	}

	public boolean getDebugOutput() {
		return debug_output;
	}

	public void setDebugOutput(boolean flag) {
		debug_output = flag;
	}

	public float getT() {
		return t;
	}

	public float fps() {
		return fps;
	}

	public void check() {
		count++;
		if (count == check_count) {
			long et = getTickCount();
			long diff_tick = et - st;

			float diff_sec = diff_tick / 1000.0f;

			t = diff_sec / (float) check_count;
			fps = 1.0f / t;

			st = et;
			count = 0;

			if (debug_output) {
				outputDebugString();
			}
		}
	}

	public void outputDebugString() {
		System.out.println(toString());
	}

	public String toString() {
		String str = "" + name + " : t=" + t + ", fps=" + fps;
		return str;
	}

	protected long getTickCount() {
		return System.currentTimeMillis();
	}
	
	//
	// How to use...
	//
	public static void main(String [] args) {
		FPSCounter fps = new FPSCounter();
		fps.setDebugOutput(true);
		
		while(true) {
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
			}
			
			fps.check();
		}
	}
}
