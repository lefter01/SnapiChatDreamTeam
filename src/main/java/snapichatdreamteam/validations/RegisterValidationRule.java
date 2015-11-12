/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapichatdreamteam.validations;

import snapichatdreamteam.models.RegisterModel;

/**
 *
 * @author Rin0a
 */
public class RegisterValidationRule extends ValidationRule {

    @Override
    public boolean IsValid(Object model) {
       
        RegisterModel rm = (RegisterModel)model;
        boolean isValid =  true;
        
        
        boolean emailEmpty   = rm.getEmail()==null || rm.getEmail().length()==0;
        boolean usernameEmpty = rm.getUsername()==null || rm.getUsername().length()==0;
        boolean passEmpty = rm.getPass()==null || rm.getPass().length()==0;
        boolean conPassEmpty = rm.getcPass()==null || rm.getcPass().length()==0;
        
        if (emailEmpty || usernameEmpty || passEmpty || conPassEmpty){
            isValid = false;
            this.getErrors().add(Errors.FieldsCannotBeNull());
        }
        
        //TODO: Add other validations such as password=confirm password, image size and other
        return isValid;
    }
    
}
