package snapichatdreamteam.validations;

import snapichatdreamteam.models.LoginModel;

public class LoginValidationRule extends ValidationRule {

    @Override
    public boolean IsValid(Object model) {
       
        LoginModel lm = (LoginModel)model;
        boolean isValid =  true;
        
        
        boolean emailEmpty   = lm.getEmail()==null || lm.getEmail().length()==0;
        boolean passEmpty = lm.getPass()==null || lm.getPass().length()==0;
        
        if (emailEmpty || passEmpty){
            isValid = false;
            this.getErrors().add(Errors.FieldsCannotBeNull());
        }
        
        //TODO: Add other validations such as password=confirm password, image size and other
        return isValid;
    }
    
}