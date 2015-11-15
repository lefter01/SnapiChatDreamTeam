/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapichatdreamteam.resources;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataParam;
import snapichatdreamteam.helpers.PasswordHash;
import snapichatdreamteam.models.RegisterModel;
import snapichatdreamteam.validations.RegisterValidationRule;
import snapichatdreamteam.validations.ValidationRule;



/**
 * REST Web Service
 *
 * @author Rin0a
 */
@Path("account")
public class AccountResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AccountResource
     */
    public AccountResource() {
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String uploadFile(@FormDataParam("image") InputStream image, 
            @FormDataParam("first_name") String fName,
            @FormDataParam("last_name") String lName,
            @FormDataParam("user_name") String uName,
            @FormDataParam("email") String email,
            @FormDataParam("password") String pass,
            @FormDataParam("password_confirmation") String conPass,
            @FormDataParam("country") String country,
            @FormDataParam("phone") String phone,
            @FormDataParam("city") String city)  {
      
        RegisterModel rm = new RegisterModel(InputStreamToBYtes(image), fName, lName, email, phone, city, country, uName, pass, conPass);
        ValidationRule registrRule = new RegisterValidationRule();
 
       
        if (registrRule.IsValid(rm)){
            //TODO: Add the connection string to a configuration file
            //TODO: Move all this database stuff to repository classes
            Connection con = null;
           
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snapchatdb","root","zkpovolz01");
                
                 String SQL_INSERT = "INSERT INTO user" + " VALUES(NULL,?,?,?,?,?,?,?,?,?)";
                 PreparedStatement statement = con.prepareStatement(SQL_INSERT);
                 statement.setString(1, rm.getUsername());
                 
                try {
                   statement.setString(2, PasswordHash.createHash(rm.getPass())); 
                   
                } catch (NoSuchAlgorithmException ex) {
                   
                } catch (InvalidKeySpecException ex) {
                  
                }
                 
                 statement.setString(3, rm.getEmail());
                 statement.setString(4, rm.getPhone());
                 statement.setString(5, rm.getCity());
                 statement.setString(6, rm.getCountry());
                 statement.setBytes(7, rm.getImage());
                 statement.setString(8, rm.getfName());
                 statement.setString(9, rm.getlName());
                 statement.executeUpdate();
            } catch (SQLException ex) {
               //TODO: Add logging
            }finally{
                if (con!=null){
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        
                    }
                }
            }
          
        }else{
          return registrRule.toString();
        }
        

       
        return "You have successfully register. Please sign in";
    }
    
    @POST
    @Path("/profile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserProfile(string userName)  {
      
        RegisterModel rm = new RegisterModel(InputStreamToBYtes(image), fName, lName, email, phone, city, country, uName, pass, conPass); //new register for profilegetdata
        
        //TODO: Add the connection string to a configuration file
        //TODO: Move all this database stuff to repository classes
        Connection con = null;
           
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snapchatdb","root","zkpovolz01");
            
            String SQL_SELECT = "SELECT username, user_phone_num, user_city, user_city, user_country FROM user WHERE username = 'nat';";
            PreparedStatement statement = con.prepareStatement(SQL_SELECT);
                 statement.setString(1, rm.getUsername());
                 
                try {
                   statement.setString(2, PasswordHash.createHash(rm.getPass())); 
                   
                } catch (NoSuchAlgorithmException ex) {
                   
                } catch (InvalidKeySpecException ex) {
                  
                }
                 
                 statement.setString(3, rm.getEmail());
                 statement.setString(4, rm.getPhone());
                 statement.setString(5, rm.getCity());
                 statement.setString(6, rm.getCountry());
                 statement.setBytes(7, rm.getImage());
                 statement.setString(8, rm.getfName());
                 statement.setString(9, rm.getlName());
                 statement.executeUpdate();
            } catch (SQLException ex) {
               //TODO: Add logging
            }finally{
                if (con!=null){
                    try {
                        con.close();
                    } catch (SQLException ex) {
                        
                    }
                }
            }
            
        return ""; // make the profile.html as string in the ""
    }
    
    private byte[] InputStreamToBYtes(InputStream is){
        ByteArrayOutputStream outpuStream = null;
                
        try {
            int read = 0;
            byte[] bytes = new byte[1024];
            outpuStream = new ByteArrayOutputStream();
            while ((read = is.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }
            outpuStream.flush();
            outpuStream.close();
        } catch (IOException iox) {
            iox.printStackTrace();
        } finally {
            if (outpuStream != null) {
                try {
                    outpuStream.close();
                } catch (Exception ex) {
                }
            }
        }
        return outpuStream.toByteArray();
    }

}
