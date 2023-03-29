package com.hibu.tests;


import java.io.*;

import org.zeroturnaround.zip.ZipUtil;
public class ZipIt{

public static void zipItFolder(String Sourcefolder, String DestinationZip){
try{
	ZipUtil.pack(new File(Sourcefolder), new File("DestinationZip"));
	System.out.println("Done");
}
catch(Exception e){
	e.printStackTrace();
}
}
}