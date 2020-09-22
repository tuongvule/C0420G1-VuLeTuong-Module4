package tuongvule.com.furamaspringboot.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Khai báo một custom annotation, PhoneNumberValidator là class để kiểm tra regex
 * ElementType.METHOD, ElementType.FIELD: cách thức để đặt @PhoneNumber ở trường (FIELD) hoặc METHOD nào)
 */
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    // trường message là bắt buộc, khai báo nội dung sẽ trả về khi field k hợp lệ
    String message() default "CustomerCode doesn't match pattern.";
    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<?>[] groups() default {};
    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
    Class<? extends Payload>[] payload() default {};
}
