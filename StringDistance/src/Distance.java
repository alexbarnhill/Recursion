public class Distance {

    public static int strDist(String haystack, String needle) {
        if(haystack.length() == 0 || !haystack.contains(needle)) {
            return 0;
        } else {
            return needle.length() + haystack.substring(haystack.indexOf(needle), haystack.lastIndexOf(needle)).length();
        }

    }

    public static int strDist2(String haystack, String needle) {
        if(haystack.length() == 0 || !haystack.contains(needle)) {
            return 0;
        } else if(haystack.indexOf(needle) != 0) {
            return strDist2(haystack.substring(1, haystack.length() -1), needle);

        } else {
            return needle.length() + haystack.substring(needle.length() -1, haystack.lastIndexOf(needle) - 1).length() + needle.length();
        }
    }

    public static void main(String[] args) {
        System.out.println(strDist2("catcowcat", "cat"));
        System.out.println(strDist("catcowcat", "cow"));
        System.out.println(strDist2("cccatcowcatxx", "cat"));
    }
}
