package linerasearch;

public class SentanceCheck {


    public static String checkSentance(String[] sentence, String value) {
        int n=value.length();
        for (int i = 0; i < sentence.length; i++) {
            for (int j = 0; j < sentence[i].length(); j++) {
                if(sentence[i].substring(j,j+n).equals(value)) {
                    return sentence[i];
                }
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] Arr ={"bhavya is bad boy","my name is vivek", "He is not answering"};
        System.out.println(checkSentance(Arr,"bhavya"));
    }
}
