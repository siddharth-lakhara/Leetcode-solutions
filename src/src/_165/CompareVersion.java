package _165;

public class CompareVersion {
    private String[] ver1Split;
    private String[] ver2Split;

    public int compareVersion(String version1, String version2) {
        ver1Split = version1.split("\\.");
        ver2Split = version2.split("\\.");

        int idx = 0;
        return recursiveCompare(idx);
    }

    public int recursiveCompare(int idx) {
        if (idx >= ver1Split.length && idx >= ver2Split.length)
            return 0;

        int ver1Frag = idx >= ver1Split.length ? 0 : Integer.parseInt(ver1Split[idx]);
        int ver2Frag = idx >= ver2Split.length ? 0 : Integer.parseInt(ver2Split[idx]);

        if (ver1Frag > ver2Frag) {
            return 1;
        } else if (ver1Frag < ver2Frag) {
            return -1;
        } else {
            return recursiveCompare(++idx);
        }
    }

    public void driver() {
        String version1 = "1.00001";
        String version2 = "1.01";
        int answer = compareVersion(version1, version2);
        System.out.println(answer);
    }
}
