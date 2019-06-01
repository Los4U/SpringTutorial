package tutorial.demo.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
   private String coursePrefix;

   public void initialize(CourseCode theCourseCode) {
      coursePrefix = theCourseCode.value();
   }

   public boolean isValid(String theCode, ConstraintValidatorContext context) {
      boolean result;

      if(theCode != null){
         result = theCode.startsWith(coursePrefix);
      }
      else{
         result = true;
      }
      return result;
   }
}
