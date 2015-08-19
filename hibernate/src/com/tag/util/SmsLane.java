package com.tag.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SmsLane {
public static String retval="";
    
public static int SendSMS(String AccountID, String Email, String Password,
String Recipient, String Message, StringBuffer Response) throws IOException
{
String RequestURL = "http://www.redoxygen.net/sms.dll?Action=SendSMS";

String Data = ("AccountId=" + URLEncoder.encode(AccountID, "UTF-8"));
Data += ("&Email=" + URLEncoder.encode(Email, "UTF-8"));
Data += ("&Password=" + URLEncoder.encode(Password, "UTF-8"));
Data += ("&Recipient=" + URLEncoder.encode(Recipient, "UTF-8"));
Data += ("&Message=" + URLEncoder.encode(Message, "UTF-8"));

int Result = -1;
URL Address = new URL(RequestURL);

HttpURLConnection Connection = (HttpURLConnection) Address.openConnection();
Connection.setRequestMethod("POST");
Connection.setDoInput(true);
Connection.setDoOutput(true);

DataOutputStream Output;
Output = new DataOutputStream(Connection.getOutputStream());
Output.writeBytes(Data);
Output.flush();
Output.close();

BufferedReader Input = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
StringBuffer ResponseBuffer = new StringBuffer();
String InputLine;

while ((InputLine = Input.readLine()) != null)
{
ResponseBuffer = ResponseBuffer.append(InputLine);
ResponseBuffer = ResponseBuffer.append("\n\n\n");
}

Response.replace(0, 0, ResponseBuffer.toString());
String ResultCode = Response.substring(0, 4);
Result = Integer.parseInt(ResultCode);
Input.close();

return Result;
}

public static void main(String[] args) throws IOException {
	
	int result=SendSMS("CI00158758","sekharreddy.arimanda@gmail.com","m4rvNpG0","9884965653","hi,how r u",new StringBuffer());
	System.out.println(result);
}


}

