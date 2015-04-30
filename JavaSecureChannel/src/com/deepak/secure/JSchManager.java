package com.deepak.secure;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.UIKeyboardInteractive;
import com.jcraft.jsch.UserInfo;

public class JSchManager {
	
	public void installTomcat(String ipAddress, String osName) {

		if ((osName.contains("Amazon")) || (osName.contains("Red Hat"))) {
			executeCommand(ipAddress, "sudo yum -y install java-1.7.0-openjdk*");
			executeCommand(ipAddress, "sudo yum -y install tomcat");			
		}
		else if ((osName.contains("Ubuntu"))) {
			executeCommand(ipAddress, "sudo apt-get update");
			executeCommand(ipAddress, "sudo apt-get -y install openjdk-7-jdk");
			executeCommand(ipAddress, "sudo apt-get -y install tomcat7");
		}

	}

	public void installAndroid(String ipAddress, String osName) {
		if ((osName.contains("Amazon")) || (osName.contains("Red Hat"))) {
			executeCommand(ipAddress, "sudo yum -y install java-1.7.0-openjdk*");
			executeCommand(ipAddress, "sudo yum -y install wget");
			executeCommand(ipAddress, "wget http://dl.google.com/android/android-sdk_r24.1.2-linux.tgz");
			executeCommand(ipAddress, "tar -xvf android-sdk_r24.1.2-linux.tgz");
		}
		else if ((osName.contains("Ubuntu"))) {
			executeCommand(ipAddress, "sudo apt-get update");
			executeCommand(ipAddress, "sudo apt-get -y install openjdk-7-jdk");
			executeCommand(ipAddress, "wget http://dl.google.com/android/android-sdk_r24.1.2-linux.tgz");
			executeCommand(ipAddress, "tar -xvf android-sdk_r24.1.2-linux.tgz");
		}

	}

	public void installSoftwares(String ipAddress) {
		
		executeCommand(ipAddress, "sudo apt-get update");
		executeCommand(ipAddress, "sudo apt-get -y install openjdk-7-jdk");
		executeCommand(ipAddress, "sudo apt-get -y install tomcat7");
		executeCommand(ipAddress, "wget http://dl.google.com/android/android-sdk_r24.1.2-linux.tgz");
		executeCommand(ipAddress, "tar -xvf android-sdk_r24.1.2-linux.tgz");


		
	}
	
	private void executeCommand(String ipAddress, String command) {
		try {
			JSch jsch=new JSch();
			jsch.addIdentity("/Users/davanna/code/jsch/281test.pem");
			
	
			//enter your own EC2 instance IP here
			Session session=jsch.getSession("ubuntu", ipAddress, 22);
	          java.util.Properties config = new java.util.Properties();
	          config.put("StrictHostKeyChecking", "no");
	          session.setConfig(config);
	          
		      UserInfo ui=new MyUserInfo();
		      session.setUserInfo(ui);


			session.connect();
	
			//run stuff
//			String command = "wget http://dl.google.com/android/android-sdk_r24.1.2-linux.tgz; tar -xvf android-sdk_r24.1.2-linux.tgz";
//			String command = "sudo apt-get -y install openjdk-7-jdk";
			Channel channel = session.openChannel("exec");
			((ChannelExec)channel).setCommand(command);
			((ChannelExec)channel).setErrStream(System.err);
			channel.connect();
	
			InputStream input = channel.getInputStream();
			//start reading the input from the executed commands on the shell
			byte[] tmp = new byte[1024];
			while (true) {
			    while (input.available() > 0) {
			        int i = input.read(tmp, 0, 1024);
			        if (i < 0) break;
			        System.out.print(new String(tmp, 0, i));
			    }
			    if (channel.isClosed()){
			        System.out.println("exit-status: " + channel.getExitStatus());
			        break;
			    }
			    Thread.sleep(1000);
			}
	
			channel.disconnect();
			session.disconnect();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String [] args) {
		JSchManager manager = new JSchManager();
		
		manager.executeCommand("127.0.0.1","ls -l");
	}
	
    public static class MyUserInfo implements UserInfo, UIKeyboardInteractive {

        @Override
        public String getPassphrase() {
            return null;
        }
        @Override
        public String getPassword() {
            return null;
        }
        @Override
        public boolean promptPassphrase(String arg0) {
            return false;
        }
        @Override
        public boolean promptPassword(String arg0) {
            return false;
        }
        @Override
        public boolean promptYesNo(String arg0) {
            return false;
        }
        @Override
        public void showMessage(String arg0) {
        }
        @Override
        public String[] promptKeyboardInteractive(String arg0, String arg1,
                String arg2, String[] arg3, boolean[] arg4) {
            return null;
        }
    }	

}
