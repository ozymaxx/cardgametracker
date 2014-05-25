/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgametrackercs319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import static org.apache.http.HttpHeaders.USER_AGENT;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *  This class satisfies the connection with the database
 * 
 * @author GroupA Spring 2014
 */

class DBConnectionManager {
    public static String saveTrackScores( TrackEngine engine) throws UnsupportedEncodingException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost( "http://ozymaxx.net/cs319/save_tracks_scores.php");
        
        post.setHeader( "User-Agent", USER_AGENT);
        ArrayList<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add( new BasicNameValuePair( "info", engine.getJSON() ) );
        
        post.setEntity( new UrlEncodedFormEntity( urlParameters) );
        
        HttpResponse response = client.execute( post);
        BufferedReader reader = new BufferedReader( new InputStreamReader( response.getEntity().getContent() ) );
        StringBuffer result = new StringBuffer();
        String resLine = "";
        
        while ( (resLine = reader.readLine() ) != null) {
            result.append( resLine);
        }
        
        return result.toString();
    }
    
    public static String registerUserInfo( String id, String name, String pwd) throws UnsupportedEncodingException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost( "http://ozymaxx.net/cs319/register_user.php");
        
        post.setHeader( "User Agent", USER_AGENT);
        ArrayList<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add( new BasicNameValuePair( "id", id) );
        urlParameters.add( new BasicNameValuePair( "pname", name) );
        urlParameters.add( new BasicNameValuePair( "pwd", pwd) );
        
        post.setEntity( new UrlEncodedFormEntity( urlParameters) );
        
        HttpResponse response = client.execute( post);
        BufferedReader reader = new BufferedReader( new InputStreamReader( response.getEntity().getContent() ) );
        StringBuffer result = new StringBuffer();
        String res = "";
        
        while ( ( res = reader.readLine() ) != null  ) {
            result.append( res);
        }
        
        return result.toString();
    }
    
    public static String getPlayerInfo( String playerID) throws UnsupportedEncodingException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost( "http://ozymaxx.net/cs319/player_info.php");
        
        post.setHeader( "User-Agent", USER_AGENT);
        ArrayList<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add( new BasicNameValuePair( "pid", playerID ) );
        
        post.setEntity( new UrlEncodedFormEntity( urlParameters) );
        
        HttpResponse response = client.execute( post);
        BufferedReader reader = new BufferedReader( new InputStreamReader( response.getEntity().getContent() ) );
        StringBuffer result = new StringBuffer();
        String resLine = "";
        
        while ( (resLine = reader.readLine() ) != null) {
            result.append( resLine);
        }
        
        return result.toString();
    }
}
