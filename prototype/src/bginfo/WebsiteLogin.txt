package bginfo;
import java.net.*;
import java.util.Scanner;


import java.io.*;
 
 
 
public class WebsiteLogin {
 
	 private static final String POST_CONTENT_TYPE = "https://hades.3s-desk.de/login.php";
	 
	 private static final String LOGIN_USER_NAME_PARAMETER_NAME = "username";
	 private static final String LOGIN_PASSWORD_PARAMETER_NAME = "password";
 
	 private static final String LOGIN_USER_NAME = "helmi";
	 private static final String LOGIN_PASSWORD = "IntiHel27";
 
	 private static final String TARGET_URL = "https://hades.3s-desk.de/login.php";
 
	    
	public static void main(String[] args) throws MalformedURLException, IOException
	{
        System.out.println("Running the program...\n");
        WebsiteLogin httpUrlBasicAuthentication = new WebsiteLogin();
        httpUrlBasicAuthentication.httpPostLogin();
        httpUrlBasicAuthentication.webScraperExample();
        
 
	}
	//quelltext ausdrucken
		public void webScraperExample () throws MalformedURLException, IOException{
		    Scanner scanner = new Scanner(new URL("https://hades.3s-desk.de/index.php?startscript=showreports.php&").openStream());
		        while(scanner.hasNextLine()){
		            System.out.println(scanner.nextLine());
		        }
		        scanner.close();
		    }
	   /**
     * The single public method of this class that
     * 1. Prepares a login message
     * 2. Makes the HTTP POST to the target URL
     * 3. Reads and returns the response
     *
     * @throws IOException
     * Any problems while doing the above.
     *
     */
    public void httpPostLogin ()
    {
        try
        {
            // Prepare the content to be written
            // throws UnsupportedEncodingException
            String urlEncodedContent = preparePostContent(LOGIN_USER_NAME, LOGIN_PASSWORD);
 
            System.out.println("chnouwa"+urlEncodedContent);

            HttpURLConnection urlConnection = doHttpPost(TARGET_URL, urlEncodedContent);
 
            String response = readResponse(urlConnection);
 
            System.out.println("Successfully made the HTPP POST.");
            
           // System.out.println("Recevied response is: '/n" + response + "'");
            Scanner scan = new Scanner(response);
            while(scan.hasNextLine()){
	            System.out.println("My Scan : "+scan.nextLine());
	        }
	        scan.close();
            
 
        }
        catch(IOException ioException)
        {
            System.out.println("Problems encounterd.");
        }
    }
 
    /**
     * Using the given username and password, and using the static string variables, prepare
     * the login message. Note that the username and password will encoded to the
     * UTF-8 standard.
     *
     * @param loginUserName
     * The user name for login
     *
     * @param loginPassword
     * The password for login
     *
     * @return
     * The complete login message that can be HTTP Posted
     *
     * @throws UnsupportedEncodingException
     * Any problems during URL encoding
     */
    private String preparePostContent(String loginUserName, String loginPassword) throws UnsupportedEncodingException
    {
        // Encode the user name and password to UTF-8 encoding standard
        // throws UnsupportedEncodingException
        String encodedLoginUserName = URLEncoder.encode(loginUserName, "UTF-8");
        String encodedLoginPassword = URLEncoder.encode(loginPassword, "UTF-8");
 
       /* String content = "login=" + LOGIN_ACTION_NAME +" &" + LOGIN_USER_NAME_PARAMETER_NAME +"="
        + encodedLoginUserName + "&" + LOGIN_PASSWORD_PARAMETER_NAME + "=" + encodedLoginPassword;*/
 
        String content = LOGIN_USER_NAME_PARAMETER_NAME +"="
        + encodedLoginUserName + "&" + LOGIN_PASSWORD_PARAMETER_NAME + "=" + encodedLoginPassword;
 
        return content;
 
    }
 
    /**
     * Makes a HTTP POST to the target URL by using an HttpURLConnection.
     *
     * @param targetUrl
     * The URL to which the HTTP POST is made.
     *
     * @param content
     * The contents which will be POSTed to the target URL.
     *
     * @return
     * The open URLConnection which can be used to read any response.
     *
     * @throws IOException
     */
    public HttpURLConnection doHttpPost(String targetUrl, String content) throws IOException
    {
        HttpURLConnection urlConnection = null;
        DataOutputStream dataOutputStream = null;
        try
        {
            // Open a connection to the target URL
            // throws IOException
            urlConnection = (HttpURLConnection)(new URL(targetUrl).openConnection());
 
            // Specifying that we intend to use this connection for input
            urlConnection.setDoInput(true);
 
            // Specifying that we intend to use this connection for output
            urlConnection.setDoOutput(true);
 
            // Specifying the content type of our post
            urlConnection.setRequestProperty("Content-Type", POST_CONTENT_TYPE);
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.2.8) Gecko/20100722 Firefox/3.6.8");
 
            HttpURLConnection.setFollowRedirects(true);
            // Specifying the method of HTTP request which is POST
            // throws ProtocolException
            urlConnection.setRequestMethod("POST");
 
            // Prepare an output stream for writing data to the HTTP connection
            // throws IOException
            dataOutputStream = new DataOutputStream(urlConnection.getOutputStream());
 
            // throws IOException
            dataOutputStream.writeBytes(content);
            dataOutputStream.flush();
            dataOutputStream.close();
 
            return urlConnection;
        }
        catch(IOException ioException)
        {
            System.out.println("I/O problems while trying to do a HTTP post.");
            ioException.printStackTrace();
 
            // Good practice: clean up the connections and streams
            // to free up any resources if possible
            if (dataOutputStream != null)
            {
                try
                {
                    dataOutputStream.close();
                }
                catch(Throwable ignore)
                {
                    // Cannot do anything about problems while
                    // trying to clean up. Just ignore
                }
            }
            if (urlConnection != null)
            {
                urlConnection.disconnect();
            }
 
            // throw the exception so that the caller is aware that
            // there was some problems
            throw ioException;
        }
    }
 
    /**
     * Read response from the URL connection
     *
     * @param urlConnection
     * The URLConncetion from which the response will be read
     *
     * @return
     * The response read from the URLConnection
     *
     * @throws IOException
     * When problems encountered during reading the response from the
     * URLConnection.
     */
    private String readResponse(HttpURLConnection urlConnection) throws IOException
    {
 
        BufferedReader bufferedReader = null;
        try
        {
            // Prepare a reader to read the response from the URLConnection
            // throws IOException
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String responeLine;
 
            // Good Practice: Use StringBuilder in this case
            StringBuilder response = new StringBuilder();
 
            // Read until there is nothing left in the stream
            // throws IOException
            while ((responeLine = bufferedReader.readLine()) != null)
            {
                response.append(responeLine);
            }
 
            return response.toString();
        }
        catch(IOException ioException)
        {
            System.out.println("Problems while reading the response");
            ioException.printStackTrace();
 
            // throw the exception so that the caller is aware that
            // there was some problems
            throw ioException;
 
        }
        finally
        {
            // Good practice: clean up the connections and streams
            // to free up any resources if possible
            if (bufferedReader != null)
            {
                try
                {
                    // throws IOException
                    bufferedReader.close();
                }
                catch(Throwable ignore)
                {
                    // Cannot do much with exceptions doing clean up
                    // Ignoring all exceptions
                }
            }
 
        }
    }
 
}

