/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapichatdreamteam.validations;

/**
 *
 * @author Rin0a
 */
public final class  Errors {
    
    public static ValidationError FieldsCannotBeNull(){
        ValidationError er = new ValidationError();
        er.setCode(101);
        er.setMessage("Please specify email, username, password and confirm password");
        return er;
    }

}
