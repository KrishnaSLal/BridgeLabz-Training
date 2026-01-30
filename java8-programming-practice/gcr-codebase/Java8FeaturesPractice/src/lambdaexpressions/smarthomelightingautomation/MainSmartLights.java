package lambdaexpressions.smarthomelightingautomation;

//Smart Home Lighting Automation
//○ Scenario: A building has smart lights. Different triggers (motion, time of day, voice
//commands) need to execute different light patterns.
//○ Task: Use lambdas to define these light activation behaviors dynamically without
//creating multiple classes.

public class MainSmartLights {
   public static void main(String[] args) {
	   
	   SmartLights motionTrigger = () -> System.out.println("Motion trigger detected, turning on hallway lights");
	   
	   SmartLights timeTrigger = () -> System.out.println("Morning time detected, turning off exterior lights");
	   
	   SmartLights voiceTrigger = () -> System.out.println("Voice trigger detected, turning on living room lights");
	   
	   motionTrigger.behavior();
	   timeTrigger.behavior();
	   voiceTrigger.behavior();
			   
   }
}
