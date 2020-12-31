package com.edu.pars.dom;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class UtilsDOM {
    public static boolean isElement(Node node){
        if (node instanceof Element){
            return true;
        }
        return false;
    }
    public static boolean isCorrect(Node node){
        if (!node.getTextContent().trim().isEmpty()
                &&
                !((Text)node.getFirstChild()).getData().trim().isEmpty()
                && !((Text)node.getFirstChild()).getData().trim().equals("\n")
        ) return true;
        return false;
    }
}
