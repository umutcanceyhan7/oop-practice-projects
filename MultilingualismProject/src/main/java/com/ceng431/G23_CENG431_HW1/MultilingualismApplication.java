package main.java.com.ceng431.G23_CENG431_HW1;

import main.java.com.ceng431.G23_CENG431_HW1.Helper.Simulation;

import java.util.Random;

public class MultilingualismApplication {
	private static final Random random = new Random();
	public enum LANGUAGES {
		Turkish, German, Italian, Spanish;
		public static LANGUAGES chooseRandomLanguage(){
			// Each time it creates deep copy of LANGUAGES values (not shallow copy)
			LANGUAGES[] languages = values();
			// Return chosen language randomly
			return languages[random.nextInt(languages.length)];
		}
		public static boolean isLanguageExist(String newLanguage){
			LANGUAGES[] languages = values();
			boolean isExist = false;
			for(LANGUAGES language : languages){
				if(language.name().equals(newLanguage)){
					isExist = true;
					return isExist;
				}
			}
			return isExist;
		}
	};
	public enum QUESTION_TYPE {
		Reading, Listening, Speaking, WordMatching;
		public static QUESTION_TYPE chooseRandomQuestionType(){
			// Each time it creates deep copy of LANGUAGES values (not shallow copy)
			QUESTION_TYPE[] questionTypes = values();
			// Return chosen language randomly
			return questionTypes[random.nextInt(questionTypes.length)];
		}

		public static boolean isQuestionTypeExist(String newQuestionType){
			QUESTION_TYPE[] questionTypes = values();
			boolean isExist = false;
			for(QUESTION_TYPE questionType : questionTypes){
				if(questionType.name().equals(newQuestionType)){
					isExist = true;
					return isExist;
				}
			}
			return isExist;
		}
	};
	public enum LEAGUES {
		Bronze,  Silver, Gold, Sapphire, Ruby;
		public static LEAGUES chooseRandomLeagues(){
			// Each time it creates deep copy of LEAGUES values (not shallow copy)
			LEAGUES[] leagues = values();
			// Return chosen LEAGUE randomly
			return leagues[random.nextInt(leagues.length)];
		}
	};
	public static void main(String[] args) throws Exception {
		Simulation simulation = new Simulation();
		simulation.run();
	}
}
