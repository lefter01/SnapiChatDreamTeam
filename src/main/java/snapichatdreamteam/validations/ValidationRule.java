/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snapichatdreamteam.validations;

import java.util.ArrayList;

/**
 *
 * @author Rin0a
 */
  public abstract class ValidationRule
    {
        private ArrayList<ValidationError> errors;
        
        public ValidationRule()
        {
            errors = new ArrayList<ValidationError>();
        }
        public abstract boolean IsValid(Object model);

        public ArrayList<ValidationError> getErrors() {
            return errors;
        }

    @Override
    public String toString() {
        String mes = "";
        for (int i=0;i<errors.size();i++){
            mes+=errors.get(i).toString();
        }
        return mes;
    }
        
        

    }
