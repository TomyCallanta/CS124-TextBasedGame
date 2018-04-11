package intercept;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.Callable;

import anno.Command;
import room.*;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.Super;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

public class RoomInterceptor {
	private HashMap<Class, Object> roomMap;
	
	public RoomInterceptor(HashMap<Class, Object> rm) {
		roomMap = rm;
	}
	
	@Command(command = "talk")
	public String talk(@SuperCall Callable<?> zuper) {
		
		try {
			SecretHideout reqRoom = (SecretHideout) this.roomMap.get(SecretHideout.class);
			boolean requirement = reqRoom.hasInquired();
			if(requirement) 
				return (String) zuper.call();
			else
				return  "Lightning: Hello! Mater how are you? \n"
				+ "Mater: I am doing well, I just wanted to drop by to say hi to you and Sally. \n"
				+ "Lightning: That is very nice of you. Do you want to join us for dinner later? \n"
				+ "Mater: Sure! I will be back after I finish my duties. \n"
				+ "Lightning: I will see you! \n ";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error\n";
		}
	}
	
	@Command(command = "say")
	public String say(@SuperCall Callable<?> zuper, @AllArguments Object[] args) {
		try {
			CozyConeMotel reqRoom = (CozyConeMotel) this.roomMap.get(CozyConeMotel.class);
			boolean requirement = reqRoom.gotPassword();
			if(requirement) {
				return (String) zuper.call();
			}else {
				SecretHideout thisRoom = (SecretHideout) this.roomMap.get(SecretHideout.class);
				thisRoom.inquire();
				return " You don't know what the password could possibily be. Maybe I should go to Lightning McQueen \n";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error\n";
		}
	}
}
