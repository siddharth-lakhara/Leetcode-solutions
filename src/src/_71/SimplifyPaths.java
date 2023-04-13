package _71;

import java.util.ArrayList;

public class SimplifyPaths {
    public String simplifyPath(String path) {
        ArrayList<String> pathsArray = new ArrayList<>();
        pathsArray.add("");
        
        int idx = path.charAt(0) == '/' ? 1 : 0;

        StringBuilder sb = new StringBuilder();
        while (idx < path.length()) {
            if (path.charAt(idx) == '/') {
                if (sb.length() > 0) {
                    String newStr = sb.toString();
                    if (newStr.equals("..")) {
                        if (pathsArray.size() > 1) {
                            pathsArray.remove(pathsArray.size()-1);    
                        }
                    } else if (!newStr.equals(".")) {
                        pathsArray.add(sb.toString());    
                    }
                    sb.setLength(0);    
                }
            } else {
                sb.append(path.charAt(idx));
            }
            idx++;
        }

        if (sb.length() > 0) {
            String newStr = sb.toString();
            if (newStr.equals("..")) {
                if (pathsArray.size() > 1) {
                    pathsArray.remove(pathsArray.size()-1);
                }
            } else if (!newStr.equals(".")) {
                pathsArray.add(sb.toString());
            }
            sb.setLength(0);
        }
        
        if (pathsArray.size() > 1) {
            return String.join("/", pathsArray);    
        }
        return "/";
    }
    
    public void driver() {
        String s = "/home/dir/../something/./dir3";
        String answer = simplifyPath(s);
        System.out.println(answer);
    }
}
