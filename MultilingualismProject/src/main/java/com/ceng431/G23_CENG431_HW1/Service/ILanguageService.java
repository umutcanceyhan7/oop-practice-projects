package main.java.com.ceng431.G23_CENG431_HW1.Service;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Language;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LANGUAGES;

public interface ILanguageService {
    Language createLanguage(LANGUAGES name);
}
