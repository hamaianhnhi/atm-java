package com.app.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {

	private Document document;
	
	/**
	 * 
	 * @param filePath
	 */
	public XMLReader (String filePath) {
		 try {
		 
			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			this.document=doc;

		    } catch (Exception e) {
			e.printStackTrace();
	    }
	}
	
	/**
	 * get Data from one field by Field name
	 * @param key
	 * @return
	 */
	public List<String> getDatasetBy (String key) {
		
		this.document.getDocumentElement().normalize();
	 
//		System.out.println("Root element :" + this.document.getDocumentElement().getNodeName());
	 
		NodeList nList = this.document.getElementsByTagName("case");
		List<String> arrData = new ArrayList<String>(); 
	 
//		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
//			System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
	 
				arrData.add(eElement.getElementsByTagName(key).item(0).getTextContent());
	 
			}
		}
		return arrData;
		
	}
	
	
}
