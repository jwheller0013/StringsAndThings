package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        String inputL = input.toLowerCase();
        int counter = 0;

        for(int i = 0; i < input.length(); ++i) {
            char idx = inputL.charAt(i);
            if (idx == ' ') {
                int j = i - 1;
                char idxminus = inputL.charAt(j);
                if (idxminus == 'y') {
                    ++counter;
                }

                if (idxminus == 'z') {
                    ++counter;
                }
            }
        }

            int z = input.length() - 1;
            char idxend = input.charAt(z);
            if (idxend == 'y') {
                ++counter;
            }

            if (idxend == 'z') {
                ++counter;
            }

            return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return base.replaceAll(remove, "");
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int counter = 0;

        int c = input.split("is").length -1;
        int d = input.split("not").length -1;
        //increase counter if string as instances of "is"
        //decrease counter if string as instances of "not"
        //end with counter == 0;

        counter = c-d;

        return counter == 0;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        String inputL = input.toLowerCase();
        int counter = 0;

        for(int i = 0; i < input.length() -1; i++) {
            char idx = inputL.charAt(i);
            int j = i+1;
            char idxplus = inputL.charAt(j);
            if (idx == 'g' && idxplus != 'g') {
                    counter++;
                }
            if (idx == 'g' && idxplus == 'g') {
                counter--;
            }
            //if this never runs counter==0 so true
            //if it does run counter>0 so false
        }

        //issue with going out of range with idxplus

        return counter == 0;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        String inputL = input.toLowerCase();
        int counter = 0;

        for(int i = 2; i < input.length()- 2; i++) {
            char idx = inputL.charAt(i);
            int j = i - 1;
            char idxplus = inputL.charAt(j);
            int k = i - 2;
            char idxdblplus = inputL.charAt(k);
            if (idx == idxplus &&  idx== idxdblplus) {
                    counter++;
                }
            }
        return counter;
    }
}
