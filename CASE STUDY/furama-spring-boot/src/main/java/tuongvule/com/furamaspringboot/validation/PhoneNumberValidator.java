package tuongvule.com.furamaspringboot.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

   public boolean isValid(String input, ConstraintValidatorContext context) {
      if(input.length() < 10 || input.length()>11){
         context.disableDefaultConstraintViolation();
         context.buildConstraintViolationWithTemplate("length must be from 10 to 11.").addConstraintViolation();
         return false;
      }
      if(!input.startsWith("09")){
         context.disableDefaultConstraintViolation();
         context.buildConstraintViolationWithTemplate("number must start with: '09'").addConstraintViolation();
         return false;
      }
      return true;
   }

   public void initialize(PhoneNumber constraint) {
   }
}
