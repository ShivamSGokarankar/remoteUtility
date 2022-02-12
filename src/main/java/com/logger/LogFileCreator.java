package com.logger;
import java.io.*;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LogFileCreator {
    private String filepath;
    private StringBuffer sb = new StringBuffer("Log");
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    public PrintWriter p;

    public LogFileCreator(String filepath) throws IOException
    {
        this.filepath=filepath;
        String filename=sb.toString().concat(java.time.LocalDate.now().toString());
        this.file = new File(this.filepath,filename);
        this.fileWriter= new FileWriter(file,true);
        if(!file.exists())
        {
            file.createNewFile();
        }
        p= new PrintWriter(fileWriter);
    }

    public void WriteLog(String logMessage)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        p.println(java.time.LocalDateTime.now().format(formatter) + " : " + logMessage);
        p.flush();
    }
    public void closeStream()
    {
        p.close();
    }
}