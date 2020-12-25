package com.edu.pars;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import static com.edu.pars.Utility.isCorrect;
import static com.edu.pars.Utility.isElement;

public class TablePrinter {
    public static void printTableHeader(NodeList nodeList){
        Node node;
        for (int i = 0; i < nodeList.getLength(); i++){
            node = nodeList.item(i);
            if (isElement(node)){
                if (node.getNodeName().equals("id")) {
                    System.out.format("%7s", node.getNodeName() + " || ");
                }
                if (node.getNodeName().equals("name")){
                    System.out.format("%50s", node.getNodeName() + " || ");
                }
                if (node.getNodeName().equals("author")){
                    System.out.format("%15s", node.getNodeName() + " || ");
                }
                if (node.getNodeName().equals("createDate")){
                    System.out.format("%15s", node.getNodeName() + " || ");
                }
                if (node.getNodeName().equals("tasks")){
                    System.out.format("%15s", node.getNodeName() + " || ");
                }
            }
        }
        System.out.println();
        System.out.print("====================================================");
        System.out.println("=================================================");
    }

    public static void printTableValues(NodeList nodeList){
        Node node;
        for (int i = 0; i < nodeList.getLength(); i++){
            node = nodeList.item(i);
            if (isElement(node)) {
                String value="";
                if (isCorrect(node)){
                    Text text = (Text) node.getFirstChild();
                    value = text.getData().trim();
                }
                if (node.getNodeName().equals("id")) {
                    System.out.format("%7s", value + " || ");
                }
                if (node.getNodeName().equals("name")){
                    System.out.format("%50s", value + " || ");
                }
                if (node.getNodeName().equals("author")){
                    System.out.format("%15s", value + " || ");
                }
                if (node.getNodeName().equals("createDate")){
                    System.out.format("%15s", value + " || ");
                }
                if (node.getNodeName().equals("tasks")){
                    value = printTaskList(node.getChildNodes());
                    System.out.format("%15s", value + " || ");
                }
            }
        }
        System.out.println();
    }

    public static String printTaskList(NodeList nodeList){
        String taskStr = "[";
        Node node;
        for (int i = 0; i < nodeList.getLength() - 1; i++) {
            node = nodeList.item(i);
            if (isElement(node)) {
                String value = "";
                if (isCorrect(node)) {
                    Text text = (Text) node.getFirstChild();
                    value = text.getData().trim();
                }
                if (i == nodeList.getLength() - 2) {
                    taskStr = taskStr + value;
                } else {
                    taskStr = taskStr + value + ",";
                }
            }
        }
        taskStr += "]";
        return taskStr;
    }
}
