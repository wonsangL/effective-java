package item01.flyweight.after;

import java.util.HashMap;
import java.util.Map;

/**
 * 해당 객체는 백기선님의 <a href="https://www.inflearn.com/course/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/dashboard">코딩으로 학습하는 GoF의 디자인 패턴</a>
 * 강의를 참고하여 작성된 코드입니다.
 */
public class FontFactory {
    private static Map<String, Font> fontCache = new HashMap<>();

    public static Font getFont(String font) {
        if (fontCache.containsKey(font)) {
            return fontCache.get(font);
        }

        String[] split = font.split(":");
        Font newFont = new Font(split[0], Integer.getInteger(split[1]));
        fontCache.put(font, newFont);
        return newFont;
    }
}
