package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import resources.base;

public class logging {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	public static void main(String args[]) {
		
		log.debug("i am debugging");
		log.info("pushkar");
		log.error("iit bhu");
		log.fatal(" m tech");
	}
	

}
