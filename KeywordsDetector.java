public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {

        for (int i = 0; i < sentences.length; i++){
            String currentSentcne = sentences[i];
            currentSentcne = lowerCase(currentSentcne);

            // check if one of the keywords appear int the sentence
            for ( int j = 0; j < keywords.length; j++){
                if (contains(currentSentcne, lowerCase(keywords[j]))){
                    // prints without lowerCase method
                    System.out.println(sentences[i]);
                    j = keywords.length;
                }
            }
        }
        
    }




    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++){
            
            int ch = (int) str.charAt(i);

            // if upper case
            if (ch >= 65 && ch <= 90) ch = ch + 32;

            newStr += (char) ch;
        }

        return newStr;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        
        for (int i = 0; i <= str1.length() - str2.length(); i++){
            boolean contain = true;
            int index = i;

            for (int j = 0; j < str2.length(); j++){
                if (str1.charAt(index) != str2.charAt(j)) contain = false;
                else index += 1;
            }

            if (contain) return true;
        }

        return false;
    }
}
