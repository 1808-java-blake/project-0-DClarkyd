package com.revature.project0.Project_0_DClarkyD;

//import com.revature.screens.LoginScreen;
import com.revature.screens.Screen;

public class ClassLauncher {
	public static void main(String[] args) {
		Screen s = new LoginScreen();
		while (true) {
			s = s.start();
		}
	}
}
