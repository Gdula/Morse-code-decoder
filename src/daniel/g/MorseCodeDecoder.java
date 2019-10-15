package daniel.g;


import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {
    private Map<String, String> morseMap;

    public MorseCodeDecoder(Map<String, String> morseMap) {
        this.morseMap = morseMap;
    }

    public Map<String, String> getMorseMap() {
        return morseMap;
    }

    public void setMorseMap(Map<String, String> morseMap) {
        morseMap.put(".-", "a");
        morseMap.put("-...", "b");
        morseMap.put("-.-.", "c");
        morseMap.put("-..", "d");
        morseMap.put(".", "e");
        morseMap.put("..-.", "f");
        morseMap.put("--.", "g");
        morseMap.put("....", "h");
        morseMap.put("..", "i");
        morseMap.put(".---", "j");
        morseMap.put("-.-", "k");
        morseMap.put(".-..", "l");
        morseMap.put("--", "m");
        morseMap.put("-.", "n");
        morseMap.put("---", "o");
        morseMap.put(".--.", "p");
        morseMap.put("--.-", "q");
        morseMap.put(".-.", "r");
        morseMap.put("...", "s");
        morseMap.put("-", "t");
        morseMap.put("..-", "u");
        morseMap.put("...-", "v");
        morseMap.put(".--", "w");
        morseMap.put("-..-", "x");
        morseMap.put("-.--", "y");
        morseMap.put("--..", "z");
        morseMap.put("-.-.--", "!");
        morseMap.put(".-.-.-", ".");
        morseMap.put("...---...", "SOS");
        this.morseMap = morseMap;
    }

    public String decode(String messageToDecode) {
        for (int i = 0; i < messageToDecode.length(); i++) {
            if (messageToDecode.charAt(i) != '-' && messageToDecode.charAt(i) != '.' && messageToDecode.charAt(i) != ' ') {
                messageToDecode = messageToDecode.replace(messageToDecode.charAt(i), ' ');
            }
        }
        
        messageToDecode = messageToDecode.trim();
        messageToDecode += "  ";

        StringBuilder decodedMessage = new StringBuilder();
        StringBuilder morseWord = new StringBuilder();

        for (int i = 0; i < messageToDecode.length(); i++) {

            if (messageToDecode.charAt(i) != ' ') {
                morseWord.append(messageToDecode.charAt(i));
            }

            if (messageToDecode.charAt(i) == ' ') {
                decodedMessage.append(morseMap.get(morseWord.toString()));
                morseWord = new StringBuilder();
            }

            if (messageToDecode.charAt(i) == ' ' && messageToDecode.charAt(i+1) == ' ' ) {
                decodedMessage.append(' ');
                i += 2;
            }
        }
        return decodedMessage.toString().toUpperCase().trim();
    }

    public static void main(String[] args) {
        Map<String, String> morseMap = new HashMap<>();
        MorseCodeDecoder morseCodeDecoder = new MorseCodeDecoder(morseMap);
        morseCodeDecoder.setMorseMap(morseMap);

        System.out.println(morseCodeDecoder.decode("       9     ...---...      "));
    }
}
